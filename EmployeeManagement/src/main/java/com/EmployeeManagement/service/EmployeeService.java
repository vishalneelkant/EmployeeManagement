package com.EmployeeManagement.service;

import java.util.List;

import com.EmployeeManagement.entity.Employee;

public interface EmployeeService {
	
	public String createEmployee(Employee emp);
	
	public Employee getEmployee(Long empId);
	
	public String deleteEmployee(Long empId);
	
	public List<Employee> getAllEmployee();
	
	public Employee updateEmployee(Long empId, Employee employee);
}
