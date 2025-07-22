
public class QuickSort {

    public static void quickSort(int[] arr, int st, int end) {
        if (st < end) {
            int pivotIdx = partitionFunction(arr, st, end);
            quickSort(arr, st, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, end);
        }
    }

    public static int partitionFunction(int[] arr, int st, int end) {
        int pivot = arr[end];
        int i = st - 1;
        for (int j = st; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1]= arr[end];
        arr[end] = temp;
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 34, 657, 2, 564, 57, 234, 756, 67};
        System.out.println("Before sort : ");
        for (int num : arr) {
            System.out.print(num + " , ");
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println("\nAfter sort : ");
        for (int num : arr) {
            System.out.print(num + " , ");
        }
    }
}
