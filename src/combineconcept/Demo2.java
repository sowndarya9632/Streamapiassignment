package combineconcept;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Demo2 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 15, 20, 33, 45, 67, 80, 99);
        // List<Integer> numbers = List.of(); // Uncomment to test with an empty list

        Optional<Integer> highest = findHighestDivisibleByFive(numbers);
        highest.ifPresentOrElse(
            num -> System.out.println("Highest number divisible by 5: " + num),
            () -> System.out.println("No number divisible by 5 found.")
        );
    }

    public static Optional<Integer> findHighestDivisibleByFive(List<Integer> numbers) {
        // Functional interface for divisibility check
        Predicate<Integer> isDivisibleByFive = num -> num % 5 == 0;

        // Use streams to filter and find the maximum
        return numbers.stream()
                .filter(isDivisibleByFive) // Filter numbers divisible by 5
                .max(Integer::compareTo); // Find the maximum
    }
}
