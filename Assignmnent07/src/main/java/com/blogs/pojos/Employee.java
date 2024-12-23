package com.blogs.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

 
public class Employee extends BaseEntity {
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(unique=true)
	private String email;
	@Column(nullable=false,length=15)
	private String password;
	private double salary;
	private LocalDate joinDate;
	@Column(length=20)
	private String lacation;
	private String department;
	
	
	public Employee(String firstName, String lastName, String email, String password, double salary, LocalDate joinDate,
		String lacation, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.joinDate = joinDate;
		this.lacation = lacation;
		this.department = department;
	}
	
	
	

}
