import java.util.*;

// Build an adjacency list for your fixed weighted, disconnected graph, 
// storing (src, dest, weight) triplets for each edge
// Edge with source, destination, and weight
class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class NewWeightedGraph {
    int vertices;
    List<List<Edge>> adjList;

    public NewWeightedGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        // Initialize empty list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    public void addEdge(int src, int dest, int weight) {
        Edge e1 = new Edge(src, dest, weight); // src → dest
        Edge e2 = new Edge(dest, src, weight); // dest → src (undirected)

        adjList.get(src).add(e1);
        adjList.get(dest).add(e2);
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("-> (src=" + edge.src + ", dest=" + edge.dest + ", w=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // // BFS Traversal
    // public void bfs(int start) {
    // boolean[] visited = new boolean[vertices];
    // System.out.print("BFS Traversal : ");

    // for (List<Edge> ed : adjList) {
    // for (Edge ver : ed) {
    // if (!visited[ver.src]) {
    // bfsUtil(ver.src, visited);
    // }
    // }
    // }
    // }

    // public void bfsUtil(int start, boolean[] visited) {
    // Queue<Integer> q = new LinkedList<>();
    // visited[start] = true;
    // q.offer(start);
    // while (!q.isEmpty()) {
    // int curr = q.poll();
    // System.out.print(curr + " ");
    // for (Edge ed : adjList.get(curr)) {
    // int neighbor = ed.dest;
    // if (!visited[neighbor]) {
    // q.offer(neighbor);
    // visited[neighbor] = true;
    // }
    // }
    // }
    // }

    // 🔍 Performs BFS on all disconnected components
    public void bfsTraversal() {
        boolean[] visited = new boolean[vertices];
        System.out.print("BFS Traversal: ");

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                bfsFromVertex(i, visited);
            }
        }
    }

    // 🔄 BFS from a single source vertex
    private void bfsFromVertex(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (Edge edge : adjList.get(curr)) {
                int neighbor = edge.dest;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // // DFS Traversal
    // public void dfsTraversal() {
    // boolean[] visited = new boolean[vertices];
    // System.out.print("BFS Traversal: ");

    // for (int i = 0; i < vertices; i++) {
    // if (!visited[i]) {
    // dfsUtil(i, visited);
    // }
    // }
    // }
    // public void dfsUtil(int curr, boolean[] visited) {
    // visited[curr] = true;
    // System.out.print(curr + " ");

    // for (Edge ed : adjList.get(curr)) {
    // int neighbor = ed.dest;
    // if (!visited[neighbor]) {
    // dfsUtil(neighbor, visited);
    // }
    // }
    // }

    // 🔍 Performs DFS on all disconnected components
    public void dfsTraversal() {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfsFromVertex(i, visited);
            }
        }
    }

    // 🔄 DFS from a single source vertex
    private void dfsFromVertex(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (Edge edge : adjList.get(curr)) {
            int neighbor = edge.dest;
            if (!visited[neighbor]) {
                dfsFromVertex(neighbor, visited);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        // ............................................................
        // ...Component-1.........Component-2...........Component-3....
        // ............................................................
        // ............................2...............................
        // ...0...................3_________4...............7..........
        // ...|...................|..\......|............../.\.........
        // ..4|..................1|....\6...|3...........9/...\8.......
        // ...|...................|......\..|............/.....\.......
        // ...1________2..........6_________5...........9_______8......
        // ........7...................5....................2..........
        // ............................................................
        int[][] edges = {
                { 0, 1, 4 },
                { 1, 2, 7 },

                { 3, 4, 2 },
                { 3, 6, 1 },
                { 4, 5, 3 },
                { 5, 6, 5 },
                { 3, 5, 6 }, // Diagonal

                { 7, 8, 8 },
                { 8, 9, 2 },
                { 9, 7, 9 }
        };

        // Find the maximum vertex index to know number of vertices
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }

        NewWeightedGraph graph = new NewWeightedGraph(maxVertex + 1);

        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
        }

        // graph.printGraph();
        graph.bfsTraversal();
        System.out.println();
        graph.dfsTraversal();
    }
}