public class LargestRegion {
    // Directions: 8 neighbors
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int findLargestRegion(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxRegion = 0;

        // Traverse all cells in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If cell is 1 and not visited, start DFS
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int regionSize = dfs(matrix, visited, i, j);
                    maxRegion = Math.max(maxRegion, regionSize);
                }
            }
        }
        return maxRegion;
    }

    // Recursive DFS to count connected 1s
    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int count = 1;  // Current cell

        for (int d = 0; d < 8; d++) {
            int newRow = row + dx[d];
            int newCol = col + dy[d];

            // Check boundaries and if neighbor is 1 and unvisited
            if (isSafe(matrix, visited, newRow, newCol)) {
                count += dfs(matrix, visited, newRow, newCol);
            }
        }
        return count;
    }

    private static boolean isSafe(int[][] matrix, boolean[][] visited, int i, int j) {
        return (i >= 0 && i < matrix.length &&
                j >= 0 && j < matrix[0].length &&
                matrix[i][j] == 1 && !visited[i][j]);
    }

    // Sample Main
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {1, 0, 1, 1}
        };
        System.out.println("Largest Region Size: " + findLargestRegion(matrix)); // Output: 5
    }
}
