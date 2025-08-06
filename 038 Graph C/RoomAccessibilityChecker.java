import java.util.*;

public class RoomAccessibilityChecker {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(0, rooms, visited);

        for (boolean roomVisited : visited) {
            if (!roomVisited) return false;
        }
        return true;
    }

    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited) {
        for (int neighborRoom : rooms.get(currentRoom)) {
            if (!visited[neighborRoom]) {
                visited[neighborRoom] = true;
                dfs(neighborRoom, rooms, visited);
            }
        }
    }

    public static void main(String[] args) {
        RoomAccessibilityChecker checker = new RoomAccessibilityChecker();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());

        boolean result = checker.canVisitAllRooms(rooms);
        System.out.println("Can visit all rooms: " + result); // Output: true
    }
}
