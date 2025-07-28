import java.util.*;

public class FillSlots {

    public static int minTimeToFillSlots(int N, int[] arr) {
        boolean[] filled = new boolean[N + 1];  // Index 1 to N
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialize queue with already filled positions
        for (int pos : arr) {
            if (!filled[pos]) {
                queue.add(pos);
                filled[pos] = true;
            }
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyNewFill = false;

            // Process current level
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // Check left neighbor
                if (curr - 1 >= 1 && !filled[curr - 1]) {
                    filled[curr - 1] = true;
                    queue.add(curr - 1);
                    anyNewFill = true;
                }

                // Check right neighbor
                if (curr + 1 <= N && !filled[curr + 1]) {
                    filled[curr + 1] = true;
                    queue.add(curr + 1);
                    anyNewFill = true;
                }
            }

            // Increase time only if new fill happened
            if (anyNewFill) time++;
        }

        return time;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] arr = {2, 6};  // Initially filled slots
        System.out.println(minTimeToFillSlots(N, arr));  // Output: 2

        int N2 = 10;
        int[] arr2 = {1, 10};  // Output: 5
        System.out.println(minTimeToFillSlots(N2, arr2));
    }
}
