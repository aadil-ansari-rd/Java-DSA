import java.util.ArrayDeque;
import java.util.Queue;
public class InterleaveTwoHalfOfQueue{
    public static void interleave(Queue<Integer> q){
        int n = q.size();
        Queue<Integer> firstHalf = new ArrayDeque<>();
        int halfLen = n/2;
        while(halfLen>=1){
            firstHalf.offer(q.poll());
            halfLen--;
        }
        while (!firstHalf.isEmpty()) {
            q.offer(firstHalf.poll());
            q.offer(q.poll());
        }
        System.out.println(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        interleave(q);
        
    }
}