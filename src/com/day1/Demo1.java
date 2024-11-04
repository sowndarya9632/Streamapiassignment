package com.day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2, 7, 4, 6);

        // Sort the list in descending order using lambda expressions
        List<Integer> sortedNumbers = numbers.stream()
            .sorted((a, b) -> b.compareTo(a)) // Comparator for descending order
            .collect(Collectors.toList());

        // Print the sorted list
        System.out.println("Sorted List in Descending Order: " + sortedNumbers);
    }
}
