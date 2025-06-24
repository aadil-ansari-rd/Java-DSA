
public class DigitToString {
    static String[] str = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    public static void digitToString(int num) {
        if (num == 0) {
            return;
        }
        digitToString(num / 10);
        int lastDigit = num % 10;
        System.out.print(str[lastDigit]);
    }

    public static void main(String[] args) {
        digitToString(19896); // 0 can not come at the begining of the number
    }
}
