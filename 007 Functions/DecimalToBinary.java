
import java.util.Scanner;

public class DecimalToBinary {

    public static long decimalToBinary(int DecNum) {
        int BiNum = 0;
        int pow = 0;
        while (DecNum > 0) {
            int rem = DecNum % 2;
            if (rem == 1) {
                BiNum = BiNum + (int)Math.pow(10, pow);

            }
            pow++;
            DecNum/=2;
        }
        return  BiNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number : ");
        int DecNum = sc.nextInt();
        System.out.println("Binary Number of " + DecNum + " is : " + decimalToBinary(DecNum));
        sc.close();
    }

}
