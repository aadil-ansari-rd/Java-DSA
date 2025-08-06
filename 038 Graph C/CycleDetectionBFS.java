import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class CycleDetectionBFS {
    public static void main(String[] args) {
        int V = 5;
        List<Edge>[] graph = createGraph(V);

        if (hasCycle(graph, V)) {
            System.out.println("Cycle exists");
        } else {
            System.out.println("No cycle");
        }
    }

    // Graph builder
    public static List<Edge>[] createGraph(int V) {
        List<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList<>();

        // Add undirected edges
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));

        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));

        graph[4].add(new Edge(4, 1, 1)); // creates cycle
        graph[1].add(new Edge(1, 4, 1));

        return graph;
    }

    // BFS-based cycle detection
    public static boolean hasCycle(List<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsDetect(graph, i, visited))
                    return true;
            }
        }
        return false;
    }

    static class Pair {
        int node;
        int parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private static boolean bfsDetect(List<Edge>[] graph, int start, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (Edge e : graph[curr.node]) {
                int neighbor = e.dest;

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new Pair(neighbor, curr.node));
                } else if (neighbor != curr.parent) {
                    // If neighbor is visited and not parent, then cycle
                    return true;
                }
            }
        }
        return false;
    }
}
