package com.day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2{
    public static void main(String[] args) {
        // Create a list of strings, including some empty strings
        List<String> strings = Arrays.asList("apple", "", "banana", "cherry", "", "date", "fig", "grape", "");

        // Filter the list to include only non-empty strings
        List<String> nonEmptyStrings = strings.stream()
            .filter(s -> !s.isEmpty()) // Filter to keep only non-empty strings
            .collect(Collectors.toList());

        // Print the filtered list
        System.out.println("Non-empty Strings: " + nonEmptyStrings);
    }
}
