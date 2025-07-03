
import java.util.ArrayList;
import java.util.List;

public class PairSum {

    //Input Array is rotated sorted
    static List<Integer> bruteForce(ArrayList<Integer> list, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if (sum == target) {
                    ans.add(i);
                    ans.add(j);
                    return ans;
                }
            }
        }
        return ans;
    }

    static List<Integer> optimised(ArrayList<Integer> list, int target) {
        List<Integer> ans = new ArrayList<>();
        int n = list.size(); //Size of list
        int pivot = -1; //Pivot point to find exactly at what position array is rotated.
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        int st = pivot + 1, end = pivot;
        //This will give partial sorted array that can be complete sorted with modular airthmatics.

        while (st != end) {
            int sum = list.get(st) + list.get(end);
            // Case : 1
            if (sum == target) {
                ans.add(st);
                ans.add(end);
                return ans;
            } else if (sum < target) { // Case : 2
                st = (st + 1) % n;
            } else { // Case : 3
                end = (n + end - 1) % n;
                //(n + end - 1) this expression uses 'n' because it will create problen 
                //when "end=0" => "end-1" will give negative index that is not valid
                //so 'n' is used . And 'n' is completely absorbed bu modulus when "end!=0"
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println("With Brute Force Approach : " + bruteForce(list, 16));
        System.out.println("With Optimised Approach : " + optimised(list, 16));
    }
}
