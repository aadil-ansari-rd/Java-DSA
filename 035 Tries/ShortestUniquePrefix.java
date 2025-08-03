import java.util.*;

class ShortestUniquePrefix {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int freq = 0; // frequency of this path
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word and update frequency
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null)
                    node.children[index] = new TrieNode();
                node = node.children[index];
                node.freq++; // increment frequency at each node
            }
        }

        // Find shortest unique prefix for a word
        public String getUniquePrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                prefix.append(ch);
                node = node.children[index];
                if (node.freq == 1)
                    break; // unique path found
            }

            return prefix.toString();
        }
    }

    public static List<String> findPrefixes(String[] words) {
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        List<String> result = new ArrayList<>();
        for (String word : words)
            result.add(trie.getUniquePrefix(word));

        return result;
    }

    // Test
    public static void main(String[] args) {
        String[] words = { "zebra", "dog", "duck", "dove" };
        List<String> res = findPrefixes(words);

        for (String prefix : res)
            System.out.println(prefix);
    }
}
