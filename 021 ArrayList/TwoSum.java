
import java.util.*;

public class TwoSum {
    //Input Array is already sorted.
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

    static List<Integer> optimised(ArrayList<Integer> list , int target){
        List<Integer> ans = new ArrayList<>();
        int st= 0, end = list.size() -1;
        while(st<end){
            int sum = list.get(st) + list.get(end)  ;
            if(sum==target){
                ans.add(st);
                ans.add(end);
                return ans;
            }else if(sum<target){
                st++;
            }else{
                end--;
            }
        }
        return ans;
    }
   

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println("With Brute Force Approach : " + bruteForce(list, 6));
        System.out.println("With Optimised Approach : " + optimised(list, 6));

       
    }
}
