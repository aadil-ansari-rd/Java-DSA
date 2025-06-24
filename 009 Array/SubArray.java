public class SubArray {
    public static void subArray(int[] nums){
        for(int i=0; i<nums.length;i++){
            for(int j=0;j<nums.length; j++){
                for(int k=i;k<=j;k++){
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
                System.out.println();

        }
    }
    public static void main(String[] args){
        int[] nums = {1, 3, 5, 6, 7};
        subArray(nums);

    }
}
