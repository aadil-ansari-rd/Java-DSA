public class TilingProb{

    static int tilingWays(int n){
        if(n==0||n==1)return 1;

        int verticalWays = tilingWays(n-1);
        int horizontalWays = tilingWays(n-2);

        int totalWays = verticalWays + horizontalWays ;
        return totalWays;
    }


    public static void main(String[] args) {
        System.out.println(tilingWays(4));
    }
}