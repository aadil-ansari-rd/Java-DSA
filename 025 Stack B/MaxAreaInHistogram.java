//Maximum Rectanglura Area In Histogram

import java.util.Stack;

public class MaxAreaInHistogram {
    // public static void maxAreaInHistogram(int[] height) {
    // int n = height.length;
    // int maxArea = 0;
    // Stack<Integer> s = new Stack<>();
    // int[] nsr = new int[n];// nsr : next smaller right
    // int[] nsl = new int[n];// nsl : next smaller left
    // // nsr[]
    // for (int i = n - 1; i >= 0; i--) {
    // while (!s.isEmpty() && height[i] <= height[s.peek()]) {
    // s.pop();
    // }
    // if (s.isEmpty()) {
    // nsr[i] = n;
    // } else {
    // nsr[i] = s.peek();
    // }
    // s.push(i);
    // }

    // // nsl[]
    // s = new Stack<>();
    // for (int i = 0; i < n; i++) {
    // while (!s.isEmpty() && height[i] <= height[s.peek()]) {
    // s.pop();
    // }
    // if (s.isEmpty()) {
    // nsl[i] = -1;
    // } else {
    // nsl[i] = s.peek();
    // }
    // s.push(i);
    // }

    // // Calculate max area
    // for (int i = 0; i < n; i++) {
    // int width = nsr[i] - nsl[i] - 1;
    // int ht = height[i];
    // int area = width * ht;
    // maxArea = Math.max(maxArea, area);
    // }
    // System.out.println("Maximum Rectangular Area in Given Histogram is : " +
    // maxArea);
    // }

    public static void maxAreaInHistogram(int[] height) {
        int n = height.length;
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();
        int[] nsr = new int[n]; // next smaller to right
        int[] nsl = new int[n]; // next smaller to left
        // Fill NSR[]
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && height[i] <= height[s.peek()]) {
                s.pop();
            }
            nsr[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        // Clear stack for NSL calculation
        s.clear();
        // Fill NSL[]
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && height[i] <= height[s.peek()]) {
                s.pop();
            }
            nsl[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        // Calculate max area using width = (right - left - 1)
        for (int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int ht = height[i];
            int area = width * ht;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println("Maximum Rectangular Area in Given Histogram is: " + maxArea);
    }

    public static void main(String[] args) {
        int[] height = { 2, 1, 5, 6, 2, 3 };
        maxAreaInHistogram(height);
    }
}
