import java.util.*;

public class LongestIncreasingPathMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] indegree = new int[rows][cols];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // Step 1: Build indegree graph
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int[] dir : directions) {
                    int newRow = i + dir[0], newCol = j + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                        && matrix[newRow][newCol] > matrix[i][j]) {
                        indegree[newRow][newCol]++;
                    }
                }
            }
        }

        // Step 2: Initialize queue with indegree = 0
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (indegree[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Step 3: BFS traversal (level order)
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++; // each level = +1 length
            for (int s = 0; s < size; s++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                        && matrix[newRow][newCol] > matrix[row][col]) {
                        indegree[newRow][newCol]--;
                        if (indegree[newRow][newCol] == 0) {
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }
        return pathLength;
    }

    // Main to test
    public static void main(String[] args) {
        LongestIncreasingPathMatrix solver = new LongestIncreasingPathMatrix();
        int[][] matrix1 = {{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix2 = {{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(solver.longestIncreasingPath(matrix1)); // Output: 4
        System.out.println(solver.longestIncreasingPath(matrix2)); // Output: 4
    }
}
