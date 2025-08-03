import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class HasPathDFS {
    int vertices;
    List<List<Edge>> adjList;

    public HasPathDFS(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(src, dest, weight));
        adjList.get(dest).add(new Edge(dest, src, weight)); // undirected
    }

    public boolean hasPath(int src, int dest) {
        boolean[] visited = new boolean[vertices];
        return dfs(src, dest, visited);
    }

    private boolean dfs(int current, int dest, boolean[] visited) {
        if (current == dest) return true;

        visited[current] = true;

        for (Edge edge : adjList.get(current)) {
            int neighbor = edge.dest;
            if (!visited[neighbor]) {
                if (dfs(neighbor, dest, visited)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
    /*          4
            0-------1
            | \     |
           5|  \2   |1
            |    \  |
            2-------3
                3
    */
        HasPathDFS graph = new HasPathDFS(4);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 3);

        int src = 0, dest = 3;
        System.out.println("Has Path from " + src + " to " + dest + ": " + graph.hasPath(src, dest)); // true
    }
}
