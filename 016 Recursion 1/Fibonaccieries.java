import java.util.Scanner;

public class Fibonaccieries {
    //Find nth position
    public static int fib(int n){
        if(n<=1) return n;
        return  fib(n-1)+fib(n-2);
    }

    //Print series
    public static void printSeries(int count , int position){
        if(count>position){
            return;
        }
        System.out.print(fib(count) + " ");
        printSeries(count+1, position);
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the postion upto which to print : ");
        int n = sc.nextInt();
        if(n<0){
            System.out.println("Position can not be a negative number.");
        }else{
            System.out.println("Fibbo series upto " + n + "Postion are : ");
            printSeries(0, n);
        }
    }
}
