// Trapping Rain Water (LeetCode 42) – Using Stack


import java.util.Stack;
import java.util.*;

public class TrappingRainWater {

    // Method to compute trapped water
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            // While current bar is higher than stack top, process trapped water
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop(); // the valley bottom

                if (stack.isEmpty()) break; // no left boundary

                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[bottom];

                totalWater += distance * boundedHeight; // trapped water = width * height
            }

            stack.push(i); // push current bar index
        }

        return totalWater;
    }

    // Main method with hardcoded array
    public static void main(String[] args) {
        // Hardcoded elevation map
        int[] height = {4, 2, 0, 3, 2, 5};

        System.out.println("Elevation map: " + Arrays.toString(height));
        int result = trap(height);
        System.out.println("Total trapped water: " + result);
    }
}
