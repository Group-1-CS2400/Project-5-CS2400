import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
public class BFSTraversal implements graphInterface 
{
    public void addVertex(String label) 
    {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }
    
    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }
    public void addEdge(String label1, String label2) 
    {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }
    public void removeEdge(String label1, String label2) 
    {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }
    
    public void BFSTraverse()
    {

    }    



}
//    traversalOrder = a new queue for the resulting traversal order
//     vertexQueue = a new queue to hold vertices as they are visited
//     Mark originVertex as visited
//     traversalOrder.enqueue(originVertex)
//     vertexQueue.enqueue(originVertex)
//     while (!vertexQueue.isEmpty())
//     {
//     frontVertex = vertexQueue.dequeue()
//     while (frontVertex has a neighbor)
//     {
//     nextNeighbor = next neighbor of frontVertex
//     if (nextNeighbor is not visited)
//     {
//     Mark nextNeighbor as visited
//     traversalOrder.enqueue(nextNeighbor)
//     vertexQueue.enqueue(nextNeighbor)
//     }
//     }
//     }
//     return traversalOrder
}