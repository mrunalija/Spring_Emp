package com.amdocs.spring.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class globalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<errorDetails>handleEmployeeNotFound(EmployeeNotFound ex)
	{
		errorDetails error = new errorDetails();
		error.setMessage(ex.getMessage());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setDatetime(LocalDateTime.now());
		
		ResponseEntity<errorDetails> res=new ResponseEntity<errorDetails>(error,HttpStatus.NOT_FOUND);
		return res;
		
		
	}
}
