public class SplitArrayKSubarrays {

    // Function to check if we can split into K or fewer parts with max sum <= mid
    public static boolean isValid(int[] arr, int k, int mid) {
        int count = 1, currentSum = 0;
        for (int num : arr) {
            if (currentSum + num > mid) {
                count++; // Start new subarray
                currentSum = num;
            } else {
                currentSum += num;
            }
        }
        return count <= k;
    }

    // Main function to find minimal maximum subarray sum
    public static int splitArray(int[] arr, int k) {
        int maxElement = 0, totalSum = 0;
        for (int num : arr) {
            maxElement = Math.max(maxElement, num);
            totalSum += num;
        }

        int low = maxElement, high = totalSum, answer = totalSum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        System.out.println(splitArray(arr1, 2)); // Output: 2

        int[] arr2 = {1, 2, 3, 4};
        System.out.println(splitArray(arr2, 3)); // Output: 4
    }
}
