public class NKnights {
    static  int count =0;
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board,0,0,n);
        System.out.println("No. of ways in which N Knight can be placed : "+ count);
        
    }

    static void solve(char[][] board,int row  , int col, int remainingKnights) {
        if(remainingKnights==0){ //Base Case
            printBoard(board); //run this line upto n=4, else it will keep print all posible ways
            count++;
            return;
        }
        if(row>=board.length) return; // When all row has finished
        if(col>=board.length) { // when all columns of a row is finished
            solve(board, row+1, 0, remainingKnights);
            return;
        }


        if(isSafe(board, row, col)){
            board[row][col]='K'; //Place Knight
            solve(board, row, col+1, remainingKnights-1); //Solve for more
            board[row][col]='.'; //Backtracking
        }

        //Skip placeing Knight
        solve(board, row, col+1, remainingKnights);

    }

    static void printBoard(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isInbound(char[][] board , int row , int col){
        return  (row>=0) && (col>=0) && (row<board.length) && (col<board.length);
    }

    static boolean isSafe(char[][] board, int row, int col) {
        //Check for Upper left
        if(isInbound(board, row-2, col-1)){
            if (board[row-2][col-1] == 'K') {
                return false;
            }
        }
        //Check for Upper Right
        if(isInbound(board, row-2, col+1)){
            if (board[row-2][col+1] == 'K') {
                return false;
            }
        }
        //Check for 2ndUpper left
        if(isInbound(board, row-1, col-2)){
            if (board[row-1][col-2] == 'K') {
                return false;
            }
        }
        //Check for 2ndUpper Right
        if(isInbound(board, row-1, col+2)){
            if (board[row-1][col+2] == 'K') {
                return false;
            }
        }
        return true;
    }
}
