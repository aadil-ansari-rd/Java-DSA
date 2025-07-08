import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean duplicateParenthesis(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // Push all characters except closing parenthesis ')'
            if (ch != ')') {
                st.push(ch);
            } else {
                int count = 0;
                // Count how many characters are between '(' and ')'
                while (st.peek() != '(') {
                    count++;
                    st.pop();
                }
                // Pop the matching opening '('
                st.pop();
                // If there were no characters between '()', it's a duplicate
                if (count < 1) {
                    return true;
                }
            }
        }
        // No duplicate parentheses found
        return false;
    }

    public static void main(String[] args) {
        System.out.println(duplicateParenthesis("((a+b+(c+d)))"));
    }
}
