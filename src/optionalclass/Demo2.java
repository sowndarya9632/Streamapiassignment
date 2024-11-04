package optionalclass;

import java.util.Optional;

public class Demo2 {

    // Method to print the string in uppercase or "No value"
    public static void printUpperCase(Optional<String> optionalString) {
        optionalString.ifPresentOrElse(
            value -> System.out.println(value.toUpperCase()), // Print uppercase string if present
            () -> System.out.println("No value") // Print "No value" if not present
        );
    }

    public static void main(String[] args) {
        // Test cases
        Optional<String> optionalWithValue = Optional.of("hello, world!");
        Optional<String> optionalEmpty = Optional.empty();

        // Print for non-empty Optional
        System.out.print("Optional with value: ");
        printUpperCase(optionalWithValue); // Should print "HELLO, WORLD!"

        // Print for empty Optional
        System.out.print("Optional empty: ");
        printUpperCase(optionalEmpty); // Should print "No value"
    }
}
