import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetDemo {

    public static void main(String[] args) {
        // 1. Create LinkedHashSet
        LinkedHashSet<String> fruits = new LinkedHashSet<>();

        // 2. add() - Add elements (duplicates are ignored)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Apple");  // duplicate

        // 3. Print the LinkedHashSet (maintains insertion order)
        System.out.println("Initial LinkedHashSet: " + fruits);

        // 4. contains()
        System.out.println("Contains 'Mango'? " + fruits.contains("Mango"));
        System.out.println("Contains 'Pineapple'? " + fruits.contains("Pineapple"));

        // 5. size()
        System.out.println("Size of set: " + fruits.size());

        // 6. isEmpty()
        System.out.println("Is set empty? " + fruits.isEmpty());

        // 7. remove()
        fruits.remove("Orange");
        System.out.println("After removing 'Orange': " + fruits);

        // 8. iterator()
        System.out.print("Iterating using Iterator: ");
        Iterator<String> itr = fruits.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // 9. for-each loop
        System.out.print("Iterating using for-each: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 10. clear()
        fruits.clear();
        System.out.println("After clear(): " + fruits);

        // 11. isEmpty() again
        System.out.println("Is set empty now? " + fruits.isEmpty());
    }
}
