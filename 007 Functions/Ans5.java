// Write a Java method to compute the sum of the digits in an integer.
import java.util.Scanner;

public class Ans5 {
    public static int digitSum(int n ){
        int digitSum = 0;
        while(n>0){
            digitSum += n%10;
            n/=10;
        }
        return  digitSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        System.out.println("Digit sum of " + num + "is : " + digitSum(num));
        sc.close();
    }
}
