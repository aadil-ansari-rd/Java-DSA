
public class Pattern04 {

// A 
// B C
// D E F
// G H I J
    public static void main(String[] args) {
        int n = 4;
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }
    }
}
