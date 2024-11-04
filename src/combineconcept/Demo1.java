package combineconcept;

import java.util.List;
import java.util.OptionalDouble;

public class Demo1 {

    public static void main(String[] args) {
        List<Double> salaries = List.of(50000.0, 60000.0, 55000.0, 70000.0);
        // List<Double> salaries = List.of(); // Uncomment to test with an empty list

        double averageSalary = calculateAverageSalary(salaries);
        System.out.println("Average Salary: " + averageSalary);
    }

    public static double calculateAverageSalary(List<Double> salaries) {
        OptionalDouble average = salaries.stream()
                .filter(salary -> salary != null && salary >= 10000000) // Filter valid salaries
                .mapToDouble(Double::doubleValue) // Convert to DoubleStream
                .average(); // Calculate average

        // Handle the OptionalDouble result
        return average.orElse(0.0); // Return 0.0 if no average is found (e.g., empty list)
    }
}
