package com.day;

//Define the functional interface
@FunctionalInterface
interface StringPredicate {
 boolean test(String s, String substring);
}

public class Demo3 {
 public static void main(String[] args) {
     // Implement the StringPredicate interface using a lambda expression
     StringPredicate containsSubstring = (s, substring) -> s.contains(substring);

     // Test with different strings and substrings
     String testString1 = "Hello, World!";
     String testString2 = "Lambda expressions in Java";

     // Checking for substrings
     System.out.println("Does '" + testString1 + "' contain 'World'? " + 
                        containsSubstring.test(testString1, "World")); // Output: true
     System.out.println("Does '" + testString1 + "' contain 'Java'? " + 
                        containsSubstring.test(testString1, "Java")); // Output: false
     System.out.println("Does '" + testString2 + "' contain 'expressions'? " + 
                        containsSubstring.test(testString2, "expressions")); // Output: true
     System.out.println("Does '" + testString2 + "' contain 'Python'? " + 
                        containsSubstring.test(testString2, "Python")); // Output: false
 }
}

