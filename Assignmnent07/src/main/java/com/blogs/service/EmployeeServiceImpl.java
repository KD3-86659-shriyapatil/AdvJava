package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dao.EmployeeDao;
import com.blogs.pojos.Employee;

import io.swagger.v3.oas.models.responses.ApiResponse;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	@Override
	public String addNewEmployee(Employee employee) {
		Employee persistentEmployee=employeeDao.save(employee);
		return "Added new Employee th id-"+persistentEmployee.getId();	}

	@Override
	public Employee getEmployeeDetails(Long empId) {
		
		return employeeDao.findById(empId).orElseThrow();
	}

	@Override
	public String updateEmployee(Long empId, Employee employee) {
		if(employeeDao.existsById(empId)) {
		 employeeDao.save(employee);
		 return "Employee updated";
		}
		return "Updation failed!!";
	}

	@Override
	public String deleteEmployee(Long empId) {
		if(employeeDao.existsById(empId)) {
			employeeDao.deleteById(empId);
			return "employee Deleted-";
		}
		return "Deletion failed!!";
	}

}
