package com.blogs.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>
{
	
}
