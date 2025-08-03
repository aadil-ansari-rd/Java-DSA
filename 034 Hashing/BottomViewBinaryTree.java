import java.util.*;

// Tree Node
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class BottomViewBinaryTree {

    // Pair to hold node and its horizontal distance
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> bottomView(Node root) {
        if (root == null) return new ArrayList<>();

        // Map to store bottom view: horizontal distance -> node value
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS: stores nodes with their horizontal distances
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            Node node = current.node;
            int hd = current.hd;

            // Overwrite the value at every horizontal distance
            map.put(hd, node.data);

            // Enqueue left and right children with updated hd
            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // Collect results from map
        List<Integer> result = new ArrayList<>();
        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        /*
               1
             /   \
            2     3
             \   / \
              5 6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> bottomView = bottomView(root);
        System.out.println("Bottom View: " + bottomView);
    }
}
