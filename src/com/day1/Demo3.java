package com.day1;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo3 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2, 7, 4, 6);

        // Find the maximum value in the list using a lambda expression
        Optional<Integer> maxNumber = numbers.stream()
            .max(Integer::compareTo); // Using method reference to compare integers

        // Print the maximum value if present
        maxNumber.ifPresent(max -> System.out.println("Maximum value: " + max));
    }
}

