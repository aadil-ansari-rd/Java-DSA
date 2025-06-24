
public class LengthOfString {

    public static int lengthOfString(String str) {
        if (str.equals("")) {
            return 0;
        }
        return 1 + lengthOfString(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(lengthOfString("Aasdfjaferf"));
    }
}
