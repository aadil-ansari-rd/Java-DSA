public class LexicographicallySmallestString {

    // Function to generate lexicographically smallest string
    public static String getSmallestString(int N, int K) {
        char[] result = new char[N];
        for (int i = 0; i < N; i++) result[i] = 'a'; // initialize with 'a'
        K = K - N;  // since all are initialized to 'a'

        int index = N - 1;
        while (K > 0) {
            // We can increase max by 25 ('a' + 25 = 'z')
            int extra = Math.min(25, K);
            result[index] = (char)(result[index] + extra);
            K -= extra;
            index--;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(5, 42)); // Output: aamz
        System.out.println(getSmallestString(3, 25)); // Output: aaw
    }
}
