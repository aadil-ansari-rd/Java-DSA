import java.util.*;

public class TarjanSCC {

    private int time = 0; // discovery time counter

    // Function to find SCCs
    public List<List<Integer>> findSCCs(int V, List<List<Integer>> graph) {
        int[] disc = new int[V]; // discovery times
        int[] low = new int[V];  // low-link values
        boolean[] inStack = new boolean[V]; // vertices in stack
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> sccList = new ArrayList<>();

        Arrays.fill(disc, -1); // unvisited nodes
        Arrays.fill(low, -1);

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(i, graph, disc, low, stack, inStack, sccList);
            }
        }
        return sccList;
    }

    private void dfs(int u, List<List<Integer>> graph, int[] disc, int[] low, Stack<Integer> stack,
                     boolean[] inStack, List<List<Integer>> sccList) {
        disc[u] = low[u] = time++;
        stack.push(u);
        inStack[u] = true;

        // Explore all neighbors
        for (int v : graph.get(u)) {
            if (disc[v] == -1) { // if not visited
                dfs(v, graph, disc, low, stack, inStack, sccList);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) { // back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // If u is head of an SCC
        if (low[u] == disc[u]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                inStack[node] = false;
                scc.add(node);
                if (node == u) break;
            }
            sccList.add(scc);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        // Add directed edges
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(1).add(3);

        TarjanSCC solver = new TarjanSCC();
        List<List<Integer>> sccs = solver.findSCCs(V, graph);

        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccs) {
            System.out.println(scc);
        }
    }
}
