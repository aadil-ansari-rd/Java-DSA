public class PallindromeStr {

    public static boolean  isPallindrome(String str){
        int n = str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-1-i)){
                return  false;
            }
        }
        return  true;
    }

    public static boolean isPallindromePoint(String str){
        int st=0,end = str.length()-1;
        while(st<end){
            if(str.charAt(st)!=str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String name = "noton";
        System.out.println(isPallindromePoint(name));
        
    }
}