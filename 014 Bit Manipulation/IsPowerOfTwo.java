public class IsPowerOfTwo {
    public static boolean  isPowerOfTwo(int num){
        if(num<=0) return  false;
        if((num &(num-1))==0){
            return  true;
        }
        return  false;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(128));
    }
}
