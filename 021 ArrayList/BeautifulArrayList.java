import java.util.*;

public class BeautifulArrayList {

    public static List<Integer> beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            List<Integer> temp = new ArrayList<>();

            // Generate odd numbers from previous result
            for (int num : result) {
                if (2 * num - 1 <= n)
                    temp.add(2 * num - 1);
            }

            // Generate even numbers from previous result
            for (int num : result) {
                if (2 * num <= n)
                    temp.add(2 * num);
            }

            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5; // Change n value for testing
        List<Integer> beautiful = beautifulArray(n);
        System.out.println(beautiful);
    }
}
