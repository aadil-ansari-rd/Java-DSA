
public class Pattern12 {

//         * * * * * 
//       *       *   
//     *       *     
//   *       *       
// * * * * * 
    public static void P(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= n; k++) {
                if (i == 1 || i == n || k == 1 || k == n) {
                    System.out.print("* ");
                } else {

                    System.out.print("  ");

                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        P(5);

    }
}
