
public class UpperCasetoLowerCase {

    public static void main(String[] args) {
        System.out.println("Uppercase to Lowercase.....");
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.print((char) (i | ' '));
        }
        System.out.println();
        System.out.println();
        System.out.println("Lowercase to Uppercase.....");
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print((char) (i & '_'));
        }
    }
}
