import java.util.*;

// 🎓 Class to compute the course completion order using Topological Sort (BFS)
public class CourseScheduleOrder2 {

    // 📘 Main logic to find course order using Kahn's Algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses]; // 🧮 Count of incoming edges

        // 🛠️ Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 🔗 Build graph and in-degree array from prerequisites
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.get(pre).add(course); // Directed edge: pre → course
            inDegree[course]++;
        }

        // 🌟 Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        // ⏩ Add courses with no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 🔁 Perform BFS and build the course order
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);

            // Decrease in-degree of all dependent courses
            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // ✅ All courses completed
        if (order.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = order.get(i);
            }
            return result;
        }

        // ❌ Cycle detected – no valid ordering
        return new int[0];
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        CourseScheduleOrder2 scheduler = new CourseScheduleOrder2();

        int numCourses = 4;
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int[] courseOrder = scheduler.findOrder(numCourses, prerequisites);

        // 📤 Output the course order
        if (courseOrder.length == 0) {
            System.out.println("No valid course order exists (cycle detected).");
        } else {
            System.out.print("Valid course order: ");
            for (int course : courseOrder) {
                System.out.print(course + " ");
            }
        }
    }
}
