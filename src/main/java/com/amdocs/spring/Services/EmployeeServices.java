package com.amdocs.spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amdocs.spring.entities.Employee;
import com.amdocs.spring.exceptions.EmployeeNotFound;
import com.amdocs.spring.repositories.EmployeeRepositories;
import com.amdocs.spring.repositories.empdb;

@Service
public class EmployeeServices {

		@Autowired
		empdb employeeRepositories;
		
		public List<Employee>findAll(Pageable pageable){
			return employeeRepositories.findAll(pageable).toList();
		
	}
		public Employee findById(int id) {
			Optional<Employee> emps =employeeRepositories.findById(id);
			return emps.orElseThrow(()->new EmployeeNotFound("Employee not found" +id));
			
			
		}
		public Employee addEmployee(Employee emps) {
			return employeeRepositories.save(emps);
		}
		public Employee updateEmployee(int id,Employee employee) {
			Employee employee1=findById(id);
			employee1.setName(employee.getName());
			employee1.setAge(employee.getAge());
			employee1.setRole(employee.getRole());
			employeeRepositories.save(employee1);
			return employee1;
			
		}
		public void deleteEmployee(int id) {
			Employee emp=findById(id);
			 employeeRepositories.delete(emp);
			
		}
		
		
}
