import java.util.*;

public class KruskalAlgorithmds {

    // Edge class to store two vertices and edge weight
    static class Edge implements Comparable<Edge> {
        int vertex1, vertex2, weight;
        Edge(int v1, int v2, int w) {
            this.vertex1 = v1;
            this.vertex2 = v2;
            this.weight = w;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight; // ascending weight
        }
    }

    // Union-Find (Disjoint Set) for cycle detection
    static class UnionFind {
        int[] parent, rank;
        UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int vertex) {
            if (parent[vertex] != vertex) parent[vertex] = find(parent[vertex]);
            return parent[vertex];
        }

        boolean union(int vertex1, int vertex2) {
            int root1 = find(vertex1);
            int root2 = find(vertex2);
            if (root1 == root2) return false; // already connected

            if (rank[root1] < rank[root2]) parent[root1] = root2;
            else if (rank[root1] > rank[root2]) parent[root2] = root1;
            else {
                parent[root2] = root1;
                rank[root1]++;
            }
            return true;
        }
    }

    // Function to find MST total weight
    public static int kruskalMST(int n, int[][] edgesInput) {
        List<Edge> edges = new ArrayList<>();
        for (int[] e : edgesInput) edges.add(new Edge(e[0], e[1], e[2]));

        Collections.sort(edges); // sort edges by weight

        UnionFind uf = new UnionFind(n);
        int mstWeight = 0, edgesUsed = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.vertex1, edge.vertex2)) {
                mstWeight += edge.weight;
                edgesUsed++;
                if (edgesUsed == n - 1) break; // MST complete
            }
        }

        return (edgesUsed == n - 1) ? mstWeight : -1;
    }

    // Test main
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {1, 2, 1},
            {2, 3, 2},
            {3, 4, 3},
            {1, 4, 4}
        };

        System.out.println("Minimum Spanning Tree Weight: " + kruskalMST(n, edges));
        // Output: 6
    }
}
