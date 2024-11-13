package based_on_oop;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {
	  public static List<Employee> filterByDept(List<Employee> employee)
	    {
	        return employee.stream().filter(e ->"Engineering".equals(e.getDepartment()) && e.getSalary() > 80000).collect(Collectors.toList());
	    }
	    public static List<Employee> sortBySalary(List<Employee> employees)
	    {
	        return employees.stream().sorted((x,y) -> Integer.compare(y.getSalary(),x.getSalary())).collect(Collectors.toList());
	    }
	    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees)
	    {
	        return employees.stream().collect(Collectors.groupingBy(Employee :: getDepartment));
	    }
	    public static Double avgSalary(List<Employee> employees)
	    {
	        return employees.stream().collect(Collectors.averagingInt(Employee ::getSalary));
	    }

	    public static void main(String[] args) {
	        List<Employee> list= Arrays.asList(new Employee(101,"Anusha","Engineering",80000),
	                                            new Employee(102,"Bhanu","Engineering",90000),
	                                            new Employee(103,"Bob","Electrical",90000),
	                                            new Employee(104,"Janu","Mechanical",90000));
	        System.out.println("Sorted By department and salary greater than 80000");
	        List<Employee> result=filterByDept(list);
	        System.out.println(result);
	        System.out.println();
	        List<Employee> sortedResult = sortBySalary(list);
	        System.out.println("Sorted by Salary in Descending Order:");
	        sortedResult.forEach(System.out::println);
	        System.out.println();
	        System.out.println("Group the Employees by their Department");
	        Map<String, List<Employee>> groupedResult =groupByDepartment(list);
	        groupedResult.forEach((department , employees) -> System.out.println(department +" : "+employees));
	        System.out.println();
	        Double avgSalary=avgSalary(list);
	        System.out.println("Average Salary is "+avgSalary);
	    }
}
