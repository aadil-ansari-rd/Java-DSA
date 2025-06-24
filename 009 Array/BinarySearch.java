
public class BinarySearch {

    public static int binarySearch(int[] nums, int key) {
        int st = 0, end = nums.length-1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6, 7, 8, 10, 11, 12, 13, 16, 18, 19, 22, 25, 26, 28, 30, 34, 35, 36, 38, 39, 41, 43, 44, 45, 47, 48, 53, 55, 56, 60, 62, 63, 67, 73, 75, 78, 80, 81, 84, 85, 86, 88, 90, 91, 92, 97, 98};
        int key = 39;
        int index = binarySearch(nums, key);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Your element is at index : " + index);
        }

    }
}
