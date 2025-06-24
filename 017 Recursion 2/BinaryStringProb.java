public class BinaryStringProb{
    public static void binaryStrings(int num , String str , int lastDigit){

        if(num==0){
            System.out.println(str);
            return;
        }

        //Add 0 in all cases
        binaryStrings(num-1, str+"0",0);
        if(lastDigit==0){
            binaryStrings(num-1, str+"1", 1);
        }
    }
    public static void main(String[] args){
        binaryStrings(3, "",0);
    }
}