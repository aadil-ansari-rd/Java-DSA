public class WordBreak {
    class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
    }

    private final Node root;

    public WordBreak() {
        root = new Node();
    }

    // Insert a word into Trie
    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Search a word in Trie
    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.isEndOfWord == true ? true : false;
    }

    //Word Break Problem
    public boolean wordBreak(String key) {
        if (key.length() == 0)
            return true;
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak trie = new WordBreak();

        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }
        String key = "ilikesam";
        System.out.println(trie.wordBreak(key));
    }
}
