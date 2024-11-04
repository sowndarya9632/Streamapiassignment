package optionalclass;

import java.util.Optional;

public class Demo3 {

    // Method to return the value of Optional or a default value
    public static double getValueOrDefault(Optional<Double> optionalValue) {
        return optionalValue.orElse(100.0); // Return the value if present, otherwise return 100.0
    }

    public static void main(String[] args) {
        // Test cases
        Optional<Double> optionalWithValue = Optional.of(45.5);
        Optional<Double> optionalEmpty = Optional.empty();

        // Get values
        double value1 = getValueOrDefault(optionalWithValue);
        double value2 = getValueOrDefault(optionalEmpty);

        // Print the results
        System.out.println("Value from Optional with value: " + value1); // Should print 45.5
        System.out.println("Value from empty Optional: " + value2); // Should print 100.0
    }
}

