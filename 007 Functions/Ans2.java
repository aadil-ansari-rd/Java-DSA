
import java.util.Scanner;

// Write a method named isEven that accepts an int argument. The method
// should return true if  the argument is even,or false otherwise.Also write a program to test your
// method.
public class Ans2 {
    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        System.err.println(isEven(n));
        sc.close();
    }
}
