
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static boolean isAnagram(String s1 , String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if(s1.length() == s2.length()){
            char[] s1cahrArray = s1.toCharArray();
            char[] s2cahrArray = s2.toCharArray();
            Arrays.sort(s1cahrArray);
            Arrays.sort(s2cahrArray);

            if(Arrays.equals(s1cahrArray, s2cahrArray)){
                return true;
            }else{
                return  false;
            }
        }
        return  false;

    }
    public static boolean isAnagramHashMap(String s , String t){
        if(s.length()!= t.length())return false ;

        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            m1.put(s.charAt(i), m1.getOrDefault(s.charAt(i),0) + 1);
            m2.put(t.charAt(i), m2.getOrDefault(t.charAt(i),0) + 1);
        }
        System.out.println(s + "  " + t);

        return m1.equals(m2);
    }

    public static boolean isAnagramCountArray(String s , String t){
        if(s.length() != t.length()) return  false ;

        int[] count = new int[26];

        for(int i=0; i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int c : count){
            if(c!=0){
                return  false;
            }
        }
        System.out.println(s + "  " + t);
        return  true;
    }
    public static void main(String[] args) {
        String str1= "eat";
        String str2 = "tea";
        System.out.println(isAnagram(str1, str2) );
        System.out.println(isAnagramHashMap(str1, str2) );
        System.out.println(isAnagramCountArray(str1, str2));
    }
}
