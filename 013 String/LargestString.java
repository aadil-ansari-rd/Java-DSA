public class LargestString {

    public static String largestString(String[] names){
        String largest = names[0];
        for(int i=1;i<names.length;i++){
            int cmp = largest.compareToIgnoreCase(names[i]);
            if(cmp<0){
                largest = names[i];
            }
        }
        return largest;
    }

    public static void main(String[] args){
        String[] names = {"apple", "banana", "grapes", "cherry"};
        System.out.println(largestString(names));
    }
}
