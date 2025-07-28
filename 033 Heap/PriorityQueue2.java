import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueue2{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(2);
        pq.offer(1);
        pq.offer(0);
        pq.offer(4);
        pq.offer(3);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}