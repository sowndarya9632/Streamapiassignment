package streamapi;

import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Find the sum of all even numbers using the Stream API
        int sumOfEvens = numbers.stream()
            .filter(n -> n % 2 == 0) // Filter even numbers
            .mapToInt(Integer::intValue) // Convert to IntStream
            .sum(); // Sum the even numbers

        // Print the sum of even numbers
        System.out.println("Sum of Even Numbers: " + sumOfEvens);
    }
}
