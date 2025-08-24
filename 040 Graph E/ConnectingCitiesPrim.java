import java.util.*;

public class ConnectingCitiesPrim {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static int minimumCost(int n, int[][] connections) {
        // Step 1: Build adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] conn : connections) {
            int a = conn[0], b = conn[1], cost = conn[2];
            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }

        // Step 2: Prim's algorithm setup
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        // Step 3: Start from city 1
        visited[1] = true;
        pq.addAll(graph.get(1));

        int totalCost = 0, edgesUsed = 0;

        // Step 4: Process edges
        while (!pq.isEmpty() && edgesUsed < n - 1) {
            Edge curr = pq.poll();
            if (visited[curr.to]) continue;

            visited[curr.to] = true;
            totalCost += curr.cost;
            edgesUsed++;

            for (Edge next : graph.get(curr.to)) {
                if (!visited[next.to]) pq.add(next);
            }
        }

        // Step 5: Check if all cities are connected
        return (edgesUsed == n - 1) ? totalCost : -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {
            {1, 2, 5},
            {1, 3, 6},
            {2, 3, 1}
        };
        System.out.println(minimumCost(n, connections)); // Output: 6
    }
}
