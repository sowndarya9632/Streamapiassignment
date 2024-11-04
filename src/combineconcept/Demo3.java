package combineconcept;

import java.util.List;
import java.util.stream.Collectors;

public class Demo3 {

    public static void main(String[] args) {
        List<String> strings = List.of("hello", "world", "functional", "programming", "Java", "streams", "API");

        List<String> longStrings = filterLongStrings(strings);
        System.out.println("Strings with length greater than 5: " + longStrings);
    }

    public static List<String> filterLongStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() > 5) // Filter strings with length greater than 5
                .collect(Collectors.toList()); // Collect the results into a list
    }
}
