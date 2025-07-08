import java.util.Stack;

public class StockSpan {
    public static int[] stockSpan(int[] prices) {
        Stack<Integer> st = new Stack<>(); // Stack stores indices of days
        int n = prices.length;
        int[] span = new int[n]; // Result array to store span values

        for (int i = 0; i < n; i++) {
            int val = prices[i];

            // Pop elements from stack while current price is greater or equal to price at
            // stack's top index
            while (!st.isEmpty() && (prices[st.peek()] <= val)) {
                st.pop();
            }

            // If stack is empty, it means no greater element to the left → span = i+1
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Else, span = distance between current day and the last greater price day
                span[i] = i - st.peek();
            }

            // Push current index onto stack
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        int[] stock = stockSpan(prices);
        for (int i : stock) {
            System.out.print(i + " ");
        }
    }
}
