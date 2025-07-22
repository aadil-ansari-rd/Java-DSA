import java.util.*;

public class IndianCoins {
    public static void minCoins(int amount) {
        int[] coins = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        List<Integer> result = new ArrayList<>();

        // Step 1: Pick largest coin possible at each step
        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }

        // Step 2: Print coins used
        System.out.println("Coins/Notes used: " + result);
    }

    public static void main(String[] args) {
        int amount = 1219;
        minCoins(amount);
    }
}
