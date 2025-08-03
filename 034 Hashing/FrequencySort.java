import java.util.*;

public class FrequencySort {
    public static String frequencySort(String s) {
        // Step 1: Count frequency using HashMap
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Use Max Heap (PriorityQueue) to sort by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );

        maxHeap.addAll(freqMap.keySet());

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int freq = freqMap.get(ch);

            // Append the character freq times
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        String s = "tree";
        String sorted = frequencySort(s);
        System.out.println("Sorted by frequency: " + sorted);
    }
}
