import java.util.Arrays;

public class FloydWarshall {

    public static int INF = 1000000; // Representation of infinity

    public static int[][] floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Main Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {          // intermediate vertex
            for (int i = 0; i < V; i++) {      // source vertex
                for (int j = 0; j < V; j++) {  // destination vertex
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        return dist;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, INF},
            {50, 0, 15},
            {30, INF, 0}
        };

        int[][] shortestPaths = floydWarshall(graph);

        System.out.println("Shortest distances between all pairs:");
        for (int[] row : shortestPaths) {
            for (int d : row) {
                if (d == INF) System.out.print("INF ");
                else System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
