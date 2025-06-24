
public class SetIdxBit {

    public static int setIdxBit(int num, int idx) {
        return (num | (1 << idx));
    }

    public static void main(String[] args) {
        System.out.println(setIdxBit(11, 2));
    }
}
