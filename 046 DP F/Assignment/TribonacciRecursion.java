public class TribonacciRecursion {

    // Recursive function to calculate nth Tribonacci number
    public int tribonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Recursive relation: T(n) = T(n-1) + T(n-2) + T(n-3)
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    // Testing the function
    public static void main(String[] args) {
        TribonacciRecursion obj = new TribonacciRecursion();

        System.out.println("Tribonacci(4): " + obj.tribonacci(4));  // Output: 4
        System.out.println("Tribonacci(25): " + obj.tribonacci(25)); // Output: 1389537
    }
}
