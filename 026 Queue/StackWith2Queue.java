import java.util.ArrayDeque;
import java.util.Queue;



// 1. Costly Push (Efficient Pop) -----------------------------------------------------------------------------
// push(x):
// Push new element into empty queue q2
// Move all elements from q1 to q2
// Swap q1 and q2
//pop()/peek(): Directly from front of q1

class StackUsingTwoQueues_CostlyPush {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Push operation – O(n)
    public void push(int val) {
        // Step 1: Push to q2
        q2.offer(val);

        // Step 2: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation – O(1)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.poll();
    }

    // Peek operation – O(1)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    // Display stack (top to bottom)
    public void display() {
        System.out.println(q1);
    }
}

// 2. Costly Pop (Efficient Push)-----------------------------------------------------------------------------
// push(x): Simply offer to q1
// pop():
// Move all but last from q1 to q2
// Remove last (top of stack)
// Swap q1 and q2
class StackUsingTwoQueues_CostlyPop {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Push operation – O(1)
    public void push(int val) {
        q1.offer(val);
    }

    // Pop operation – O(n)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Move all except last element to q2
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        // Last element is the top of stack
        int top = q1.poll();

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Peek operation – O(n)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Move all except last element to q2
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        // Last element is the top of stack
        int top = q1.poll();
        q2.offer(top); // put it back

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Display stack from top to bottom (logical order)
    public void display() {
        System.out.println(q1); // Order will be bottom to top, as it’s a queue
    }
}


public class StackWith2Queue {
    public static void main(String[] args) {

        System.out.println("------ Testing StackUsingTwoQueues_CostlyPush ------");
        StackUsingTwoQueues_CostlyPush stack1 = new StackUsingTwoQueues_CostlyPush();

        System.out.println("Is Empty? " + stack1.isEmpty()); // true

        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.display(); // [30, 20, 10] ← 30 is top

        System.out.println("Peek: " + stack1.peek()); // 30
        System.out.println("Pop: " + stack1.pop());   // 30
        stack1.display();                             // [20, 10]

        stack1.push(40);
        stack1.display();                             // [40, 20, 10]

        System.out.println("Pop: " + stack1.pop());   // 40
        System.out.println("Pop: " + stack1.pop());   // 20
        System.out.println("Pop: " + stack1.pop());   // 10
        System.out.println("Pop: " + stack1.pop());   // Stack is empty → -1

        System.out.println("Is Empty? " + stack1.isEmpty()); // true

        System.out.println("\n------ Testing StackUsingTwoQueues_CostlyPop ------");
        StackUsingTwoQueues_CostlyPop stack2 = new StackUsingTwoQueues_CostlyPop();

        System.out.println("Is Empty? " + stack2.isEmpty()); // true

        stack2.push(100);
        stack2.push(200);
        stack2.push(300);
        stack2.display(); // [100, 200, 300] ← 300 is top

        System.out.println("Peek: " + stack2.peek()); // 300
        System.out.println("Pop: " + stack2.pop());   // 300
        stack2.display();                             // [100, 200]

        stack2.push(400);
        stack2.display();                             // [100, 200, 400]

        System.out.println("Pop: " + stack2.pop());   // 400
        System.out.println("Pop: " + stack2.pop());   // 200
        System.out.println("Pop: " + stack2.pop());   // 100
        System.out.println("Pop: " + stack2.pop());   // Stack is empty → -1

        System.out.println("Is Empty? " + stack2.isEmpty()); // true
    }
}

