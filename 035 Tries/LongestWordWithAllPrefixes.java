public class LongestWordWithAllPrefixes {

    // Trie Node definition
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();  // Root of Trie
    String result = "";              // Stores the final answer

    // Inserts a word into the Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    // DFS to find longest word with all prefixes
    private void dfs(TrieNode node, StringBuilder path) {
        if (node == null) return;

        // Stop if not root and node is not the end of a valid word
        if (node != root && !node.isEnd)
            return;

        // Update result if current path is longer or lex smaller
        if (path.length() > result.length() ||
           (path.length() == result.length() && path.toString().compareTo(result) < 0)) {
            result = path.toString();
        }

        // Explore all children from a to z
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                path.append((char)(i + 'a'));         // Add current char
                dfs(node.children[i], path);          // Recursive DFS
                path.deleteCharAt(path.length() - 1); // Backtrack
            }
        }
    }

    public String longestWord(String[] words) {
        for (String word : words)
            insert(word);  // Insert all words into Trie

        dfs(root, new StringBuilder());  // Start DFS from root
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        LongestWordWithAllPrefixes solution = new LongestWordWithAllPrefixes();

        String[] words = {"w", "wo", "wor", "worl", "world", "banana", "ban", "bana", "banan"};
        String longest = solution.longestWord(words);

        System.out.println("Longest word with all prefixes present: " + longest);
    }
}
