import java.util.ArrayList;
import java.util.Collections;

public class SortingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(9);
        list.add(1);
        System.out.println("Normal ArrayList(Without Sorting) : " + list);
        Collections.sort(list);
        System.out.println("ArrayList After Sorting : " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("ArrayList After Reverse Sorting : " + list);
    }
}
