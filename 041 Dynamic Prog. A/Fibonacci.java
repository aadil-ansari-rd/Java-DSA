import java.util.Arrays;

public class Fibonacci {

    // 🔹 Recursive approach (pure recursion, no optimization)
    public static int fibRec(int n) {
        // Base case: F(0) = 0, F(1) = 1
        if (n <= 1)
            return n;

        // Recursive calls for F(n-1) and F(n-2)
        return fibRec(n - 1) + fibRec(n - 2);
    }

    // 🔹 Memoization approach (Top-Down DP)
    public static int fibMemo(int n, int[] memo) {
        // Base case
        if (n <= 1)
            return n;

        // If already computed, return stored value
        if (memo[n] != -1) {
            return memo[n];
        }

        // Store computed value to avoid recomputation
        return memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    }

    // 🔹 Tabulation approach (Bottom-Up DP)
    public static int fibTab(int n) {
        // Base case
        if (n <= 1)
            return n;

        // Create DP array to store results
        int[] tab = new int[n + 1];
        tab[0] = 0; // F(0)
        tab[1] = 1; // F(1)

        // Fill table iteratively
        for (int i = 2; i <= n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }

        // Return nth Fibonacci number
        return tab[n];
    }

    public static void main(String[] args) {
        int n = 30; // Example value for nth term

        // Test recursion method
        System.out.println("Nth Term with : Recursion");
        System.out.println(fibRec(n));

        // Test memoization method
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize memo array with -1
        System.out.println("Nth Term with : Memoization");
        System.out.println(fibMemo(n, memo));

        // Test tabulation method
        System.out.println("Nth Term with : Tabulation");
        System.out.println(fibTab(n));
    }
}


// import java.util.Arrays;

// public class Fibonacci{

//     public static int fibRec(int n ){
//         if(n<=1) return n ;
//         return fibRec(n-1)+ fibRec(n-2);
//     }

//     public static int fibMemo(int n , int[] memo){
//         if(n<=1) return n;
//         if(memo[n]!=-1){
//             return memo[n];
//         }
//         return memo[n]= fibMemo(n-1, memo) + fibMemo(n-2, memo);
//     }

//     public static int fibTab(int n){
//         if(n<=1)return n;
//         int[] tab = new int[n+1];
//         tab[0] = 0;
//         tab[1] = 1;
//         for(int i=2;i<=n;i++){
//             tab[i]= tab[i-1]+tab[i-2];
//         }
//         return tab[n];
//     }

//     public static void main(String[] args) {
//         int n =30 ;
//         System.out.println("Nth Term with : Recursion");
//         System.out.println(fibRec(n));

//         int[] memo = new int[n+1];
//         Arrays.fill(memo, -1);
//         System.out.println("Nth Term with : Memoization");
//         System.out.println(fibMemo(n,memo));

//         System.out.println("Nth Term with : Tabulation");
//         System.out.println(fibTab(n));

//     }
// }