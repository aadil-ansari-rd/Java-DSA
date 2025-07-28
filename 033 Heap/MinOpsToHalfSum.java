import java.util.*;

public class MinOpsToHalfSum {

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double total = 0;

        for (int num : nums) {
            maxHeap.add((double) num);
            total += num;
        }

        double target = total / 2;
        int operations = 0;
        double reduced = 0;

        while (reduced < target) {
            double largest = maxHeap.poll();
            double half = largest / 2;
            reduced += half;
            maxHeap.add(half);
            operations++;
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] arr = {5, 19, 8, 1};
        System.out.println(halveArray(arr));  // Output: 3
    }
}
