import java.util.*;

class NearbyCars {
    public int[][] kClosest(int[][] points, int k) {
        // Max Heap to store k closest points (farthest on top)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Integer.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            maxHeap.add(point);

            // Remove farthest if size exceeds k
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare result from heap
        int[][] result = new int[k][2];
        int i = 0;
        for (int[] p : maxHeap) {
            result[i++] = p;
        }

        return result;
    }

    // Helper function to calculate squared distance from origin
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // Main method for testing
    public static void main(String[] args) {
        NearbyCars sol = new NearbyCars();

        int[][] points = { {3, 3}, {5, -1}, {-2, 4} };
        int k = 2;

        int[][] closest = sol.kClosest(points, k);

        System.out.println("K Closest Points to Origin:");
        for (int[] p : closest) {
            System.out.println(Arrays.toString(p));
        }
    }
}


// //Another Aproach With PriorityQueue -------------------------------

// class Solution {
//     class Point{
//         int x;
//         int y;
//         int distance ;
//         Point(int x , int y){
//             this.x = x;
//             this.y = y;
//             this.distance = x*x + y*y;
//         }
//     }
//     public int[][] kClosest(int[][] points, int k) {
//         PriorityQueue<Point> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);
//         int[][] ans = new int[k][2];
//         for(int[] point : points){
//             Point currentPoint = new Point(point[0],point[1]);
//             pq.offer(currentPoint);
//         }
//         for(int i=0;i<k;i++){
//             Point currentPoint =pq.poll();
//             ans[i][0] = currentPoint.x;
//             ans[i][1] = currentPoint.y;
//         }
//         return ans;
//     }
// }