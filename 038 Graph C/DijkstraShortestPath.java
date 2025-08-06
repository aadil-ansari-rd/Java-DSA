import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class DijkstraShortestPath {
    // Method to add edges to the graph
    public static void addEdge(ArrayList<Edge>[] graph, int src, int dest, int weight) {
        graph[src].add(new Edge(src, dest, weight));
    }

    // 🔄 Dijkstra Algorithm to find shortest distance from src to dest
    public static int dijkstra(ArrayList<Edge>[] graph, int vertices, int src, int dest) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap: (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src});  // distance, node

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int u = curr[1];

            // 🚨 If destination reached, return answer
            if (u == dest) return currDist;

            for (Edge edge : graph[u]) {
                int v = edge.dest;
                int wt = edge.weight;

                // 🔁 Relaxation step
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        return -1; // if dest is unreachable
    }

    // 🧪 Main to test the code
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 4);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 1, 3, 7);
        addEdge(graph, 2, 4, 3);
        addEdge(graph, 4, 3, 2);

        int src = 0, dest = 3;

        int shortestDist = dijkstra(graph, vertices, src, dest);
        System.out.println("Shortest distance from " + src + " to " + dest + " = " + shortestDist);
    }
}
