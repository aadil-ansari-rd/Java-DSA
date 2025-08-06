import java.util.*;

class RottenOranges {

    static class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Count fresh oranges and enqueue rotten ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));  // rotten
                } else if (grid[i][j] == 1) {
                    freshCount++;  // fresh
                }
            }
        }

        if (freshCount == 0) return 0;  // No fresh oranges to rot

        int time = 0;
        int[][] directions = { {0,1}, {1,0}, {0,-1}, {-1,0} };

        // Step 2: BFS - level by level (minute-by-minute)
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyRot = false;

            for (int i = 0; i < size; i++) {
                Pair rotten = queue.poll();

                for (int[] dir : directions) {
                    int newRow = rotten.row + dir[0];
                    int newCol = rotten.col + dir[1];

                    // If valid cell and fresh orange found
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;  // Make it rotten
                        queue.offer(new Pair(newRow, newCol));
                        freshCount--;
                        anyRot = true;
                    }
                }
            }

            if (anyRot) time++;  // Only count minute if at least one orange rotted
        }

        return (freshCount == 0) ? time : -1;
    }

    // 🔽 Main function to test the code
    public static void main(String[] args) {
        RottenOranges solver = new RottenOranges();

        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        int result = solver.orangesRotting(grid);
        System.out.println("Minimum time to rot all oranges: " + result);
    }
}
