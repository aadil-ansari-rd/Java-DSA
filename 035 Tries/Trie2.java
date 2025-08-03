public class Trie2 {
    class Node{
        Node[] children = new Node[26];
        boolean isEndOfWord =false ;
    }
    private final Node root;
    public Trie2(){
        root = new Node();
    }


    //Insert a word into Trie
    public void insert(String word){
        Node node = root;
        for(char ch : word.toCharArray()){
            int index = ch -'a';
            if(node.children[index]==null){
                node.children[index]= new Node();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    //Search a word in Trie
    public boolean search(String word){
        Node node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index]==null)return false;
            node = node.children[index];
        }
        return node.isEndOfWord==true?true:false;
    }

    // Returns true if any word starts with given prefix
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(node.children[index]==null)return false;
            node = node.children[index];
        }
        return true;
    }


    public static void main(String[] args) {
        Trie2 trie = new Trie2();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.startsWith("aps")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}



// public class Trie2 {

//     // Node class representing each character node in the Trie
//     class Node {
//         Node[] children = new Node[26]; // 26 lowercase English letters
//         boolean isEndOfWord = false;    // Marks the end of a complete word
//     }

//     private final Node root; // Root node of the Trie

//     public Trie2() {
//         root = new Node(); // Initialize root when Trie is created
//     }

//     // Inserts a word into the Trie
//     public void insert(String word) {
//         Node node = root;
//         for (char ch : word.toCharArray()) {
//             int index = ch - 'a'; // Convert character to index (0-25)
//             if (node.children[index] == null) {
//                 node.children[index] = new Node(); // Create new node if it doesn't exist
//             }
//             node = node.children[index]; // Move to the child node
//         }
//         node.isEndOfWord = true; // Mark the end of the word
//     }

//     // Searches for a complete word in the Trie
//     public boolean search(String word) {
//         Node node = root;
//         for (char ch : word.toCharArray()) {
//             int index = ch - 'a';
//             if (node.children[index] == null) return false; // If node doesn't exist, word not present
//             node = node.children[index];
//         }
//         return node.isEndOfWord == true ? true : false; // Return true only if it's a complete word
//     }

//     // Returns true if there is any word in the Trie that starts with the given prefix
//     public boolean startsWith(String prefix) {
//         Node node = root;
//         for (char ch : prefix.toCharArray()) {
//             int index = ch - 'a';
//             if (node.children[index] == null) return false; // If path breaks, prefix not present
//             node = node.children[index];
//         }
//         return true; // All characters matched, prefix exists
//     }

//     // Main method to test the Trie functionality
//     public static void main(String[] args) {
//         Trie2 trie = new Trie2();

//         trie.insert("apple");                            // Insert "apple" into the trie
//         System.out.println(trie.search("apple"));   // true: "apple" is a full word
//         System.out.println(trie.search("app"));     // false: "app" is a prefix, not a full word yet
//         System.out.println(trie.startsWith("app")); // true: "apple" starts with "app"
//         System.out.println(trie.startsWith("aps")); // false: no word starts with "aps"
//         trie.insert("app");                            // Insert "app" as a full word
//         System.out.println(trie.search("app"));     // true: now "app" is a full word
//     }
// }
