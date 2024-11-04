package streamapi;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Demo5 {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "Engineering"),
            new Employee("Charlie", "HR"),
            new Employee("David", "Engineering"),
            new Employee("Eve", "Finance")
        );

        // Group employees by their department
        Map<String, List<Employee>> groupedByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        // Print the grouped employees
        groupedByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });
    }
}

