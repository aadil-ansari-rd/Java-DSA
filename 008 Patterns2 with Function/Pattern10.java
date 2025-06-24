
public class Pattern10 {

//Only for even numbers of rows
// *             * 
// * *         * *
// * * *     * * *
// * * * * * * * *
// * * * * * * * *
// * * *     * * *
// * *         * *
// *             *
//If there is a pattern which has increse or decrese number of spaces and after sometime it decrease 
// or increse so we should break that pattern into two , as follows :-
    public static void P(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.err.print("* ");
            }
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.err.print("* ");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.err.print("* ");
            }
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.err.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        P(4);

    }
}
