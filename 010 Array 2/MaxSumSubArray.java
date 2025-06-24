
public class MaxSumSubArray {

    public static void subArraySum(int[] nums) {
        int sum, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }

            }

        }
        System.out.println("maximun Sum = " + maxSum);

    }

    public static void subArraySumBetter(int[] nums) {
        int sum, maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if (sum > maxSum) {
                    maxSum = sum;
                    
                }
            }
        }
        System.out.println("maximun Sum = " + maxSum);

    }

    public static void Kadans(int[] nums){
        int sum =0, maxSum = Integer.MIN_VALUE;
        int maxNegNum = Integer.MIN_VALUE;
        for(int i=0 ; i<nums.length; i++){
            sum+= nums[i];
            if(sum<0){
                sum = 0;
            }
            maxSum = Math.max(sum, maxSum);
            maxNegNum = Math.max(maxNegNum, nums[i]);

        }
        if(maxSum==0){
        System.out.println("maximun Sum = " + maxNegNum);

        }else{
        System.out.println("maximun Sum = " + maxSum);

        }

    }
    public static void main(String args[]) {
        int[] nums = { -3, -5, -6, -7, -1};
        subArraySum(nums);
        subArraySumBetter(nums);
        Kadans(nums);
    }
}
