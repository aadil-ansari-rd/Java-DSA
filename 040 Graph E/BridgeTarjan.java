import java.util.*;

public class BridgeTarjan {

    private static int time = 0; // global timer

    // DFS to find bridges
    private static void dfs(int u, int parent, boolean[] visited, int[] disc, int[] low, List<List<Integer>> graph) {
        visited[u] = true;
        disc[u] = low[u] = ++time; // discovery and low time

        for (int v : graph.get(u)) {
            if (v == parent) continue; // ignore the edge to parent

            if (!visited[v]) {
                dfs(v, u, visited, disc, low, graph);

                // update low[u] after visiting v
                low[u] = Math.min(low[u], low[v]);

                // bridge condition
                if (low[v] > disc[u]) {
                    System.out.println("Bridge found: " + u + " -- " + v);
                }
            } else {
                // Back edge found
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Tarjan's main function
    public static void findBridges(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];

        // run DFS for each component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low, graph);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Undirected graph edges
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(0);
        graph.get(0).add(2);

        graph.get(1).add(3);
        graph.get(3).add(1);

        findBridges(V, graph);
    }
}
