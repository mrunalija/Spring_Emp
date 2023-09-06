package com.amdocs.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.spring.entities.Employee;

public interface empdb extends JpaRepository<Employee,Integer> {
	

}
