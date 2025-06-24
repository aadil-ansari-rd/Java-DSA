
import java.util.Scanner;

public class SumOFOddEven {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // --------------
        int odd = 0, even = 0;
        int choice = 1;
        do {
            System.out.println("Enter your number : ");
            int num = sc.nextInt();
            if (num % 2 == 0) {
                even += num;
            } else {
                odd += num;
            }
            System.out.println("Enter 0 if you want results else press 1");
            choice = sc.nextInt();
        } while (choice != 0);
        System.out.println("Sum of odd numbers : " + odd);
        System.out.println("Sum of even numbers : " + even);
        sc.close();

    }
}
