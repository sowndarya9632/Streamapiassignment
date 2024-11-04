package com.day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo4 {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig");

        // Concatenate the strings with a comma separator using a lambda expression
        String concatenatedString = strings.stream()
            .collect(Collectors.joining(", ")); // Joining with a comma and space

        // Print the concatenated result
        System.out.println("Concatenated String: " + concatenatedString);
    }
}

