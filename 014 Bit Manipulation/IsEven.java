public class IsEven {
    public static boolean isEven(int num){
        if((num&1)==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isEven(20));   
    }
}
