
public class Pattern05 {

// * * * * * 
// *       *
// *       *
// * * * * *
    public static void main(String[] args) {
        int r = 4, c = 5;
        for (int i = 1; i <= r; i++) {
            if (i == 1 || i == r) {
                for (int j = 1; j <= c; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int k = 1; k <= c; k++) {
                    if (k == 1 || k == c) {
                        System.out.print("* ");

                    } else {
                        System.out.print("  ");

                    }
                }
            }
            System.out.println();

        }
    }
}
