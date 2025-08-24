public class SubArraySum {
    static int tree[]; // Segment tree array

    public static void init(int n) {
        tree = new int[4 * n]; // safe size = 4 * n
    }

    // Build Segment Tree
    public static int buildST(int[] arr, int tIdx, int start, int end) {
        if (start == end) { // leaf node
            tree[tIdx] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        int left = buildST(arr, 2 * tIdx + 1, start, mid);
        int right = buildST(arr, 2 * tIdx + 2, mid + 1, end);
        tree[tIdx] = left + right;
        return tree[tIdx];
    }

    // Range Sum Query
    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static int getSumUtil(int tIdx, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj)
            return 0; // no overlap
        if (si >= qi && sj <= qj)
            return tree[tIdx]; // complete overlap
        int mid = (si + sj) / 2; // partial overlap
        int left = getSumUtil(2 * tIdx + 1, si, mid, qi, qj);
        int right = getSumUtil(2 * tIdx + 2, mid + 1, sj, qi, qj);
        return left + right;
    }

    // Update a value in array and tree
    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtil(0, 0, n - 1, idx, diff);
    }

    public static void updateUtil(int tIdx, int si, int sj, int idx, int diff) {
        if (idx > sj || idx < si)
            return; // no overlap
        tree[tIdx] += diff; // update current node
        if (si != sj) { // not leaf
            int mid = (si + sj) / 2;
            updateUtil(2 * tIdx + 1, si, mid, idx, diff);
            updateUtil(2 * tIdx + 2, mid + 1, sj, idx, diff);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        init(n);
        buildST(arr, 0, 0, n - 1);

        System.out.println("Sum [2..6] = " + getSum(arr, 2, 6)); // 25
        update(arr, 3, 10);
        System.out.println("After arr[3]=10, Sum [2..6] = " + getSum(arr, 2, 6)); // 31
        update(arr, 0, 20);
        System.out.println("After arr[0]=20, Sum [0..7] = " + getSum(arr, 0, 7)); // 61
    }
}



// public class SubArraySum {
//     static int tree[]; // Segment tree array (to store range sums)

//     // Initialize segment tree array of size 4 * n (safe size for segment trees)
//     public static void init(int n) {
//         tree = new int[4 * n]; // create array for segment tree (safe size = 4*n)
//     }

//     // Build the Segment Tree from input array
//     // tIdx = current index in the segment tree
//     // start, end = current segment (range) of array
//     public static int buildST(int[] arr, int tIdx, int start, int end) {
//         // Base case: if it is a leaf node (only one element left)
//         if (start == end) {
//             tree[tIdx] = arr[start]; // store the element directly
//             return arr[start];
//         }

//         // Recursive case: split the array into two halves
//         int mid = (start + end) / 2;

//         // Build left child (stored at index 2*tIdx+1)
//         int left = buildST(arr, 2 * tIdx + 1, start, mid);

//         // Build right child (stored at index 2*tIdx+2)
//         int right = buildST(arr, 2 * tIdx + 2, mid + 1, end);

//         // Store sum of left + right in the parent node
//         tree[tIdx] = left + right;

//         // Return sum to the parent
//         return tree[tIdx];
//     }

//     // Wrapper function -> only query range needs to be passed
//     public static int getSum(int arr[], int qi, int qj) {
//         int n = arr.length;
//         return getSumUtil(0, 0, n - 1, qi, qj); // start from root node
//     }

//     // Utility function to calculate sum of range [qi, qj]
//     // si, sj = current segment (range of tree node)
//     // qi, qj = query range (requested by user)
//     public static int getSumUtil(int tIdx, int si, int sj, int qi, int qj) {
//         // Case 1: No overlap → [si, sj] is completely outside [qi, qj]
//         if (qj < si || qi > sj) {
//             return 0;
//         }
//         // Case 2: Complete overlap → [si, sj] is fully inside [qi, qj]
//         else if (si >= qi && sj <= qj) {
//             return tree[tIdx];
//         }
//         // Case 3: Partial overlap → split into left and right children
//         else {
//             int mid = (si + sj) / 2;
//             int left = getSumUtil(2 * tIdx + 1, si, mid, qi, qj);
//             int right = getSumUtil(2 * tIdx + 2, mid + 1, sj, qi, qj);
//             return left + right;
//         }
//     }

//     public static void update(int arr[], int idx, int newVal) {
//         int n = arr.length;
//         int diff = newVal - arr[idx]; // difference between new and old value
//         arr[idx] = newVal; // update original array

//         updateUtil(0, 0, n - 1, idx, diff); // update segment tree with difference
//     }

//     public static void updateUtil(int tIdx, int si, int sj, int idx, int diff) {
//         if (idx > sj || idx < si) {
//             return; // no overlap
//         }
//         tree[tIdx] += diff; // update this node
//         if (si != sj) { // not a leaf node
//             int mid = (si + sj) / 2;
//             updateUtil(2 * tIdx + 1, si, mid, idx, diff); // left child
//             updateUtil(2 * tIdx + 2, mid + 1, sj, idx, diff); // ✅ fixed right child
//         }
//     }

//     public static void main(String[] args) {
//         // Input array
//         int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
//         int n = arr.length;

//         // Step 1: Initialize the segment tree
//         init(n);

//         // Step 2: Build the segment tree (root = index 0, range = 0 to n-1)
//         buildST(arr, 0, 0, n - 1);

//         // Step 3: Query Example -> subarray sum from index 2 to 6
//         // Subarray = [3, 4, 5, 6, 7] → sum = 25
//         System.out.println("Subarray Sum from 2 to 6 = " + getSum(arr, 2, 6));

//         // Step 4: Update Example -> update index 3 (value 4 → 10)
//         update(arr, 3, 10); // arr becomes [1,2,3,10,5,6,7,8]

//         // Step 5: Query again after update
//         // New subarray = [3, 10, 5, 6, 7] → sum = 31
//         System.out.println("After update (arr[3]=10), Subarray Sum from 2 to 6 = " + getSum(arr, 2, 6));

//         // Step 6: Another update -> update index 0 (value 1 → 20)
//         update(arr, 0, 20); // arr becomes [20,2,3,10,5,6,7,8]

//         // Query full array [0..7]
//         System.out.println("After update (arr[0]=20), Subarray Sum from 0 to 7 = " + getSum(arr, 0, 7));
//     }

// }
