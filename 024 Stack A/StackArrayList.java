import java.util.*;

class Stack {
    ArrayList<Integer> stack = new ArrayList<>();

    // IsEmpty()
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    // push()
    public void push(int data) {
        stack.add(data);
    }

    // pop()
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is underflow");
            return -1;
        }
        return stack.remove(stack.size() - 1);
    }

    // peek()
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack.get(stack.size() - 1);
    }

}

public class StackArrayList {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(12);
        s.push(16);
        s.push(23);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());

    }

}