public class OneToN{
    public static void oneToN(int n){
        if(n<1){
            return ;
        }
        oneToN(n-1);
        System.out.println(n);
    }
    public static void main(String[] args){
        oneToN(10);
    }

}