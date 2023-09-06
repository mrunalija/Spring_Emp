package com.amdocs.spring.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="employee_api") //name of table which orm will create in database
public class Employee {
		
		@Id                                                //primary key of table
		@GeneratedValue(strategy=GenerationType.IDENTITY)  //will auto increment this value
		public int id;
		@Column(nullable=false,unique=true) //name will not be null will be unique
		@NotEmpty(message="name can not be empty")
		@Size(min=3,message="name must be more than 3 chars")
		public String name;
		public int age;
		@Column(name="job")
		public String role;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Employee(int id, String name, int age, String role) {
			
			this.id = id;
			this.name = name;
			this.age = age;
			this.role = role;
		}
		public Employee() {
			
		}
		

}
