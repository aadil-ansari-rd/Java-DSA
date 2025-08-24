public class ParenthesesCombinations {

    // Function to calculate number of valid parentheses combinations using tabulation
    public static int countParenthesesCombinations(int n) {
        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 1;  
        if (n > 0) dp[1] = 1;

        // Fill dp array using Catalan recurrence
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }

    // Main function to test
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of valid parentheses combinations for n=" + n + " is: " 
                           + countParenthesesCombinations(n));

        n = 4;
        System.out.println("Number of valid parentheses combinations for n=" + n + " is: " 
                           + countParenthesesCombinations(n));
    }
}
