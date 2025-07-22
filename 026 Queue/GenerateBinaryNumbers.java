// Q1
public class GenerateBinaryNumbers {

    public static String binary(int num){
        String ans = "";

        while (num!=0) {
            ans =  num%2 + ans;
            num/=2;
        }

        return ans;
    }
    public static void generateBinaryNumbers(int n){
        for(int i=1;i<=n;i++){
            System.out.print(binary(i) + " ");
        }
    }
    public static void main(String[] args) {
        generateBinaryNumbers(10);
    }
}
