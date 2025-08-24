import java.util.*;

public class UnionFindCycleDetection {

    // Find with path compression
    private static int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) return vertex;
        parent[vertex] = find(parent, parent[vertex]); // path compression
        return parent[vertex];
    }

    // Union operation
    private static void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }

    // Function to check for cycle
    public static boolean containsCycle(int V, int[][] edges) {
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int uRoot = find(parent, u);
            int vRoot = find(parent, v);

            if (uRoot == vRoot) {
                return true; // cycle detected
            }
            union(parent, uRoot, vRoot);
        }
        return false; // no cycle
    }

    // Main method for testing
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0} // This edge creates a cycle
        };

        boolean hasCycle = containsCycle(V, edges);
        System.out.println("Graph contains cycle: " + hasCycle);
    }
}
