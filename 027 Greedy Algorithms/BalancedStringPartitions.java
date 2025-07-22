public class BalancedStringPartitions {

    // Function to count maximum balanced substrings
    public static int maxBalancedPartitions(String str) {
        int count = 0; // To count number of balanced substrings
        int balance = 0; // To track balance between L and R

        for (char ch : str.toCharArray()) {
            // Increment balance for 'L', decrement for 'R'
            if (ch == 'L') balance++;
            else if (ch == 'R') balance--;

            // Whenever balance becomes zero, we found a balanced substring
            if (balance == 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        System.out.println(maxBalancedPartitions(str)); // Output: 3
    }
}
