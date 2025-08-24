// Bellman-Ford Algorithm in Java
class BellmanFord {
    // Structure to represent an edge
    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Bellman-Ford function
    public static void bellmanFord(int vertices, int edgesCount, Edge[] edges, int source) {
        // Step 1: Initialize distances
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE; // infinity
        }
        distance[source] = 0;

        // Step 2: Relax all edges V-1 times
        for (int i = 1; i <= vertices - 1; i++) {
            for (int j = 0; j < edgesCount; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;

                // Relax edge if a shorter path is found
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // Step 3: Check for negative weight cycle
        for (int j = 0; j < edgesCount; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        // Print results
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t" + distance[i]);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int vertices = 5; 
        int edgesCount = 8; 
        Edge[] edges = new Edge[edgesCount];

        // Define edges
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        // Run algorithm
        bellmanFord(vertices, edgesCount, edges, 0);
    }
}
