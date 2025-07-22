public class KthLargestOddNumber {

    // Function to find Kth largest odd number between L and R
    public static int kthLargestOdd(int L, int R, int K) {
        // Find largest odd number in the range
        int largestOdd = (R % 2 == 1) ? R : R - 1;

        // Find smallest odd number in the range
        int smallestOdd = (L % 2 == 1) ? L : L + 1;

        // Total odd numbers in range
        int totalOdds = ((largestOdd - smallestOdd) / 2) + 1;

        // If K is greater than total odd numbers, return 0
        if (K > totalOdds) return 0;

        // Else return Kth largest odd number
        return largestOdd - (K - 1) * 2;
    }

    public static void main(String[] args) {
        int L = -3, R = 3, K = 1;
        System.out.println(kthLargestOdd(L, R, K)); // Output: 3
    }
}
