
public class DiagonalSum {

    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;


        //O(n^2)
        // for(int i=0;i< n;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(i==j){
        //             sum+=matrix[i][j];
        //         }else if(i+j==matrix.length-1){
        //             sum+=matrix[i][j];

        //         }
        //     }
        // }


        //O(n)
        for (int i = 0; i < n; i++) {
            //Primary Diagonal
            sum += matrix[i][i];
            //Secondary Diagonal : i+j =n-1 => j=n-1-i
            if (i != n - 1 - i) {
                sum += matrix[i][n - 1 - i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(diagonalSum(matrix));
    }

}
