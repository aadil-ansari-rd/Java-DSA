// Write a Java program tocheckifanumberisapalindromeinJava?(121isa
// palindrome, 321 is not)
// A number is called a palindrome if the number is equal to the reverse of a number  e.g.,121 is a
// palindrome because the reverse of 121 is 121 itself. On the other hand, 321 is not a
// palindrome because the reverse of 321 is 123, which is not equal to 321.
// import java.util.Scanner;

import java.util.Scanner;

public class Ans3 {

    public static boolean isPallindrome(int num) {
        int cpy = num;
        int newNum = 0;
        while (num > 0) {
            int rem = num % 10;
            newNum = newNum * 10 + rem;
            num /= 10;
        }
        if (cpy == newNum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        if (isPallindrome(num)) {
            System.out.println(num + " is a Pallindrome Number.");
        } else {
            System.out.println(num + " is a Pallindrome Number.");

        }
        sc.close();
    }
}
