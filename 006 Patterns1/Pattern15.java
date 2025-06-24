
public class Pattern15 {

//         1 
//       2 1 2
//     3 2 1 2 3
//   4 3 2 1 2 3 4
// 5 4 3 2 1 2 3 4 5
    static void nums(int n) {
        int t = n;
        while (t > 1) {
            System.out.print(t-- + " ");
        }

        while (t <= n) {
            System.out.print(t++ + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            nums(i);
            System.out.println();
        }
    }
}
