import java.util.*;

public class KosarajuSCC {

    // Step 1: Perform DFS and push vertices to stack by finish time
    private static void dfs1(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs1(neighbor, visited, stack, graph);
            }
        }
        stack.push(node); // push after exploring all neighbors
    }

    // Step 2: DFS on transposed graph to collect SCC
    private static void dfs2(int node, boolean[] visited, List<List<Integer>> transpose, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : transpose.get(node)) {
            if (!visited[neighbor]) {
                dfs2(neighbor, visited, transpose, component);
            }
        }
    }

    // Kosaraju main method
    public static void kosaraju(int V, List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Fill stack with finish times using DFS
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, visited, stack, graph);
            }
        }

        // Step 2: Build transpose graph
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) transpose.add(new ArrayList<>());
        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                transpose.get(v).add(u); // reverse edge
            }
        }

        // Step 3: DFS on transposed graph in stack order
        Arrays.fill(visited, false);
        System.out.println("Strongly Connected Components:");
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs2(node, visited, transpose, component);
                System.out.println(component);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Graph edges
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(1).add(3);
        graph.get(3).add(4);

        kosaraju(V, graph);
    }
}
