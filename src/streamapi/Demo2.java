package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo2{
    public static void main(String[] args) {
        // Create a list of strings
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grapefruit");

        // Find the longest string using the Stream API
        Optional<String> longestString = strings.stream()
            .max((s1, s2) -> Integer.compare(s1.length(), s2.length())); // Comparator by string length

        // Print the longest string if present
        longestString.ifPresent(longest -> System.out.println("Longest String: " + longest));
    }
}
