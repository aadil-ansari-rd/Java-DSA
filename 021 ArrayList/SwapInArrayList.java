import java.util.ArrayList;

public class SwapInArrayList {
    static void swap(ArrayList<Integer>list , int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1 , list.get(idx2));
        list.set(idx2 , temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println("Before Swap : " + list);
        swap(list, 2,4);
        System.out.println("After Swap : " + list);

    }
}
