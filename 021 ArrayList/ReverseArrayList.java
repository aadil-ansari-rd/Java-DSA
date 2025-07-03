import java.util.ArrayList;

public class ReverseArrayList{
    static void reverseArrayList(ArrayList<Integer>list){
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+ " ");
        }
    }
    public static void main(String[] args){
        ArrayList<Integer>  list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println("Array List   :  "+ list);
        System.out.print("Reverse Array List   :  ");
        reverseArrayList(list);
        System.out.println();
        System.out.print("Array List with forEach loop : ");
        for(Integer val : list){
            System.out.print(val + " ");
        }

    }
}