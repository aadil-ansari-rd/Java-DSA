class UniqueSubstrings {

    // Trie Node class
    static class Node {
        Node[] children = new Node[26]; // For lowercase a-z
    }

    static Node root = new Node();
    static int count = 0; // Count of new nodes created

    // Function to insert a suffix into the Trie
    public static void insert(String str) {
        Node current = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            // If no path exists, create a new node
            if (current.children[index] == null) {
                current.children[index] = new Node();
                count++; // New node = new unique substring
            }
            current = current.children[index];
        }
    }

    // Main function to calculate total unique substrings
    public static int countUniqueSubstrings(String str) {
        // Insert all suffixes
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }
        return count + 1; // Add 1 for the empty string
    }

    // Driver code
    public static void main(String[] args) {
        String str = "ababa";
        System.out.println("Total unique substrings: " + countUniqueSubstrings(str));
    }
}
