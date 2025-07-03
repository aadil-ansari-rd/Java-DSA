public class GridWays {
    public static void main(String[] args){
        int n=3, m=3;
        System.out.println("Total no. of ways : " + gridWays(0, 0, m, n));
    }

    static int gridWays(int row, int col, int m , int n ){
        if(row==m-1 && col==n-1) return 1;
        if(row>= m || col>= n ) return 0;

        int right = gridWays(row, col+1, m,n);
        int down = gridWays(row+1, col, m,n);
        return right + down;
    }
}
