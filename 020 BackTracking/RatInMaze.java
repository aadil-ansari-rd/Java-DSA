public class RatInMaze {

    // Function to print a path matrix
    private static void printPath(int[][] visited) {
        for (int[] row : visited) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
        System.out.println();
    }

    // Recursive function to explore all paths
    private static void solveMaze(int[][] maze, int[][] visited, int x, int y, int n) {
        // Base case: reached destination
        if (x == n - 1 && y == n - 1) {
            visited[x][y] = 1;
            printPath(visited);
            visited[x][y] = 0;
            return;
        }

        // Directions → Down, Left, Right, Up
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};

        // Mark current cell visited
        visited[x][y] = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            // Check boundaries and validity
            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n &&
                maze[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {

                solveMaze(maze, visited, nextX, nextY, n);
            }
        }

        // Backtrack (unmark)
        visited[x][y] = 0;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int n = maze.length;
        int[][] visited = new int[n][n];

        if (maze[0][0] == 1)
            solveMaze(maze, visited, 0, 0, n);
        else
            System.out.println("No valid path exists!");
    }
}
