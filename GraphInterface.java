import java.util.List;
import java.util.Map;
public interface graphInterface {
    class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        public Object remove(graphInterface.Vertex v) {
            return null;
        }
    
        // equals and hashCode
    }
    class Graph {
        private Map<Vertex, List<Vertex>> adjVertices;

        public void addVertex(String string) {
        }

        public void addEdge(String string, String string2) {
        }
        
        // standard constructor, getters, setters
    }
    public void addVertex(String label);
    //Stolen from online bc ur mom
    public void removeVertex(String label);
    ////Stolen from online bc ur mom
    public void addEdge(String label1, String label2);
    ////Stolen from online bc ur mom
    public void removeEdge(String label1, String label2);
    //Stolen from online bc ur mom
}
