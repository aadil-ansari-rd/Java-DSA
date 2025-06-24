public class FindAllOccurence{
    static void findAllOccurence(int[] arr, int key , int i){
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i + " ");
        }
        findAllOccurence(arr, key, i+1);
    }
    public static void main(String[] args){
        int[] arr = {3,2,4,5,6,2,7,2,2};
        findAllOccurence(arr, 2, 0);
    }
}