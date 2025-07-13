import java.util.Stack;

public class ValidParenthesis {
    // public static boolean validParenthesis(String str){
    // Stack<Character> st = new Stack<>();
    // int n= str.length();
    // for(int i=0;i<n;i++){
    // char ch = str.charAt(i);
    // if(ch=='(' || ch=='[' ||ch=='{'){
    // st.push(ch);
    // }
    // if(ch==')' || ch == ']' || ch=='}'){
    // if(st.isEmpty()) return false;
    // char check = st.peek();
    // if(ch==')'){
    // if(check=='('){
    // st.pop();
    // }else{
    // return false;
    // }
    // }else if(ch==']'){
    // if(check=='['){
    // st.pop();
    // }else{
    // return false;
    // }
    // }else{
    // if(check=='{'){
    // st.pop();
    // }else{
    // return false;
    // }
    // }

    // }
    // }
    // if(st.isEmpty()){
    // return true;
    // }
    // return false;
    // }

    public static boolean validParenthesis(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (st.isEmpty())
                    return false;
                char top = st.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParenthesis("()[]{}]"));
    }
}
