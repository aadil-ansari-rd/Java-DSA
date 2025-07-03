
public class NQueen1Solution {
    public static void main(String[] args) {
        int n = 10;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        if(solve(board, 0)){
            System.out.println("Solution Exists");
            printBoard(board);
        }else{
            System.out.println("Solution do not Exists");
        }
    }

    static boolean solve(char[][] board, int row) {
        if (row == board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';//Place Queen
                if(solve(board, row + 1)) return true; //Recursive call
                board[row][i] = '.';//Backtracking
            }
        }
        return false;
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

    static boolean isSafe(char[][] board, int row, int col) {
        //Check for col
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //Check for upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //Check for upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
