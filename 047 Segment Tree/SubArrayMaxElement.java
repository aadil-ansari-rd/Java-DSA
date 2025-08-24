public class SubArrayMaxElement {
    static int[] tree; // Segment Tree array

    public static void init(int n) {
        tree = new int[4 * n]; // safe size allocation
    }

    // Build Segment Tree
    public static void buildST(int tIdx, int si, int sj, int[] arr) {
        if (si == sj) { // leaf node
            tree[tIdx] = arr[si];
            return;
        }
        int mid = (si + sj) / 2;
        buildST(2 * tIdx + 1, si, mid, arr);       // left child
        buildST(2 * tIdx + 2, mid + 1, sj, arr);   // right child
        tree[tIdx] = Math.max(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
    }

    // Query: max in range [qi, qj]
    public static int getMax(int[] arr, int[] tree, int qi, int qj) {
        return getMaxUtil(tree, 0, 0, arr.length - 1, qi, qj);
    }

    public static int getMaxUtil(int[] tree, int tIdx, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) return Integer.MIN_VALUE; // no overlap
        if (si >= qi && sj <= qj) return tree[tIdx];      // complete overlap
        int mid = (si + sj) / 2;
        int leftAns = getMaxUtil(tree, 2 * tIdx + 1, si, mid, qi, qj);
        int rightAns = getMaxUtil(tree, 2 * tIdx + 2, mid + 1, sj, qi, qj);
        return Math.max(leftAns, rightAns); // partial overlap
    }

    // Update value in array and segment tree
    public static void update(int[] arr, int idx, int newVal) {
        arr[idx] = newVal;
        updateUtil(0, 0, arr.length - 1, idx, newVal);
    }

    public static void updateUtil(int tIdx, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) return;
        if (si == sj) { // leaf node
            tree[tIdx] = newVal;
            return;
        }
        int mid = (si + sj) / 2;
        if (idx <= mid) updateUtil(2 * tIdx + 1, si, mid, idx, newVal);
        else updateUtil(2 * tIdx + 2, mid + 1, sj, idx, newVal);
        tree[tIdx] = Math.max(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        init(n);
        buildST(0, 0, n - 1, arr);

        System.out.println("\n--- Query Tests ---");
        System.out.println("Max in [0, 4] = " + getMax(arr, tree, 0, 4)); // 17
        System.out.println("Max in [2, 5] = " + getMax(arr, tree, 2, 5)); // 17
        System.out.println("Max in [6, 8] = " + getMax(arr, tree, 6, 8)); // 4

        System.out.println("\n--- Update Tests ---");
        update(arr, 4, 0); 
        System.out.println("After arr[4]=0, Max in [0, 4] = " + getMax(arr, tree, 0, 4)); // 8

        update(arr, 2, 20);
        System.out.println("After arr[2]=20, Max in [0, 4] = " + getMax(arr, tree, 0, 4)); // 20
        System.out.println("Max in [2, 8] = " + getMax(arr, tree, 2, 8)); // 20
    }
}

// public class SubArrayMaxElement {
//     // Segment Tree array (large enough to store all nodes)
//     static int[] tree;

//     // Initialize segment tree with size 4*n (safe upper bound for storing nodes)
//     public static void init(int n) {
//         tree = new int[4 * n];
//     }

//     // Build Segment Tree function
//     // tIdx = index in tree[], si = segment start, sj = segment end
//     public static void buildST(int tIdx, int si, int sj, int[] arr) {
//         // Base Case: Leaf node (only one element in the range)
//         if (si == sj) {
//             tree[tIdx] = arr[si]; // store array element at leaf
//             return;
//         }

//         // Divide the range into two halves
//         int mid = (si + sj) / 2;

//         // Recursively build left child (2*tIdx+1) for range [si..mid]
//         buildST(2 * tIdx + 1, si, mid, arr);

//         // Recursively build right child (2*tIdx+2) for range [mid+1..sj]
//         buildST(2 * tIdx + 2, mid + 1, sj, arr);

//         // Internal node stores the max of left & right child
//         tree[tIdx] = Math.max(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
//     }

//     // Function to get the maximum value in the given range [qi, qj]
//     public static int getMax(int[] arr, int[] tree, int qi, int qj) {
//         int n = arr.length;
//         // Call utility function on root of segment tree (tIdx = 0)
//         // covering the full array range [0, n-1]
//         return getMaxUtil(tree, 0, 0, n - 1, qi, qj);
//     }

//     // Recursive utility function to find maximum in a given range
//     public static int getMaxUtil(int[] tree, int tIdx, int si, int sj, int qi, int qj) {
//         // Case 1: No Overlap between segment [si, sj] and query [qi, qj]
//         if (si > qj || sj < qi) {
//             return Integer.MIN_VALUE; // return very small value so it doesn't affect max
//         }
//         // Case 2: Complete Overlap → segment [si, sj] lies fully inside query range[qi, qj]
//         else if (si >= qi && sj <= qj) {
//             return tree[tIdx]; // directly return stored maximum for this segment
//         }
//         // Case 3: Partial Overlap → break into left and right child segments
//         else {
//             int mid = (si + sj) / 2;
//             // Query left child (2*tIdx+1) for range [si, mid]
//             int leftAns = getMaxUtil(tree, 2 * tIdx + 1, si, mid, qi, qj);
//             // Query right child (2*tIdx+2) for range [mid+1, sj]
//             int rightAns = getMaxUtil(tree, 2 * tIdx + 2, mid + 1, sj, qi, qj);
//             // Return maximum of both halves
//             return Math.max(leftAns, rightAns);
//         }
//     }

//     // Update function: updates a value in both the array and the segment tree
//     public static void update(int[] arr, int idx, int newVal) {
//         // Update the original array at given index
//         arr[idx] = newVal;

//         int n = arr.length;
//         // Call utility function to update segment tree nodes
//         updateUtil(0, 0, n - 1, idx, newVal);
//     }

//     // Utility function to update segment tree recursively
//     public static void updateUtil(int tIdx, int si, int sj, int idx, int newVal) {
//         // If the update index is out of current segment range, return
//         if (idx < si || idx > sj) {
//             return;
//         }

//         // Base case: leaf node reached (segment is a single element)
//         if (si == sj) {
//             tree[tIdx] = newVal; // update leaf value in segment tree
//             return;
//         }

//         // Recursive case: split into left and right children
//         int mid = (si + sj) / 2;
//         if (idx <= mid) {
//             // Update goes in the left child
//             updateUtil(2 * tIdx + 1, si, mid, idx, newVal);
//         } else {
//             // Update goes in the right child
//             updateUtil(2 * tIdx + 2, mid + 1, sj, idx, newVal);
//         }

//         // After updating child, recalculate current node value
//         // Since tree is built for max query, take max of children
//         tree[tIdx] = Math.max(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
//     }

//     public static void main(String[] args) {
//         int[] arr = {6, 8, -1, 2, 17, 1, 3, 2, 4};
//         int n = arr.length;

//         init(n);
//         buildST(0, 0, n - 1, arr);

//         System.out.println("\n--- Query Tests ---");
//         System.out.println("Max in [0, 4] = " + getMax(arr, tree, 0, 4)); // 17
//         System.out.println("Max in [2, 5] = " + getMax(arr, tree, 2, 5)); // 17
//         System.out.println("Max in [6, 8] = " + getMax(arr, tree, 6, 8)); // 4

//         System.out.println("\n--- Update Tests ---");
//         update(arr, 4, 0); 
//         System.out.println("After arr[4]=0, Max in [0, 4] = " + getMax(arr, tree, 0, 4)); // 8

//         update(arr, 2, 20);
//         System.out.println("After arr[2]=20, Max in [0, 4] = " + getMax(arr, tree, 0, 4)); // 20
//         System.out.println("Max in [2, 8] = " + getMax(arr, tree, 2, 8)); // 20
//     }
// }
