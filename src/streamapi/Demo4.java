package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Demo4 {
    public static void main(String[] args) {
        // Create a list of double values
        List<Double> numbers = Arrays.asList(10.5, 20.0, 30.25, 40.75, 50.5);

        // Find the average of the double values using the Stream API
        OptionalDouble average = numbers.stream()
            .mapToDouble(Double::doubleValue) // Convert to DoubleStream
            .average(); // Calculate the average

        // Print the average if present
        average.ifPresent(avg -> System.out.println("Average: " + avg));
    }
}
