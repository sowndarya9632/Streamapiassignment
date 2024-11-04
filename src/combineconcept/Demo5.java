package combineconcept;

import java.util.Optional;

public class Demo5{

    public static void main(String[] args) {
        String name1 = "Alice";
        String name2 = null;

        System.out.println(createGreeting(name1)); // Outputs: Hello, Alice!
        System.out.println(createGreeting(name2)); // Outputs: Hello, Guest!
    }

    public static String createGreeting(String name) {
        // Use Optional to provide a default greeting
        String finalName = Optional.ofNullable(name).orElse("Guest");
        return "Hello, " + finalName + "!";
    }
}
