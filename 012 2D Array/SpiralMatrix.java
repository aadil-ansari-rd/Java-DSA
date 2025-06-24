public class SpiralMatrix{
    public static void spiralMatrix(int[][] matrix){
        int startRow =0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startCol<=endCol && startRow<=endRow){
            //Top row
            for(int i=startCol;i<=endCol;i++){
                System.out.print(matrix[startRow][i] + " ");
            }

            //Right Column
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol] + " ");

            }

            //End Row 
            for(int i=endCol-1;i>=startCol;i--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][i] + " ");

            }

            //Left Column
            for(int i=endRow-1;i>startCol;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");

            }

            //Updation
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }


    
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralMatrix(matrix);
    }
}