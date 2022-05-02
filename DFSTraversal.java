public class DFSTraversal
{
    Algorithm getDepthFirstTraversal(originVertex)
    traversalOrder = a new queue for the resulting traversal order
    vertexStack = a new stack to hold vertices as they are visited
    Mark originVertex as visited
    traversalOrder.enqueue(originVertex)
    vertexStack.push(originVertex)
    while (!vertexStack.isEmpty())
    {
    topVertex = vertexStack.peek()
    if (topVertex has an unvisited neighbor)
    {
    nextNeighbor = next unvisited neighbor of topVertex
    Mark nextNeighbor as visited
    traversalOrder.enqueue(nextNeighbor)
    vertexStack.push(nextNeighbor)
    }
    else // All neighbors are visited
    vertexStack.pop()
    }
    return traversalOrder

}
