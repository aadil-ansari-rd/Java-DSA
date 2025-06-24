public class ClearIdxBit {
    public static int clearIdxBit(int num , int idx){
        return num & (~(1<<idx));
    }
    public static void main(String[] args ){
        System.out.println(clearIdxBit(10,1));
    }
}
