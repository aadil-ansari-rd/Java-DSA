import java.util.*;

public class BoxStacking {

    // Class to represent a box with length, width, and height
    static class Box {
        int l, w, h;
        public Box(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
        }
    }

    public int maxStackHeight(int[][] boxes) {
        // Step 1: Generate all rotations
        List<Box> allBoxes = new ArrayList<>();
        for (int[] b : boxes) {
            int l = b[0], w = b[1], h = b[2];
            // Rotation 1
            allBoxes.add(new Box(Math.max(l, w), Math.min(l, w), h));
            // Rotation 2
            allBoxes.add(new Box(Math.max(w, h), Math.min(w, h), l));
            // Rotation 3
            allBoxes.add(new Box(Math.max(h, l), Math.min(h, l), w));
        }

        // Step 2: Sort boxes by base area (length * width) descending
        Collections.sort(allBoxes, (a, b) -> (b.l * b.w) - (a.l * a.w));

        int n = allBoxes.size();
        int[] dp = new int[n]; // dp[i] = max height ending with box i

        // Step 3: Initialize dp with each box's height
        for (int i = 0; i < n; i++) {
            dp[i] = allBoxes.get(i).h;
        }

        // Step 4: Apply LIS-style DP for stacking
        for (int i = 1; i < n; i++) {
            Box curr = allBoxes.get(i);
            for (int j = 0; j < i; j++) {
                Box prev = allBoxes.get(j);
                if (curr.l < prev.l && curr.w < prev.w) {
                    dp[i] = Math.max(dp[i], dp[j] + curr.h);
                }
            }
        }

        // Step 5: Maximum of dp array is the answer
        int maxHeight = 0;
        for (int h : dp) {
            maxHeight = Math.max(maxHeight, h);
        }
        return maxHeight;
    }

    // Example usage
    public static void main(String[] args) {
        BoxStacking solver = new BoxStacking();
        int[][] boxes = {{4,6,7}, {1,2,3}, {4,5,6}, {10,12,32}};
        System.out.println("Maximum Stack Height: " + solver.maxStackHeight(boxes));
    }
}
