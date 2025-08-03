import java.util.HashSet;
import java.util.Iterator;

public class HashSetIterationDemo {
    public static void main(String[] args) {

        // Creating HashSet and adding elements
        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("HashSet: " + fruits);

        // 1. Iteration using for-each loop
        System.out.println("\nIterating using for-each loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 2. Iteration using Iterator
        System.out.println("\nIterating using Iterator:");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 3. Iteration using forEach method (lambda)
        System.out.println("\nIterating using forEach (lambda):");
        fruits.forEach(fruit -> System.out.println(fruit));

        // 4. Iteration using stream API
        System.out.println("\nIterating using stream():");
        fruits.stream().forEach(System.out::println);
    }
}
