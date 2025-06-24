
public class StringCompression {

    public static String compressStrings(String str) {
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            ans.append(str.charAt(i));
            if (count > 1) {
                ans.append(count.toString());

            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressStrings("aaaahhhhidddd"));
    }
}
