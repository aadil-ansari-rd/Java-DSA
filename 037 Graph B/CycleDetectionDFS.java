import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class CycleDetectionDFS {
    int vertices;
    List<List<Edge>> adjList;

    public CycleDetectionDFS(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight));
        adjList.get(dest).add(new Edge(dest, src, weight)); // Undirected
    }

    // 🚀 Main function to detect cycle in any component
    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfsHasCycle(i, visited, -1)) {
                    return true;  // Cycle found
                }
            }
        }
        return false; // No cycle in any component
    }

    // 🔁 DFS to detect cycle
    private boolean dfsHasCycle(int curr, boolean[] visited, int parent) {
        visited[curr] = true;

        for (Edge edge : adjList.get(curr)) {
            int neighbor = edge.dest;

            if (!visited[neighbor]) {
                if (dfsHasCycle(neighbor, visited, curr)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;  // Cycle found
            }
        }
        return false;
    }

    // 🧪 Test
    public static void main(String[] args) {
        
        //      4
        // 0 -------- 1
        // |          |
        // | 3        |2
        // |          |
        // 3 -------- 2
        //       1    |
        //            | 5
        //            |
        //            4



        CycleDetectionDFS graph = new CycleDetectionDFS(5);

        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 0, 3);
        graph.addEdge(2, 4, 5);

        System.out.println("Cycle Exists? " + graph.hasCycle());  // true
    }
}
