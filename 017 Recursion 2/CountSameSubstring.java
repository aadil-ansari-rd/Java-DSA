public class CountSameSubstring {
    public static int countSameSubstring(String s , int st , int end){
        if(st==s.length())return  0;
        if(end == s.length()){
            return countSameSubstring(s, st+1, st+1);
        }
        int count = s.charAt(st)==s.charAt(end)?1:0;
        return count + countSameSubstring(s, st, end+1);
    }
    public static void main(String[] args) {
        System.out.println(countSameSubstring("abcab", 0, 0));
        System.out.println(countSameSubstring("aba", 0, 0));
    }
}
