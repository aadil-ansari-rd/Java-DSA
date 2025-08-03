import java.util.*;

public class ReconstructItinerary {

    // Adjacency list using min-heap for lexical order
    private Map<String, PriorityQueue<String>> flightMap = new HashMap<>();
    private LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // Build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            flightMap.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        // Start DFS from "JFK"
        dfs("JFK");

        // The result is built in reverse order, so we return it as is
        return itinerary;
    }

    // DFS traversal
    private void dfs(String airport) {
        PriorityQueue<String> destinations = flightMap.get(airport);

        // Visit all destinations from current airport in lexical order
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport);
        }

        // Add airport to the itinerary after visiting all its destinations
        itinerary.addFirst(airport);
    }

    // Main method to test
    public static void main(String[] args) {
        ReconstructItinerary solver = new ReconstructItinerary();

        List<List<String>> tickets = Arrays.asList(
            Arrays.asList("MUC", "LHR"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("LHR", "SFO")
        );

        List<String> result = solver.findItinerary(tickets);
        System.out.println("Itinerary: " + result); // Output: [JFK, MUC, LHR, SFO, SJC]
    }
}
