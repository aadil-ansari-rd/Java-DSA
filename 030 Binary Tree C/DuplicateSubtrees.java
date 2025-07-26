// ✅ Java program to find all duplicate subtrees
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class DuplicateSubtrees {
    static Map<String, Integer> map = new HashMap<>();
    static List<Node> result = new ArrayList<>();

    // Function to serialize the tree and detect duplicates
    public static String serialize(Node root) {
        if (root == null) return "#";  // Null represented by '#'
        
        // Postorder serialization
        String serial = root.data + "," + serialize(root.left) + "," + serialize(root.right);
        
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        
        // If count becomes 2, add to result
        if (map.get(serial) == 2) result.add(root);
        
        return serial;
    }

    public static List<Node> findDuplicateSubtrees(Node root) {
        map.clear();
        result.clear();
        serialize(root);
        return result;
    }

    // Function to print inorder traversal of a subtree
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);

        List<Node> duplicates = findDuplicateSubtrees(root);

        System.out.println("Duplicate Subtrees Inorder Traversal:");
        for (Node node : duplicates) {
            inorder(node);
            System.out.println();
        }
    }
}
