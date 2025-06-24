
import java.util.Scanner;

public class BinaryToDecimal {

    public static int binaryToDecimal(long BiNum) {
        int dec = 0;
        int pow = 0;
        while (BiNum > 0) {
            int rem = (int)BiNum % 10;
            if (rem == 1) {
                dec = dec + (int) Math.pow(2, pow);

            }
            pow++;
            BiNum/=10;
        }

        return dec;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number : ");
        long BiNum = sc.nextLong();
        System.out.println("Decimal of "+ BiNum + " = "+ binaryToDecimal(BiNum));
        sc.close();
    }
}
