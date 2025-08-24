import java.util.*;

public class AlienDictionary {

    // Function to find one valid order of characters
    public static String findOrder(String[] words, int N, int K) {
        // Step 1: Build adjacency list for characters
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < K; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int from = word1.charAt(j) - 'a';
                    int to = word2.charAt(j) - 'a';
                    graph.get(from).add(to); // Edge: from -> to
                    break; // Only first differing character counts
                }
            }
        }

        // Step 2: Compute in-degree of each node
        int[] indegree = new int[K];
        for (int u = 0; u < K; u++) {
            for (int v : graph.get(u)) indegree[v]++;
        }

        // Step 3: BFS / Kahn's topological sort
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) if (indegree[i] == 0) q.add(i);

        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.append((char)(u + 'a'));

            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        // Step 4: Check for cycle
        if (order.length() != K) return ""; // cycle exists

        return order.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        String[] words = {"baa","abcd","abca","cab","cad"};
        int N = words.length;
        int K = 4;

        String order = findOrder(words, N, K);
        System.out.println("One possible order of characters: " + order);
    }
}
