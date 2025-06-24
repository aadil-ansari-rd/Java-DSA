
import java.util.*;

class Prime {

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        if (isPrime(num)) {
            System.out.println(num + " is Prime Number .");
        } else {
            System.out.println(num + " is not a Prime Number");

        }
        sc.close();

    }
}
