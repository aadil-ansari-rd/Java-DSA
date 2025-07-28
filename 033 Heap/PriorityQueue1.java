import java.util.PriorityQueue;
public class PriorityQueue1{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(4);
        pq.offer(3);
        pq.offer(2);
        pq.offer(1);
        pq.offer(0);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}