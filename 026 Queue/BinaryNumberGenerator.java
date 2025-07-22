import java.util.Queue;
import java.util.*;


public class BinaryNumberGenerator {

    // Function to generate binary numbers from 1 to N
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();

        // Start with "1" as the first binary number
        queue.add("1");

        for (int i = 1; i <= N; i++) {
            // Fetch and print the front element of the queue
            String current = queue.poll();
            System.out.print(current + " ");

            // Generate next two binary numbers and add to queue
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        generateBinaryNumbers(N);
    }
}
