class DisjointSet {
    int[] parent, rank;

    // Constructor: MakeSet
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Each element is its own parent
            rank[i] = 0;    // Initial rank is 0
        }
    }

    // Find with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }

    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;  // Already in the same set

        // Attach smaller rank tree under larger rank tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // Optional: check if two elements are in the same set
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

// Test the implementation
public class DisjointSetTest {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(6); // 0..5

        ds.union(0, 1);
        ds.union(2, 3);
        ds.union(1, 3);  // merge sets {0,1} and {2,3}

        System.out.println(ds.find(3));  // Output: 0 (representative)
        System.out.println(ds.isConnected(0, 3)); // true
        System.out.println(ds.isConnected(4, 5)); // false
    }
}
