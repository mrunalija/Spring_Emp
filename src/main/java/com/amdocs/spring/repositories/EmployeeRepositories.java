package com.amdocs.spring.repositories;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.amdocs.spring.entities.Employee;
import com.amdocs.spring.exceptions.EmployeeNotFound;


@Repository
public class EmployeeRepositories {

			List<Employee>emp=new ArrayList<>();
			
			public EmployeeRepositories() {
				emp.add(new Employee(1,"savni",18,"Dev"));
				emp.add(new Employee(2,"rohit",23,"tester"));
				emp.add(new Employee(3,"ram",50,"dev"));
				
			}
			public List<Employee>findAll(){
				return emp;
			

			}
			
			public Employee findById(int id) {
				Optional<Employee> emps =emp.stream().filter((b1)->b1.getId()==id).findAny();
				return emps.orElseThrow(()->new EmployeeNotFound("Employee not found" +id));
			}
			
			public Employee addEmployee(Employee employee) {
				emp.add(employee);
				return employee;
			}
			
			public Employee updateEmployee(int id,Employee employee) {
				Employee employee1=findById(id);
				employee1.setName(employee.getName());
				employee1.setAge(employee.getAge());
				employee1.setRole(employee.getRole());
				return employee;
			}
			public void deleteEmployee(int id) {
				Employee employee1=findById(id);
				emp.remove(employee1);
			}
}
