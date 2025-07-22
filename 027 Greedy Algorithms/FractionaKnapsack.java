import java.util.Arrays;
import java.util.Comparator;

public class FractionaKnapsack {
    public static double maxVal(int[] val, int[] weight, int w) {
        double[][] ratio = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i; // Storing original index
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Sorting in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(a -> a[1]));

        // Filling Knapsack
        double maxVal = 0;
        int capacity = w;
        for (int i = val.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                maxVal += val[idx];
                capacity -= weight[idx];
            } else {
                maxVal = maxVal + ratio[i][1] * capacity;
                capacity = 0;//Knapsack full
                break;
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] val1 = {60, 100, 120};
        int[] weight1 = {10, 20, 30};
        int capacity1 = 50;
        double result1 = maxVal(val1, weight1, capacity1);
        System.out.println("Maximum value for Test Case 1 = " + result1);

        // Test Case 2
        int[] val2 = {70, 80, 40};
        int[] weight2 = {20, 30, 10};
        int capacity2 = 40;
        double result2 = maxVal(val2, weight2, capacity2);
        System.out.println("Maximum value for Test Case 2 = " + result2);

        // Test Case 3
        int[] val3 = {20, 30, 50, 70};
        int[] weight3 = {5, 10, 15, 20};
        int capacity3 = 30;
        double result3 = maxVal(val3, weight3, capacity3);
        System.out.println("Maximum value for Test Case 3 = " + result3);
    }

}




// public static double maxVal(int[] val, int[] weight, int w) {
//     // Step 1: Create a ratio array to store index and value/weight ratio
//     double[][] ratio = new double[val.length][2];
//     for (int i = 0; i < val.length; i++) {
//         ratio[i][0] = i; // Storing original index
//         ratio[i][1] = val[i] / (double) weight[i]; // Calculating value/weight ratio
//     }

//     // Step 2: Sort activities by value/weight ratio in ascending order
//     Arrays.sort(ratio, Comparator.comparingDouble(a -> a[1]));

//     // Step 3: Fill the knapsack starting from highest value/weight ratio
//     double maxVal = 0; // To store the maximum total value
//     int capacity = w;  // Remaining capacity of the knapsack

//     // Start from highest ratio (descending order after ascending sort)
//     for (int i = val.length - 1; i >= 0; i--) {
//         int idx = (int) ratio[i][0]; // Get original index of item

//         // Step 4: If the full item can be taken
//         if (capacity >= weight[idx]) {
//             maxVal += val[idx]; // Take full value
//             capacity -= weight[idx]; // Reduce capacity
//         } 
//         // Step 5: If only fraction can be taken
//         else {
//             maxVal += ratio[i][1] * capacity; // Take fractional value
//             capacity = 0; // Knapsack full
//             break;
//         }
//     }

//     // Step 6: Return the total maximum value obtained
//     return maxVal;
// }
