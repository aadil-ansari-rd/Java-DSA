import java.util.Scanner;

public class PrimeRange {
    public static boolean isPrime(int num) {
        if(num<2){
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
        System.out.println("Enter max number in range : ");
        int num = sc.nextInt();
        System.out.println("Prime Numbers in the given range are : ");
        for (int i=2; i<=num ;i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
        sc.close();
        
    }
}
