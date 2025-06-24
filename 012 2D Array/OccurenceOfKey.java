public class OccurenceOfKey {

    static int occurenceOfKey(int[][] arr, int key) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == key) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr ={{1,3,7},{5,6,7}};
        System.out.println(occurenceOfKey(arr,7));
    }
}
