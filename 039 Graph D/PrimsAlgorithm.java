// Prim's Algorithm for Minimum Spanning Tree
import java.util.*;

public class PrimsAlgorithm {
    // Function to find vertex with minimum key value not yet in MST
    static int minKey(int[] key, boolean[] mstSet, int vertices) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < vertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to implement Prim's Algorithm
    public static void primMST(int[][] graph, int vertices) {
        int[] parent = new int[vertices]; // Store constructed MST
        int[] key = new int[vertices];    // Store minimum weights
        boolean[] mstSet = new boolean[vertices]; // Track vertices in MST

        // Step 1: Initialize keys as infinity and mstSet[] as false
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always start from vertex 0
        key[0] = 0;     // Start vertex weight = 0
        parent[0] = -1; // Root has no parent

        // MST will have V-1 edges
        for (int count = 0; count < vertices - 1; count++) {
            // Step 2: Pick minimum key vertex not in MST
            int u = minKey(key, mstSet, vertices);
            mstSet[u] = true; // Include u in MST

            // Step 3: Update key values of adjacent vertices
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Step 4: Print MST
        int totalCost = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("Total Cost: " + totalCost);
    }

    // Main method to test
    public static void main(String[] args) {
        int vertices = 5;
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        primMST(graph, vertices);
    }
}
