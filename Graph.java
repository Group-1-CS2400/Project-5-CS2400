import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;
public class Graph<String>
{
    private boolean[][] graphEdges; 
    private String[] graphLabels; 
    private boolean[] visitedNodes;
//This initializes a graph by itself without any values in order to have the graph made for input by the driver.
// A constructor method for the graph 
    public Graph(int n)
    {
        graphLabels = (String[]) new Object[n]; 
        visitedNodes= new boolean[graphLabels.length];
        graphEdges = new boolean[n][n];
        //since the value of the array is starting at 0 the lenght must also take into account the 0 value.
        for (int i=0;i<=graphLabels.length-1;i++)
        //checks to see if the node itself is visited and marks it false because all these node values are null/not true 
			visitedNodes[i]=false;
    }
/*
 * 
 * 
 * These methods all declare the labels and edges, allowing us to add whatever node we chose to
 * The neighbor method works to show the neighbor and what is connected to what
 * these connections and labels all are defined in the driver and allow the user or coder to alter the code without coming here
 * 
 * 
 * 
 */
 // Allows us to set the vertex instead of having just 1` static one that we cannot manipulate and search through after we do it
    public void setLabel(int vertex, String newLabel)
    {
       graphLabels[vertex] = newLabel;
    }  
//lets us see what is the vertex at the current position of the code and loop
    public String getLabel(int vertex)
    {
        System.out.println(graphLabels[vertex]);
        return graphLabels[vertex];
    }
   
 // establishes the method to add a link between nodes/vertexes in the driver file.
    public void addEdge(int source, int target)
    {
        graphEdges[source][target] = true;
    }
//returns a boolean value on weather or not we established a link between the vertex and their neighbor in the driver file.
    public boolean isEdge(int source, int target)
    {
        return graphEdges[source][target];
    }
    /*
    * This method is allowing the code to view the neighbors of the vertex that we assigned
    * gives us the direct link from the vertex to whatever we choose to connect it to
    */
    public int[] neighbors(int vertex)
    {
        int i;
        int[] answer;
        int count = 0;
        

        for(i = 0; i <graphLabels.length; i++)
        {
            if(graphEdges[vertex][i])
                count++;
        }
        answer = new int[count];
        count = 0;
        for(i = 0; i <graphLabels.length; i++)
        {
            if(graphEdges[vertex][i])
                answer[count++] = i;
        }

        return answer;
    }
    public QueueInterface<String> BFSTraversal (int originVertex)
    { 
        //we established 2 queues to store what we passed by and what we visited
        // also established a list array that will tell us if we have visted the vertex's neighbors before
        boolean[] visitedNodes = new boolean[(graphLabels.length)];
        QueueInterface<String> vertQueue = new ArrayQueue<>(); //stfu error bitch
        QueueInterface<String> travQueue = new ArrayQueue<>();
       
        visitedNodes[0]= true; //this is the vertex
        
        return travQueue;
    }

}
