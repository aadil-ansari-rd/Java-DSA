// ✅ Segment Tree for Range Minimum Query (RMQ)
public class SubArrayMinElement {
    static int[] tree; // Segment Tree array

    // Initialize tree
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
        tree[tIdx] = Math.min(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
    }

    // Query: min in range [qi, qj]
    public static int getMin(int[] arr, int[] tree, int qi, int qj) {
        return getMinUtil(tree, 0, 0, arr.length - 1, qi, qj);
    }

    public static int getMinUtil(int[] tree, int tIdx, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) return Integer.MAX_VALUE; // no overlap
        if (si >= qi && sj <= qj) return tree[tIdx];      // complete overlap
        int mid = (si + sj) / 2;
        int leftAns = getMinUtil(tree, 2 * tIdx + 1, si, mid, qi, qj);
        int rightAns = getMinUtil(tree, 2 * tIdx + 2, mid + 1, sj, qi, qj);
        return Math.min(leftAns, rightAns); // partial overlap
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
        tree[tIdx] = Math.min(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;

        init(n);
        buildST(0, 0, n - 1, arr);

        System.out.println("\n--- Query Tests ---");
        System.out.println("Min in [0, 4] = " + getMin(arr, tree, 0, 4)); // -1
        System.out.println("Min in [2, 5] = " + getMin(arr, tree, 2, 5)); // -1
        System.out.println("Min in [6, 8] = " + getMin(arr, tree, 6, 8)); // 2

        System.out.println("\n--- Update Tests ---");
        update(arr, 2, 10); 
        System.out.println("After arr[2]=10, Min in [0, 4] = " + getMin(arr, tree, 0, 4)); // 2

        update(arr, 3, -5);
        System.out.println("After arr[3]=-5, Min in [0, 4] = " + getMin(arr, tree, 0, 4)); // -5
        System.out.println("Min in [0, 8] = " + getMin(arr, tree, 0, 8)); // -5
    }
}
