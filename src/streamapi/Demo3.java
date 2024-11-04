package streamapi;

import java.util.Arrays;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        // Create a list of names
        List<String> names = Arrays.asList("James", "John", "Alice", "Jack", "Jill", "Bob", "Jessica");

        // Count the number of names starting with "J" using the Stream API
        long count = names.stream()
            .filter(name -> name.startsWith("J")) // Filter names starting with "J"
            .count(); // Count the filtered names

        // Print the count
        System.out.println("Number of names starting with 'J': " + count);
    }
}

