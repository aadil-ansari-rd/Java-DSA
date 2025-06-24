// Write a Java method to compute the averageof three numbers
import java.util.Scanner;

public class Ans1 {
    public static float  avg3(int a , int b , int c ){
        return (a+b+c)/3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Average of the given three numbers are : " + avg3(a, b, c));
        sc.close();
    }
}
