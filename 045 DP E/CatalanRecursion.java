public class CatalanRecursion {

    // Recursive function to find nth Catalan number
    public static int catalan(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 0;

        // Apply recursive formula: Cn = sum(Ci * Cn-i-1)
        for (int i = 0; i < n; i++) {
            result += catalan(i) * catalan(n - i - 1);
        }

        return result;
    }

    // Driver method to test the recursion
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Catalan number for n = " + n + " is " + catalan(n));
    }
}
