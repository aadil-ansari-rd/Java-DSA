class Pattern14{

//         1 
//       1 2 1
//     1 2 3 2 1
//   1 2 3 4 3 2 1
// 1 2 3 4 5 4 3 2 1

    public static void P(int n){
        for(int i=1; i<=n;i++){
            int spaces = n-i;
            for(int j=1; j<=spaces;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(j + " ");
            }
            for(int j=i-1;j>=1;j--){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        P(5);
    }
}