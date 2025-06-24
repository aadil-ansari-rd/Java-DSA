
class Solution {
    public static boolean isAlphanumeric(char ch){
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
            return true;
        }
        return false;
    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        int n =s.length();
        System.out.println(s);
        for(int i=0;i<n;i++){
            char ch = s.charAt(i) ;
            if(isAlphanumeric(ch)){
                str+=ch;
            }
        }
        System.out.println(str);
        int m = str.length();
        for(int i=0;i<m/2;i++){
            if(str.charAt(i)!=str.charAt(m-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ts = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(ts));
    }
}
