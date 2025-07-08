class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node head;

    // IsEmpty()
    public boolean isEmpty() {
        return head==null;
    }

    // push()
    public void push(int data) {
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // pop()
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is underflow");
            return -1;
        }
        int val = head.data;
        head= head.next;
        return val;
    }

    // peek()
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

}

public class StackLinkedList {
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