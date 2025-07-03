public class GridWaysMath {
    public static void main(String[] args){
        int n=3, m=3;
        // long ways = 0;
        System.out.println("Total no. of ways : " + gridWays(m, n));
    }
    //nCr = ((n-1)+(m-1))!  / (n-1)! * (m-1)!
    static long gridWays( int m , int n ){
        return  factorial((n-1)+(m-1))/(factorial(n-1)*factorial(m-1));
    }
    static long factorial(int n ){
        if(n==1) return  1;
        return n * factorial(n-1);
    }
}
