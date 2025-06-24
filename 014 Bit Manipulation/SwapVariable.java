
public class SwapVariable {

    public static void swap(int n, int m) {
        System.out.println("Variables before swap :- ");
        System.out.println("First Number : " + n + " , Second Number : " + m);
        n = n ^ m;
        m = n ^ m;
        n = n ^ m;
        System.out.println("First Number : " + n + " , Second Number : " + m);

    }

    public static void main(String[] args) {
        swap(3, 4);
    }
}
