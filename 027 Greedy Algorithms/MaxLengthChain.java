import java.util.Arrays;

public class MaxLengthChain {
    // Pair class for convenience
    static class Pair implements Comparable<Pair> {
        int start, end;
        Pair(int a, int b) {
            start = a;
            end = b;
        }

        // Sort based on end time
        public int compareTo(Pair other) {
            return this.end - other.end;
        }
    }

    // Method to get maximum chain length
    public static int maxChainLength(Pair[] pairs) {
        Arrays.sort(pairs); // Step 1: sort by end time
        int chainLength = 1;
        int lastEnd = pairs[0].end;

        // Step 2: iterate through sorted pairs
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i].start > lastEnd) {
                chainLength++;
                lastEnd = pairs[i].end;
            }
        }
        return chainLength;
    }

    public static void main(String[] args) {
        Pair[] pairs = { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60) };
        System.out.println("Maximum Chain Length: " + maxChainLength(pairs));
    }
}
