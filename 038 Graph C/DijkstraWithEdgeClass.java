import java.util.*;

// 📦 Edge class with source, destination, and weight
class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class DijkstraWithEdgeClass {

    // 🔧 Dijkstra’s Algorithm Implementation
    public static int[] dijkstra(int V, List<Edge>[] graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap: (distance, vertex)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src});

        boolean[] visited = new boolean[V];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int currNode = curr[1];

            if (visited[currNode]) continue;
            visited[currNode] = true;

            for (Edge edge : graph[currNode]) {
                int neighbor = edge.dest;
                int weight = edge.weight;

                if (dist[currNode] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[currNode] + weight;
                    pq.offer(new int[]{dist[neighbor], neighbor});
                }
            }
        }

        return dist;
    }

    // 🔨 Utility to build graph from Edge list
    public static List<Edge>[] buildGraph(int V, List<Edge> edges) {
        List<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        for (Edge e : edges) {
            graph[e.src].add(e);
        }

        return graph;
    }

    // 🧪 Driver Code
    public static void main(String[] args) {
        int V = 5;
        int src = 0;

        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 2),
            new Edge(0, 2, 4),
            new Edge(1, 2, 1),
            new Edge(1, 3, 7),
            new Edge(2, 4, 3),
            new Edge(3, 4, 1)
        );

        List<Edge>[] graph = buildGraph(V, edges);

        int[] distances = dijkstra(V, graph, src);

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + distances[i]);
        }
    }
}
