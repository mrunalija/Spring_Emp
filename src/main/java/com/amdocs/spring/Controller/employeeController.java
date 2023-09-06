package com.amdocs.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amdocs.spring.entities.Employee;
import com.amdocs.spring.Services.EmployeeServices;


@RestController
@RequestMapping("/api/v1/emp") //common uri for all request
public class employeeController{
	 
	@Autowired
	EmployeeServices employeeService;
	
	
	@GetMapping
	public ResponseEntity<List<Employee>>getAllEmployee(Pageable pageable)
	{
		
		return new ResponseEntity<List<Employee>>(employeeService.findAll(pageable),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee>findById(@PathVariable int id){
		return new ResponseEntity<Employee>(employeeService.findById(id),HttpStatus.OK);
	}
	//http://localhost:9090/api/v1/emp
	@PostMapping
	public ResponseEntity<Employee>addEmployee(@RequestBody Employee emps)
	{
		return new ResponseEntity<Employee>(employeeService.addEmployee(emps),HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable int id, @RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id,employee),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee>deleteEmployee(@PathVariable int id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}