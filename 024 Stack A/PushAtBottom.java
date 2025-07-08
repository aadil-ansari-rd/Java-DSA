import java.util.Stack;
public class PushAtBottom {
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
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        st.push(9);
        System.out.println(st);
        pushAtBottom(st, 3);
        System.out.println(st);
    }
}
