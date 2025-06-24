public class OptimisedPowerOfN {
    public static int optimisedPowerOfN(int x ,int n){ //TC = O(n)
        if(n==0) return 1;
        int halfPowerSq = optimisedPowerOfN(x, n/2)*optimisedPowerOfN(x , n/2);
        if(n%2!=0){
            halfPowerSq = x* halfPowerSq; 
        }
        return  halfPowerSq;
    }
    public static int optimisedPowerOfN2(int x , int n){ //TC = O(logN)
        if(n==0) return 1;
        int halfPower = optimisedPowerOfN2(x, n/2);
        int halfPowerSq = halfPower * halfPower;
        if(n%2!=0){
            halfPowerSq = x* halfPowerSq; 
        }
        return  halfPowerSq;
    }
    public static void main(String[] args) {
        System.out.println(optimisedPowerOfN(2, 10));
        System.out.println(optimisedPowerOfN2(2, 10));
    }
}
