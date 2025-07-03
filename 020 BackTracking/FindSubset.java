
public class FindSubset {

    public static void findSubset(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null"); 
                return;
            } else {
                System.out.println(ans);
                return;
            }

        }
        char ch = str.charAt(i);
        findSubset(str, ans + ch, i + 1);
        findSubset(str, ans, i + 1);

    }

    public static void main(String[] args) {
        String str = "abc";
        findSubset(str, "", 0);
    }
}
