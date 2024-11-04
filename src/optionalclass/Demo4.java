package optionalclass;

import java.util.Optional;

public class Demo4 {

    // Method to multiply the value by 10 or return 0
    public static int multiplyByTen(Optional<Integer> optionalValue) {
        return optionalValue.map(n -> n * 10) // Multiply by 10 if present
                            .orElse(0); // Return 0 if not present
    }

    public static void main(String[] args) {
        // Test cases
        Optional<Integer> optionalWithValue = Optional.of(5);
        Optional<Integer> optionalEmpty = Optional.empty();

        // Get results
        int result1 = multiplyByTen(optionalWithValue);
        int result2 = multiplyByTen(optionalEmpty);

        // Print the results
        System.out.println("Result from Optional with value: " + result1); // Should print 50
        System.out.println("Result from empty Optional: " + result2); // Should print 0
    }
}

