import java.util.*;

public class WeakestSoldiers {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        List<int[]> list = new ArrayList<>();

        // Step 1: Count soldiers in each row using binary search
        for (int i = 0; i < m; i++) {
            int soldierCount = countSoldiers(mat[i]);
            list.add(new int[]{soldierCount, i}); // store (count, index)
        }

        // Step 2: Sort by soldier count, then by index
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // Step 3: Extract k weakest indices
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1];
        }

        return result;
    }

    // Binary search to count number of 1s (soldiers)
    private int countSoldiers(int[] row) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        WeakestSoldiers ws = new WeakestSoldiers();

        int[][] mat = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        int k = 3;

        int[] weakestRows = ws.kWeakestRows(mat, k);
        System.out.println("The " + k + " weakest rows are: " + Arrays.toString(weakestRows));
    }
}




// //Another Aproach With PriorityQueue -------------------------------
// class Solution {
//     class Row implements Comparable<Row> {
//         int no1;
//         int rowIdx;

//         Row(int no1, int rowIdx) {
//             this.no1 = no1;
//             this.rowIdx = rowIdx;
//         }

//         public int compareTo(Row r) {
//             if (this.no1 != r.no1) {
//                 return this.no1 - r.no1;
//             }
//             return this.rowIdx - r.rowIdx;
//         }
//     }

//     public int[] kWeakestRows(int[][] mat, int k) {
//         int[] ans = new int[k];
//         PriorityQueue<Row> pq = new PriorityQueue<>();
//         for (int i = 0; i < mat.length; i++) {
//             int no1 = 0;
//             for (int j = 0; j < mat[0].length; j++) {
//                 if (mat[i][j] == 1) {
//                     no1++;
//                 } else {
//                     break;
//                 }
//             }
//             pq.offer(new Row(no1, i));
//         }

//         for (int i = 0; i < k; i++) {
//             ans[i] = pq.poll().rowIdx;
//         }
//         return ans;
//     }
// }