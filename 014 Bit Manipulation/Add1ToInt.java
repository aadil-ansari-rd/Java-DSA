public class Add1ToInt {
    public static int add1ToInt(int num){
        return  -~num;
    }
    public static void main(String[] args) {
        System.out.println(add1ToInt(5));
        System.out.println(add1ToInt(-5));
        System.out.println(add1ToInt(0));

    }
}
