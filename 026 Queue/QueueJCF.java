import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueJCF {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        //Is Empty
        System.out.println("Q1 : isEmpty() : " + q1.isEmpty());
        System.out.println("Q2 : isEmpty() : " + q2.isEmpty());

        // Enqueue
        System.out.println("Enqueue --------------------------------");
        System.out.println("By add() : Unsafe ");
        q1.add(11);
        q1.add(12);
        q1.add(13);
        q2.add(11);
        q2.add(12);
        q2.add(13);
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);

        System.out.println("By offer() : Safe");
        q1.offer(14);
        q1.offer(15);
        q1.offer(16);
        q2.offer(14);
        q2.offer(15);
        q2.offer(16);
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);

        System.out.println("Dequeue --------------------------------");
        System.out.println("By remove() : Unsafe");
        q1.remove();
        q2.remove();
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);
        System.out.println("By poll() : Safe");
        q1.poll();
        q2.poll();
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);

        //Is Empty
        System.out.println("Q1 : isEmpty() : " + q1.isEmpty());
        System.out.println("Q2 : isEmpty() : " + q2.isEmpty());

        //Clear All
        System.out.println("Clear All --------------------------------");

        q1.clear();
        q2.clear();
        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);

        //Is Empty
        System.out.println("Q1 : isEmpty() : " + q1.isEmpty());
        System.out.println("Q2 : isEmpty() : " + q2.isEmpty());
    }
}
