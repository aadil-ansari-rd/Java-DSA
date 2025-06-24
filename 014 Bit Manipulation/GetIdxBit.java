public class GetIdxBit {
    public static int getIdxBit(int num , int idx){
        return  (num & (1<<idx))>>idx;
    }
    public static void main(String[] args) {
        System.out.println(getIdxBit(15, 0));
    }
}
