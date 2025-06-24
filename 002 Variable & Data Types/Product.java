
import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        System.out.println("Value of a = ");
        int a = sc.nextInt();
        System.out.println("Value of b = ");
        int b = sc.nextInt();
        System.out.println("Product of a & b =" + (a*b));
        sc.close();

    }
}
