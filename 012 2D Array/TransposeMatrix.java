public class TransposeMatrix{
    
    public static int[][] transpose(int[][] arr){
        int[][] mat = new int[arr[0].length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                mat[j][i]=arr[i][j];
            }
        }
        return mat;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{11,12,13},{21,22,23},{31,32,33},{41,42,43}};
        
        System.out.println("Before Transpose");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("After Transpose");
        int[][] transpose = transpose(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}