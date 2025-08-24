import java.util.*;

public class MotherVertexProblem {

    // DFS utility function
    private static void dfs(int u, List<List<Integer>> graph, boolean[] visited) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, graph, visited);
            }
        }
    }

    public static int findMotherVertex(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];
        int candidate = -1;

        // Step 1: Find potential mother vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                candidate = i; // last finished vertex
            }
        }

        // Step 2: Check if candidate is actually mother vertex
        Arrays.fill(visited, false);
        dfs(candidate, graph, visited);

        for (boolean v : visited) {
            if (!v) return -1; // Not all vertices reachable
        }

        return candidate;
    }

    // Main method for testing
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Add directed edges
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(3).add(0);
        graph.get(3).add(1);

        int motherVertex = findMotherVertex(V, graph);
        System.out.println("Mother Vertex: " + motherVertex);
    }
}
