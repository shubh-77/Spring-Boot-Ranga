package com.in28minutes.fp.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeRunner {
public static void main(String[] args) {
	
	
	List<Employee> empList = List.of(new Employee(1, "A", "Sales", 20000, 25, "M"),
									new Employee(2, "B", "Marketing", 10000, 22, "F"),
									new Employee(3, "C1", "Dev", 60000, 26, "M"),
									new Employee(4, "C1", "Dev", 50000, 26, "M"),
									new Employee(5, "D", "QA", 80000, 26, "M")
			
			);

	
	System.out.println("1. Find employees whose salary is greater than 50,000");
     List<Employee> list1 =	empList.stream().filter(e->e.getSalary()>50000).collect(Collectors.toList());
	System.out.println(list1);
	
	System.out.println("2. Print only employee names");
	empList.stream().map(e->e.getName()).forEach(System.out::println);
	
	
	System.out.println("3. Sort employees by salary ascending");
	empList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
	
	System.out.println("4. Find the highest-paid employee");
	Employee highPaidEmpl = empList.stream().max(Comparator.comparing(Employee::getSalary)).orElse(new Employee());
	System.out.println(highPaidEmpl);
	
	System.out.println("5. Find the second highest salary");
	Employee secondHighest = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElse(new Employee());
	System.out.println(secondHighest);
	
	System.out.println("6. Group employees by department");
	Map<String, List<Employee>> collect = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	
	System.out.println("7. Count employees in each department");
	Map<String, Long> collect2 = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	System.out.println(collect2);
	
	System.out.println("8. Find average salary department-wise");
	Map<String, Double> collect3 = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
	System.out.println(collect3);
	
	System.out.println("9. Find highest-paid employee in each department");
	
	Map<String, Optional<Employee>> collect4 = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
	System.out.println(collect4);
	
	
	System.out.println("10. Convert List<Employee> to Map<id, Employee>");
	
	Map<Integer, Employee> collect5 = empList.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
	System.out.println(collect5);
	
	
	System.out.println("11. Remove duplicate employee names");
	empList.stream().map(e->e.getName()).distinct().forEach(System.out::println);
	
	System.out.println("12. Check if any employee earns more than 100000");
	boolean anyMatch = empList.stream().anyMatch(e->e.getSalary()>100000);
	System.out.println(anyMatch);
	
	
	
	
	
	System.out.println("13. Partition employees by salary > 50000");
	Map<Boolean, List<Employee>> collect6 = empList.stream().collect(Collectors.partitioningBy(e->e.getSalary()>50000));
	System.out.println(collect6);
	
	System.out.println("14. Find all distinct departments");
	empList.stream().map(e->e.getDepartment()).distinct().forEach(System.out::println);
	
	System.out.println("15. Join all employee names");
	String collect7 = empList.stream().map(Employee::getName).collect(Collectors.joining(", "));
	System.out.println(collect7);
	
	
	
}
}
