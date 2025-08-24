import java.util.*;

public class ArticulationPointTarjan {
    private static int time = 0;

    // DFS for articulation points
    private static void dfs(int u, int parent, boolean[] visited, int[] disc, int[] low, 
                            List<List<Integer>> graph, boolean[] isArticulation) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0; // count DFS children

        for (int v : graph.get(u)) {
            if (v == parent) continue; // ignore edge to parent

            if (!visited[v]) {
                children++;
                dfs(v, u, visited, disc, low, graph, isArticulation);

                // update low[u]
                low[u] = Math.min(low[u], low[v]);

                // Articulation Point conditions:
                // 1. u is root and has 2+ children
                if (parent == -1 && children > 1) {
                    isArticulation[u] = true;
                }
                // 2. u is not root and low[v] >= disc[u]
                if (parent != -1 && low[v] >= disc[u]) {
                    isArticulation[u] = true;
                }
            } else {
                // Back edge case
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Tarjan's main function
    public static void findArticulationPoints(int V, List<List<Integer>> graph) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isArticulation = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low, graph, isArticulation);
            }
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) {
                System.out.println(i);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        int V = 5;
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

        graph.get(3).add(4);
        graph.get(4).add(3);

        findArticulationPoints(V, graph);
    }
}
