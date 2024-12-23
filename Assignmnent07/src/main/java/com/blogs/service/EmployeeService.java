package com.blogs.service;

import java.util.List;

import com.blogs.pojos.Employee;

import io.swagger.v3.oas.models.responses.ApiResponse;

public interface EmployeeService {

	public List<Employee> getAllEmployee() ;

	String addNewEmployee(Employee employee);

    Employee getEmployeeDetails(Long empId);

     String updateEmployee(Long empId, Employee employee);

	 String deleteEmployee(Long empId);

}
