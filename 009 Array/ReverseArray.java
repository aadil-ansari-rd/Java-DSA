
public class ReverseArray {

    public static void reverseArray(int[] nums) {
        int st = 0, end = nums.length - 1;
        while (st < end) {
            nums[st] = nums[st] + nums[end];
            nums[end] = nums[st] - nums[end];
            nums[st] = nums[st] - nums[end];
            st++; end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7, 8, 10, 11, 12, 13, 16, 18, 19, 22, 25, 26, 28, 30, 34, 35, 36, 38, 39, 41, 43, 44, 45, 47, 48, 53, 55, 56, 60, 62, 63, 67, 73, 75, 78, 80, 81, 84, 85, 86, 88, 90, 91, 92, 97, 98};
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        reverseArray(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }
}
