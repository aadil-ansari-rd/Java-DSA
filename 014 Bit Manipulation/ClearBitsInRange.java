public class ClearBitsInRange{
    public static int clearBitsInRange(int num , int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        return num & (a|b);
    }
    public static void main(String[] args){
        System.out.println(clearBitsInRange(10, 2, 4));
    }
}