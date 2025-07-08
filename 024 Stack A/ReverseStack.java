import java.util.Stack;
public class ReverseStack {
    public static void pushAtBottom(Stack<Integer> st , int data){
        //Base Case
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int currVal = st.pop();
        pushAtBottom(st, data);
        st.push(currVal);
    }
    static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int data = st.pop();
        reverseStack(st);
        pushAtBottom(st, data);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        st.push(9);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }
}
