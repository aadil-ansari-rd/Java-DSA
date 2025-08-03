import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetDemo {

    public static void main(String[] args) {
        // 1. Create TreeSet
        TreeSet<String> cities = new TreeSet<>();

        // 2. add() - Add elements (sorted and no duplicates)
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");
        cities.add("Bangalore");
        cities.add("Mumbai");  // duplicate

        // 3. Print TreeSet (sorted order)
        System.out.println("Initial TreeSet: " + cities);

        // 4. contains()
        System.out.println("Contains 'Delhi'? " + cities.contains("Delhi"));
        System.out.println("Contains 'Pune'? " + cities.contains("Pune"));

        // 5. size()
        System.out.println("Size of set: " + cities.size());

        // 6. isEmpty()
        System.out.println("Is set empty? " + cities.isEmpty());

        // 7. remove()
        cities.remove("Chennai");
        System.out.println("After removing 'Chennai': " + cities);

        // 8. iterator()
        System.out.print("Using Iterator: ");
        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 9. for-each loop
        System.out.print("Using for-each: ");
        for (String city : cities) {
            System.out.print(city + " ");
        }
        System.out.println();

        // 10. first(), last()
        System.out.println("First element: " + cities.first());
        System.out.println("Last element: " + cities.last());

        // 11. ceiling(), floor(), higher(), lower()
        System.out.println("Ceiling of 'Chandigarh': " + cities.ceiling("Chandigarh"));
        System.out.println("Floor of 'Mumbai': " + cities.floor("Mumbai"));
        System.out.println("Higher than 'Delhi': " + cities.higher("Delhi"));
        System.out.println("Lower than 'Delhi': " + cities.lower("Delhi"));

        // 12. pollFirst(), pollLast()
        System.out.println("pollFirst(): " + cities.pollFirst());
        System.out.println("pollLast(): " + cities.pollLast());
        System.out.println("After polling: " + cities);

        // 13. clear()
        cities.clear();
        System.out.println("After clear(): " + cities);
        System.out.println("Is set empty now? " + cities.isEmpty());
    }
}
