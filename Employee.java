package based_on_oop;

public class Employee {
	 int id;
	    String name;
	    String department;
	    int salary;

	    public Employee(int id,String name,String department,int salary) {
	        this.id=id;
	        this.name = name;
	        this.department=department;
	        this.salary=salary;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public int getSalary() {
	        return salary;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setDepartment(String department) {
	        this.department = department;
	    }

	    public void setSalary(int salary) {
	        this.salary = salary;
	    }

	    @Override
	    public String toString() {
	        return "Employee{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", department='" + department + '\'' +
	                ", salary=" + salary +
	                '}';
	    }

}
