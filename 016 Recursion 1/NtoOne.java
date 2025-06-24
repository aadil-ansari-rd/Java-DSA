public class NtoOne {
    public static void nToOne(int n){
        if(n<1){
            return;
        }
        System.out.println(n);
        nToOne(n-1);
    }
    public static void main(String[] args) {
        nToOne(10);
    }
}
