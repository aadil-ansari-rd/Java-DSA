import java.util.*;
// BFS Approach
public class CheapestFlightWithinKStops {

    // Edge class to represent a flight
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Info class for BFS queue elements
    static class Info {
        int city, cost, stops;
        public Info(int c, int cost, int stops) {
            this.city = c;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // Create adjacency list from flights
    public static void createGraph(int flights[][], ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] f : flights) {
            graph[f[0]].add(new Edge(f[0], f[1], f[2]));
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) continue;

            for (Edge e : graph[curr.city]) {
                int nextCity = e.dest;
                int newCost = curr.cost + e.wt;

                if (newCost < dist[nextCity]) {
                    dist[nextCity] = newCost;
                    q.add(new Info(nextCity, newCost, curr.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    // Test the code
    public static void main(String[] args) {
        CheapestFlightWithinKStops solver = new CheapestFlightWithinKStops();
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 3, 100},
            {0, 2, 500}
        };
        int src = 0, dst = 3, k = 1;

        System.out.println("Cheapest Price: " + solver.findCheapestPrice(n, flights, src, dst, k));
    }
}
