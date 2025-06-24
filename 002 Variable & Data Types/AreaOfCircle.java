import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle");
        float rad = sc.nextFloat();
        System.out.println("Area of Circle = " + (3.14*rad*rad));
        sc.close();
    }    
} 
