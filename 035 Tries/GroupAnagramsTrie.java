import java.util.*;

public class GroupAnagramsTrie {

    // Trie Node Definition
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> anagrams = new ArrayList<>();  // Store original words at leaf
    }

    TrieNode root = new TrieNode();

    // Insert a word by its sorted version into Trie
    private void insert(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        TrieNode node = root;

        for (char ch : chars) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }

        node.anagrams.add(word);  // Store original word at leaf
    }

    // DFS traversal to collect anagram groups
    private void collectAnagrams(TrieNode node, List<List<String>> result) {
        if (node == null) return;

        if (!node.anagrams.isEmpty())
            result.add(new ArrayList<>(node.anagrams));

        for (int i = 0; i < 26; i++)
            if (node.children[i] != null)
                collectAnagrams(node.children[i], result);
    }

    // Main function to group anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        for (String word : strs)
            insert(word);

        List<List<String>> result = new ArrayList<>();
        collectAnagrams(root, result);
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        GroupAnagramsTrie solution = new GroupAnagramsTrie();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> grouped = solution.groupAnagrams(input);
        for (List<String> group : grouped) {
            System.out.println(group);
        }
    }
}
