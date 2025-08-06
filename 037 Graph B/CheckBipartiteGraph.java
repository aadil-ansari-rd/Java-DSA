import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class CheckBipartiteGraph {
    int vertices;
    List<List<Edge>> adj;

    public CheckBipartiteGraph(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Edge(src, dest, weight));
        adj.get(dest).add(new Edge(dest, src, weight)); // Undirected
    }

    public boolean isBipartite() {
        int[] color = new int[vertices];
        Arrays.fill(color, -1); // -1 = unvisited

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(i, color)) return false;
            }
        }
        return true;
    }

    private boolean bfsCheck(int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0; // Start with color 0

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge edge : adj.get(curr)) {
                int neighbor = edge.dest;

                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[curr]; // Alternate color
                    q.offer(neighbor);
                } else if (color[neighbor] == color[curr]) {
                    return false; // Conflict: same color
                }
            }
        }
        return true;
    }

    // 🔎 Test method
    public static void main(String[] args) {
        CheckBipartiteGraph g = new CheckBipartiteGraph(5);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 3, 3);
        g.addEdge(1, 2, 2);
        g.addEdge(3, 2, 1);
        g.addEdge(2, 4, 5);

        System.out.println("Is graph bipartite? " + g.isBipartite());
    }
}
