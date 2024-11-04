package com.day;

@FunctionalInterface
interface MathOperation {
    double calculate(double a, double b);
}

public class Demo5 {

	public static void main(String[] args) {
		 // Modulus operation
        MathOperation modulus = (a, b) -> a % b;

        // Power operation
        MathOperation power = (a, b) -> Math.pow(a, b);

        // Test the implementations
        double num1 = 10;
        double num2 = 3;

        System.out.println("Modulus of " + num1 + " and " + num2 + ": " + modulus.calculate(num1, num2)); // Output: 1.0
        System.out.println("Power of " + num1 + " raised to " + num2 + ": " + power.calculate(num1, num2)); // Output: 1000.0
	}

}
