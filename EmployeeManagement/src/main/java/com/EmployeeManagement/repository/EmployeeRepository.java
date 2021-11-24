package com.EmployeeManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagement.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	
}
