public class LastOccurence {
    public static int lastOccurence(int[] arr , int key , int i){
        if(i<0) return  -1;
        if(arr[i]==key) return i;
        return  lastOccurence(arr, key, i-1);
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 13 ,5,6,9};
        System.out.println(lastOccurence(arr, 13, arr.length-1));
    }
}
