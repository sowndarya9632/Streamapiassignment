package com.day;

//Define the functional interface
@FunctionalInterface
interface IntOperation {
 int apply(int x, int y);
}

public  class Demo1 {
 public static void main(String[] args) {
     // Implement the IntOperation interface using lambda expressions

     // Addition
     IntOperation add = (x, y) -> x + y;
     System.out.println("Addition: " + add.apply(5, 3)); // Output: 8

     // Subtraction
     IntOperation subtract = (x, y) -> x - y;
     System.out.println("Subtraction: " + subtract.apply(5, 3)); // Output: 2

     // Multiplication
     IntOperation multiply = (x, y) -> x * y;
     System.out.println("Multiplication: " + multiply.apply(5, 3)); // Output: 15

     // Division
     IntOperation divide = (x, y) -> {
         if (y == 0) {
             throw new ArithmeticException("Division by zero is not allowed");
         }
         return x / y;
     };
     System.out.println("Division: " + divide.apply(6, 3)); // Output: 2

     // Testing division by zero
     try {
         System.out.println("Division by zero: " + divide.apply(5, 0));
     } catch (ArithmeticException e) {
         System.out.println(e.getMessage()); // Output: Division by zero is not allowed
     }
 }
}
