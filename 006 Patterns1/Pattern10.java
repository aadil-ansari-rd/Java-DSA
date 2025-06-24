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

    public static void main(String[] args) {
        int n = 8;
        for(int i=1; i<=n/2; i++){
            for(int j=1;j<=i; j++){
                System.err.print("* ");
            }
            for( int k =1; k<= n-(2*i); k++){
                System.out.print("  ");
            }
            for(int j=1;j<=i; j++){
                System.err.print("* ");
            }
            System.out.println();
        }
        for(int i=1; i<=n/2; i++){
            for(int j=1;j<=(n/2)-i+1; j++){
                System.err.print("* ");
            }
            for( int k =1; k<=(i-1)*2; k++){
                System.out.print("  ");
            }
            for(int j=1;j<=(n/2)-i+1; j++){
                System.err.print("* ");
            }
            System.out.println();
        }
    }
}
