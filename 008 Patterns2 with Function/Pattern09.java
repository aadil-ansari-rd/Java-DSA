
public class Pattern09 {

// 1 
// 0 1
// 1 0 1
// 0 1 0 1
// 1 0 1 0 1

    public static void P(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i+j) % 2 == 1) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(1 + " ");
                }
                
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        P(5);
        
    }
}
