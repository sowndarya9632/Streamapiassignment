package com.day;
@FunctionalInterface
interface Transform{
	String transform(String input);
}
public class Demo4{
	public static void main(String[] args) {
	Transform t1	=input->input.toLowerCase();
	Transform t2	=input->input.toLowerCase();
	Transform t3 = input -> {
        String[] words = input.split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1).toLowerCase())
                         .append(" ");
            }
        }
        return titleCase.toString(); // Remove trailing space
    };

    // Test with different strings
    String testString = "hello world! this is a Java program.";

    System.out.println("Original: " + testString);
    System.out.println("Lowercase: " + t1.transform(testString)); // Output: hello world! this is a java program.
    System.out.println("Uppercase: " + t2.transform(testString)); // Output: HELLO WORLD! THIS IS A JAVA PROGRAM.
    System.out.println("Title Case: " +t3.transform(testString)); // Output: Hello World! This Is A Java Program.
	}
}
