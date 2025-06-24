public class MaxSumSubArray {
    public static void subArray(int[] nums){
    int sum , maxSum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length;i++){
            for(int j=i;j<nums.length; j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    System.out.print(nums[k] + " ");
                    sum+=nums[k];
                }
                if(sum>maxSum){
                    maxSum=sum;
                }
                
                System.out.print( ", sum = " + sum);
                System.out.println();
            }
                System.out.println();

        }
                System.out.println("maximun Sum = "+ maxSum);

    }
    public static void main(String args[]){
        int[] nums = {1, 3, 5, 6, 7};
        subArray(nums);
    }
}
