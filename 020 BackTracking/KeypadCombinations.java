import java.util.*;

public class KeypadCombinations {

    // Phone keypad mapping for digits 2-9
    static String[] mapping = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    // Function to generate all combinations
    public static void generateCombinations(String digits, int index, String current) {
        // Base case: all digits processed
        if (index == digits.length()) {
            if (!current.isEmpty()) System.out.println(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];

        // For each letter corresponding to current digit
        for (int i = 0; i < letters.length(); i++) {
            generateCombinations(digits, index + 1, current + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digits = "23";  // you can change input here

        if (digits.isEmpty()) {
            System.out.println("");
            return;
        }
        generateCombinations(digits, 0, "");
    }
}
