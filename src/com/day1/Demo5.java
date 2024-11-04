package com.day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo5 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Map the list of integers to their squares using a lambda expression
        List<Integer> squares = numbers.stream()
            .map(n -> n * n) // Mapping each integer to its square
            .collect(Collectors.toList());

        // Print the list of squares
        System.out.println("Squares: " + squares);
    }
}
