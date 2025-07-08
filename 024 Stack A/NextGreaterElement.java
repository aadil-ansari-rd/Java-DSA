import java.util.Stack;
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums){
        Stack <Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=nums[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25};
        int[] ans = nextGreaterElement(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
