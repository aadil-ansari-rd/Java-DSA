public class TransposeOfSquareMat{
    
    public static void transpose(int[][] arr){
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         if(i<=j){
        //             int temp = arr[i][j];
        //             arr[i][j]=arr[j][i];
        //             arr[j][i]=temp;
        //         }
        //     }
        // }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr[0].length;j++){
                    int temp = arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
            }
        }
        
    }
        
        
    
    public static void main(String[] args) {
        int[][] arr = {{11,12,13},{21,22,23},{31,32,33}};
        
        System.out.println("Before Transpose");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("After Transpose");
        transpose(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}