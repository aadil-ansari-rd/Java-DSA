import java.util.PriorityQueue;

public class PriorityQueue4 {
    static class Student  {
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        String  print(){
            return this.name + " : " + this.rank; 
        }
    }

    public static void normalorder (){
        PriorityQueue<Student> pq = new PriorityQueue<>((a,b)-> a.rank-b.rank);
        pq.add(new Student("Aadil", 2));
        pq.add(new Student("Afjal", 3));
        pq.add(new Student("Anaya", 1));
        System.out.println("Normal Order");
        while(!pq.isEmpty()){
            System.out.println(pq.poll().print());
        }
    }
    public static void reverseOrder (){
        PriorityQueue<Student> pq = new PriorityQueue<>((a,b)-> b.rank-a.rank);
        pq.add(new Student("Aadil", 2));
        pq.add(new Student("Afjal", 3));
        pq.add(new Student("Anaya", 1));
        System.out.println("Reverse Order");
        while(!pq.isEmpty()){
            System.out.println(pq.poll().print());
        }
    }
    public static void main(String[] args) {
        normalorder();
        reverseOrder();
    }
}
