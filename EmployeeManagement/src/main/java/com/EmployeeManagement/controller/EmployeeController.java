package com.EmployeeManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.service.EmployeeService;


@RestController
@RequestMapping("/employee") 
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping(value = "/createEmployee")
	public String createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping(value = "/getEmployee/{empId}")
	public Employee getEmployee(@PathVariable Long empId){
		return employeeService.getEmployee(empId);
	}
	
	@DeleteMapping(value = "/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable Long empId) {
		return employeeService.deleteEmployee(empId);
	}
	
	@GetMapping(value = "/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@PutMapping(value = "/updateEmployee/{empId}")
	public Employee updateEmployee(@PathVariable Long empId, @RequestBody Employee employee) {
		Employee emp =  employeeService.updateEmployee(empId, employee);
		return emp;
	}

}
