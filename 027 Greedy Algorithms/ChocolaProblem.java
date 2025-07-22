import java.util.*;

public class ChocolaProblem {
    public static int minCost(int[] horizontal, int[] vertical) {
        Arrays.sort(horizontal);
        Arrays.sort(vertical);

        int h = horizontal.length - 1;
        int v = vertical.length - 1;

        int horizontalPieces = 1, verticalPieces = 1;
        int cost = 0;

        // Step 1: Pick the highest cost cut first
        while (h >= 0 && v >= 0) {
            if (horizontal[h] > vertical[v]) {
                cost += horizontal[h] * verticalPieces;
                horizontalPieces++;
                h--;
            } else {
                cost += vertical[v] * horizontalPieces;
                verticalPieces++;
                v--;
            }
        }

        // Step 2: Add remaining cuts
        while (h >= 0) {
            cost += horizontal[h] * verticalPieces;
            h--;
            horizontalPieces++;
        }

        while (v >= 0) {
            cost += vertical[v] * horizontalPieces;
            v--;
            verticalPieces++;
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] horizontal = {2, 1};
        int[] vertical = {3, 1};
        System.out.println("Minimum Cost: " + minCost(horizontal, vertical));
    }
}
