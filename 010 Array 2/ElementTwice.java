// Given an integer array nums, return true if any value appears at least twice in the 
//   array, and return false if every element is distinct.


public class ElementTwice {

    public static boolean elementTwice(int[] nums){
        for(int i=0; i<nums.length;i++){
            for(int j =i+1; j<nums.length;j++){
                if(nums[j]==nums[i]){
                    return true;
                }
            }
        }
        return  false;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(elementTwice(nums));
    }
}
