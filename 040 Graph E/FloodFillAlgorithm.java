public class FloodFillAlgorithm {

    // Function to perform flood fill
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor != newColor) {
            fill(image, sr, sc, originalColor, newColor);
        }
        return image;
    }

    // DFS helper function
    private static void fill(int[][] image, int row, int col, int originalColor, int newColor) {
        // Boundary and color check
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) return;
        if (image[row][col] != originalColor) return;

        // Change color
        image[row][col] = newColor;

        // Explore 4 directions: up, down, left, right
        fill(image, row + 1, col, originalColor, newColor); // down
        fill(image, row - 1, col, originalColor, newColor); // up
        fill(image, row, col + 1, originalColor, newColor); // right
        fill(image, row, col - 1, originalColor, newColor); // left
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

        // Print the result
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
