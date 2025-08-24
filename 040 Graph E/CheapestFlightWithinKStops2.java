// Bellman-Ford Approach

public class CheapestFlightWithinKStops2 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Distance array - stores min cost to reach each city
        int[] cost = new int[n];
        // Initialize all costs to infinity
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[src] = 0; // Cost to reach src is 0

        // Run Bellman-Ford for k+1 times (max stops = k means max edges = k+1)
        for (int i = 0; i <= k; i++) {
            int[] temp = cost.clone(); // Avoid using updated values in the same round
            for (int[] f : flights) {
                int u = f[0], v = f[1], price = f[2];
                if (cost[u] != Integer.MAX_VALUE && cost[u] + price < temp[v]) {
                    temp[v] = cost[u] + price; // Update min cost
                }
            }
            cost = temp; // Move to next iteration
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    // Main method for testing
    public static void main(String[] args) {
        CheapestFlightWithinKStops2 solver = new CheapestFlightWithinKStops2();

        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 3, 100},
            {0, 2, 500}
        };
        int src = 0, dst = 3, k = 1;

        int cheapestPrice = solver.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price within " + k + " stops: " + cheapestPrice);
    }
}
