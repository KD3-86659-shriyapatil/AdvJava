package com.blogs.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.blogs.pojos.Employee;
import com.blogs.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3001")

public class EmployeeController {
    @Autowired
	private EmployeeService emplservice;
    
    public EmployeeController() {
	System.out.println("in ctor-"+getClass());
	}
    
//    URL-/categories
//    METHOD-get
//    PAYLOAD-
//    RESP-json
//    DESC-get all employees
  @GetMapping
  public ResponseEntity<?> getEmployees(){
	  System.out.println("get all employee-");
	  List<Employee> empl=emplservice.getAllEmployee();
	  if(empl != null) {
		  return ResponseEntity.ok(empl);
	  }
	  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 }
//  URL-/categories
//  METHOD-post
//  PAYLOAD-java => @RequestBody 
//  RESP-String desc
//  DESC-add new emeployee
  
  @PostMapping
  public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
	System.out.println("Add new employee-"+employee);
//	return ResponseEntity.status(HttpStatus.CREATED).body(emplservice.addNewEmployee(employee)) 
	return ResponseEntity.ok(emplservice.addNewEmployee(employee)) ;
	
}
//  URL-employees/{"/empid"}
//  METHOD-get
//  PAYLOAD-url variable employeeId
//  RESP-category->json
//  DESC-get employee by id
  
  @GetMapping("/{empId}")
  public ResponseEntity<?> getEmployeeDetails (@PathVariable Long empId){
	  System.out.println("employee details- "+empId);
	  try {
		  Employee employee=emplservice.getEmployeeDetails(empId);
		  return ResponseEntity.ok(employee);
	  }catch(RuntimeException e) {
		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	  }
  }
//  URL-/employees/{"/empId"}
//  METHOD-put
//  PAYLOAD-update employee content 
//  RESP- 
//  DESC-update employee details
  
  @PutMapping("/{empId}")
  public ResponseEntity<?> updateEmployee(@PathVariable Long empId,@RequestBody Employee employee){
	  System.out.println("Updated employee-"+empId+""+employee);
	  return ResponseEntity.ok(emplservice.updateEmployee(empId,employee));
  }
	@DeleteMapping
	public ResponseEntity<?> deleteEmployeeDetails(@RequestParam() Long empId)
	{
		System.out.println("in delete "+empId);
		try {
			//invoke service layer method
			return ResponseEntity.ok(
					emplservice.deleteEmployee(empId));
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		}
	}
  }
