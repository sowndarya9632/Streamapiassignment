package optionalclass;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo5 {

    public static List<String> filterNonEmptyStrings(Optional<List<String>> optionalList) {
        return optionalList
                .stream() // Create a stream from the Optional
                .flatMap(List::stream) // Flatten the list into a stream of strings
                .filter(s -> !s.isEmpty()) // Filter out empty strings
                .collect(Collectors.toList()); // Collect the results into a List
    }

    public static void main(String[] args) {
        Optional<List<String>> optionalStrings = Optional.of(List.of("apple", "", "banana", " ", "cherry"));
        List<String> filteredList = filterNonEmptyStrings(optionalStrings);
        System.out.println(filteredList); // Output: [apple, banana,  , cherry]
    }
}
