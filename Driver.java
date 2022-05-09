public class Driver
{
   public static Graph<String> buildGraph()
	{
		Graph<String> graph = new Graph<String>(9);
		
		graph.setLabel(0, "A");
		graph.setLabel(1, "B");
		graph.setLabel(2, "C");
		graph.setLabel(3, "D");
		graph.setLabel(4, "E");
		graph.setLabel(5, "F");
		graph.setLabel(6, "G");
		graph.setLabel(7, "H");
		graph.setLabel(8, "I");
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(2, 1);
		graph.addEdge(3, 6);
		graph.addEdge(4, 7);
		graph.addEdge(4, 5);
		graph.addEdge(5, 2);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8, 5);
		
		return graph;
	}
	
	public static String outputGraphTraversal(QueueInterface<String> traversal)
	{
		String answer = new String();
		while (!traversal.isEmpty())
		{
			answer = answer + traversal.dequeue().toString() ;
		}
		
		return answer;
	}

   public static void main (String[] args) throws Exception
   {
      Graph<String> BFT = new Graph<String>(9);
      String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
      for(int i = 0; i < alpha.length; i++)
        BFT.setLabel(i, alpha[i]);
     BFT.addEdge(0, 1);
     BFT.addEdge(0, 3);
     BFT.addEdge(0, 4);
     BFT.addEdge(1, 4);
     BFT.addEdge(2, 1);
     BFT.addEdge(3, 6);
     BFT.addEdge(4, 5);
     BFT.addEdge(4, 7);
     BFT.addEdge(5, 2);
     BFT.addEdge(5, 7);
     BFT.addEdge(6, 7);
     BFT.addEdge(7, 8); 
     BFT.addEdge(8, 5);

      QueueInterface<String> test;
      test = BFT.BFSTraversal(0);
      while (!test.isEmpty())
      {
         System.out.print(test.dequeue());
      }

      System.out.println();
      Graph<String> graph = buildGraph();
	  String origin = new String( "B" );
      QueueInterface<String> dft = graph.DFSTraversal(origin);
		System.out.println(outputGraphTraversal(dft));
   }   
}
