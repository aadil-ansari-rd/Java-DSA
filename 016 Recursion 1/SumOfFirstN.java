public class SumOfFirstN {
    public static int sumOfFirstN(int n){
        if(n==1){
            return  1;
        }
        return  n + sumOfFirstN(n-1);
    }
    public static void main(String[] args) {
        System.out.println(sumOfFirstN(6));
    }
}
