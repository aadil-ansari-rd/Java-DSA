
import java.util.*;
public class TwoDArrayList {
    static  void twoDArrayListEasy(){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            list.add(new ArrayList<>());  // Initialize inner ArrayList
            for(int j=1;j<=10;j++){
                list.get(i).add((i+1)*j);
            }
        }

        for(ArrayList<Integer> l : list ){
            for(Integer val : l){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();

        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=1;i<=10;i++){
            list0.add(i*1);
            list1.add(i*2);
            list2.add(i*3);
        }
        main.add(list0);
        main.add(list1);
        main.add(list2);
        for(int i=0;i<main.size();i++){
            for(int j=0;j<main.get(i).size();j++){
                System.out.print(main.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("Second Method To handle : ");
        twoDArrayListEasy();
    }
}
