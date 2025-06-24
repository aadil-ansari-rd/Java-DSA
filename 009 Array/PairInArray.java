public class PairInArray {
    public static void pairInArray(int[] nums) {
        int end = nums.length ;
        for(int i=0 ; i<(end-1);i++){
            for (int j = i + 1; j < end; j++) {
                System.out.print(" ( " + nums[i] + " , " + nums[j] + " ) ");
            }
            System.out.println();
        }    
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7};
        pairInArray(nums);
    }
}
