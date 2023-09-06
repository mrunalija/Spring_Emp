package com.amdocs.spring.exceptions;

public class EmployeeNotFound extends RuntimeException{
		public EmployeeNotFound (String message) {
			super(message);
		}
}
