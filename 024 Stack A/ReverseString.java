import java.util.Stack;


public class ReverseString {
    public static String reverseString(String str) {
        Stack<Character> st = new Stack<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            st.push(str.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "irasna lidaa";
        System.out.println(reverseString(str));
    }
}
