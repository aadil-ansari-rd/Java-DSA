import java.util.*;

public class CouseSchedule {

    // DFS to detect cycle
    private static boolean hasCycle(int task, List<List<Integer>> graph, int[] visited) {
        visited[task] = 1; // visiting

        for (int neighbor : graph.get(task)) {
            if (visited[neighbor] == 1) return true; // cycle detected
            if (visited[neighbor] == 0 && hasCycle(neighbor, graph, visited)) return true;
        }

        visited[task] = 2; // visited completely
        return false;
    }

    // Function to check if all tasks can be finished
    public static boolean canFinishTasks(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Build graph
        for (int[] pre : prerequisites) {
            int task = pre[0];
            int preTask = pre[1];
            graph.get(preTask).add(task);
        }

        int[] visited = new int[n]; // 0=unvisited,1=visiting,2=visited

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (hasCycle(i, graph, visited)) return false;
            }
        }

        return true; // no cycle detected
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 4;
        int[][] prerequisites = {
            {1,0}, {2,1}, {3,2}
        };

        boolean result = canFinishTasks(n, prerequisites);
        System.out.println("Is it possible to finish all tasks? " + result);
    }
}
