public class Graph<T>
{


    //This constructer lets us make the graph empty before filling it out 
    //Setting the open arrays to allow us to construct the graph. 
    private boolean[][] edges; 
    private T[] labels;
    private boolean[] visitedVertices;

    public Graph(int initialize){
        edges = new boolean[initialize][initialize]; 
        labels = (T[]) new Object[initialize]; 
        visitedVertices = new boolean[labels.length];
        for (int i=0;i<=labels.length-1;i++)
			visitedVertices[i]=false;
    }
//----------------------------------------------------------------------------------------------------------------//
   /*
   //These methods all work to establish what we need for the BFS traversal method 
   //The focus of these methods is to mark the linkage between the nodes and their respective neighbors in the driver
   //In the driver we marked the string values and letters to the corresponding integer values and weights
   // by setting the "target values" as the neighbors to the vertex or specific node that is connected , we establish the link
   // getting and setting these links here allows us to use it later on in the file.
   */

    public T getLabel(int vertex)
    {
        return labels[vertex];
    }

    public boolean isEdge(int source, int target)
    {
        return edges[source][target];
    }

    public void addEdge(int source, int target)
    {
        edges[source][target] = true;
    }

 
    public int[] neighbors(int vertex)
    {
        int countNumber;
        int count = 0;
        int[] answer;

        for(countNumber = 0; countNumber < labels.length; countNumber++)
        {
            if(edges[vertex][countNumber])
                count++;
        }
        answer = new int[count];
        count = 0;
        for(countNumber = 0; countNumber < labels.length; countNumber++)
        {
            if(edges[vertex][countNumber])
                answer[count++] = countNumber;
        }

        return answer;
    }


    //Remove an edge
    public void removeEdge(int source, int target)
    {
        edges[source][target] = false;
    }

    //Change the label of a vertex of this Graph
    public void setLabel(int vertex, T newLabel)
    {
        labels[vertex] = newLabel;
    }

    //Accessor method to determine the number of vertices in this Graph
    public int size()
    {
        return labels.length;
    }
    //------------------------------------------------------------------------------------------------------------//
    /*
    //These next methods are all meant for the depth traversal
    // In depth traversal, the goal of the vertex and its neighbors is to go as far as possible before retracting nodes.
    // By setting these methods up, we can see where we have been and where we need to go to access nodes that havent been 
    // accessed before. 
    */
    private int getVertexIndex(T vertex)
	{
		int vertexIndex = 0;
		while (!vertex.equals(labels[vertexIndex]))
		{
			vertexIndex++;
		}
		return vertexIndex;
	}

    private void markedVisNode(T vertex)
	{
		int vertexIndex = getVertexIndex(vertex);
		visitedVertices[vertexIndex] = true;
	}
	
	private boolean hasUnvisitedNeighbor(T vertex)
	{
		int vertexIndex = getVertexIndex(vertex);
		
		int[] neighbors = neighbors(vertexIndex);
		boolean hasUnvisited = false;
		for (int nextNeighbor = 0; nextNeighbor <= neighbors.length - 1; nextNeighbor++)
		{
			if (!visitedVertices[neighbors[nextNeighbor]])
			{
				hasUnvisited = true;
				nextNeighbor = neighbors.length;
			}
		}
		return hasUnvisited;
	}
	
	private T getNextUnvisitedNeighbor(T vertex)
	{
		int vertexIndex = getVertexIndex(vertex);
		
		int[] neighbors = neighbors(vertexIndex);
		T nextUnvisitedNeighbor = labels[0];
		for (int nextNeighbor = 0; nextNeighbor <= neighbors.length - 1; nextNeighbor++)
		{
			if (!visitedVertices[neighbors[nextNeighbor]])
			{
				nextUnvisitedNeighbor = labels[neighbors[nextNeighbor]];
				nextNeighbor = neighbors.length;
			}
		}
		return nextUnvisitedNeighbor;
	}
    //------------------------------------------------------------------------------------------------------------//

    public QueueInterface<T> BFSTraversal(int originVertex)
    {
        T nextNeighbor;
        int[] neighbors;
        T frontVert;
        int frontVertNum = originVertex;
        //The initialization of the queues used to house all the nodes and their respective integer values 
        QueueInterface<T> travQueue = new ArrayQueue<>();
        QueueInterface<T> vertQueue = new ArrayQueue<>();
        boolean[] visited = new boolean[(labels.length)];
        //Sets the vertex already to the vertex provided, we mark the vertex here
        //the marked vertex allows us to run the rest of the linked nodes.
        visited[0] = true;
        travQueue.enqueue(labels[0]);
        vertQueue.enqueue(labels[0]);
        //This while loop changes the vertex to the newest neighbor, 
        // allowing it to run through the algorithm to detect its neighbors and report it to the vertQueue
        // In the while loop, there is a for loop that allows a check to see if the vertex has --->
        // 1) been assigned already, or 2) has a neighbor,
        //If it has a neighbor, it runs through the process of adding it to the vertex queue 
        // and the vertex queue we just assigned to the traversal queue--> (what we report)
        while(!vertQueue.isEmpty()) 
        {
            //takes out the node from the vertex queue because we have now visited the node and made it the new vertex
            frontVert = vertQueue.dequeue();
            //checks to see if the vertex is a new vertex or a mistake in code
            for(int i = 0; i < labels.length; i++) 
                if(labels[i] == frontVert)
                    frontVertNum = i;
            //If the vertex has neighbors the code is run and allows the algorithm to add those neighbors to the queue
            if(neighbors(frontVertNum).length != 0 ) 
            {
                //The algorithm that was written for the neighbors method is run and that allows us to 
                //see the number of edges and nodes connected to the specific vertex we have highlighted.
                neighbors = neighbors(frontVertNum);
                for(int i = 0; i < neighbors.length; i++)
                {
                    nextNeighbor = labels[neighbors[i]];                    
                   
                   //if the nodes that are seen to be connected have not been visited and marked,
                   // add the node to the vertQueue and the vertex we are now on to the traveQueue
                    if(!visited[neighbors[i]])
                    {
                        visited[neighbors[i]] = true;
                        travQueue.enqueue(nextNeighbor);
                        vertQueue.enqueue(nextNeighbor);
                    }
                }
            }
        }
        return travQueue;
    }
//-------------------------------------------------------------------------------------------------------------------//
    public QueueInterface<T> DFSTraversal(T origin)
	{
        // The DFS Traversal method is very much like the BFS traversal method.
        // the only change is the stack used to house the nodes on what we have taken to get to the current vertex
        // this is because depth traversal is more like a chain link in that we record the nodes we pass by
        // every time we pop it out the stack.
        StackInterface<T> vertexStack = new LinkedStack<T>();
		QueueInterface<T> travQueue = new ArrayQueue<T>();
		
        //Just like BFS Traversal, we set up the origin as the orignal vertex with the priority designation as 0
        // From there we can continue as normal.
		visitedVertices[0] = true;

		travQueue.enqueue(labels[getVertexIndex(origin)]);
		vertexStack.push(labels[getVertexIndex(origin)]);

		while (!vertexStack.isEmpty())
		{
            // THE BIG DIFFERENCE BETWEEN THIS AND BFS 
            // We pop the top of the visited stack.
            // This lets us add on to the traversal queue and report it. 
			T topVertex = vertexStack.peek();
			if (hasUnvisitedNeighbor(topVertex))
			{
				T nextNeighbor = getNextUnvisitedNeighbor(topVertex);
				markedVisNode(nextNeighbor);
				travQueue.enqueue(nextNeighbor);
				vertexStack.push(nextNeighbor);
			}
			else
            // This is the catch to help us pop the node if the node is already visited and added to the stack
			{
				vertexStack.pop();
			}
		}
		
		return travQueue;
	}
}
