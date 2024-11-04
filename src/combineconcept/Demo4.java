package combineconcept;

import java.util.List;
import java.util.Optional;

public class Demo4 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Optional<Integer> product = calculateOddProduct(numbers);
        product.ifPresentOrElse(
            value -> System.out.println("Product of odd numbers: " + value),
            () -> System.out.println("No odd numbers found.")
        );
    }

    public static Optional<Integer> calculateOddProduct(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0) // Filter odd numbers
                .reduce((a, b) -> a * b); // Calculate the product using reduce
    }
}
