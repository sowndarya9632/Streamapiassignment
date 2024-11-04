package optionalclass;

import java.util.Optional;

public class Demo1 {

    // Method to return an Optional<String>
    public static Optional<String> getOptionalString(String input) {
        return Optional.ofNullable(input); // Wraps the string in an Optional
    }

    public static void main(String[] args) {
        // Test cases
        String nonNullString = "Hello, World!";
        String nullString = null;

        // Get Optional for non-null string
        Optional<String> optional1 = getOptionalString(nonNullString);
        System.out.println("Optional for non-null string: " + optional1); // Should print the value

        // Get Optional for null string
        Optional<String> optional2 = getOptionalString(nullString);
        System.out.println("Optional for null string: " + optional2); // Should print Optional.empty
    }
}

