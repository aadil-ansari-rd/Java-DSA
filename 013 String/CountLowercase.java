import java.util.Scanner;

public class CountLowercase {
    public static int countLowerCase(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a' && ch<='z'){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String str = sc.nextLine();
        System.out.println("No. of lowercase character : " + countLowerCase(str));


        sc.close();


    }
}
