public class LongestBitonicSubsequence {

    public int findLongestBitonicSubsequence(int[] arr) {
        int n = arr.length;
        
        // Step 1: LIS from left to right
        int[] inc = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        // Step 2: LIS from right to left (for decreasing part)
        int[] dec = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        // Step 3: Find maximum bitonic length
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (inc[i] > 1 && dec[i] > 1) { // must increase & decrease
                maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
            }
        }

        return maxLen;
    }

    // Driver code to test
    public static void main(String[] args) {
        LongestBitonicSubsequence obj = new LongestBitonicSubsequence();
        int[] arr = {1, 4, 3, 5, 2};
        System.out.println("Length of Longest Bitonic Subsequence = " + obj.findLongestBitonicSubsequence(arr));
    }
}
