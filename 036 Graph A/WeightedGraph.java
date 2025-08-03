import java.util.*;

// Edge with source, destination, and weight
class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class WeightedGraph {
    int vertices;
    List<List<Edge>> adjList;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        // Initialize empty list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    public void addEdge(int src, int dest, int weight) {
        Edge e1 = new Edge(src, dest, weight); // src → dest
        Edge e2 = new Edge(dest, src, weight); // dest → src (undirected)

        adjList.get(src).add(e1);
        adjList.get(dest).add(e2);
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("-> (src=" + edge.src + ", dest=" + edge.dest + ", w=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
    /*          4
            0-------1
            | \     |
           5|  \2   |1
            |    \  |
            2-------3
                3
    */


        WeightedGraph graph = new WeightedGraph(4);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 3);

        graph.printGraph();
    }
}
