public class BFSTraversal
{
    Algorithm getBreadthFirstTraversal(originVertex)
    traversalOrder = a new queue for the resulting traversal order
    vertexQueue = a new queue to hold vertices as they are visited
    Mark originVertex as visited
    traversalOrder.enqueue(originVertex)
    vertexQueue.enqueue(originVertex)
    while (!vertexQueue.isEmpty())
    {
    frontVertex = vertexQueue.dequeue()
    while (frontVertex has a neighbor)
    {
    nextNeighbor = next neighbor of frontVertex
    if (nextNeighbor is not visited)
    {
    Mark nextNeighbor as visited
    traversalOrder.enqueue(nextNeighbor)
    vertexQueue.enqueue(nextNeighbor)
    }
    }
    }
    return traversalOrder
}