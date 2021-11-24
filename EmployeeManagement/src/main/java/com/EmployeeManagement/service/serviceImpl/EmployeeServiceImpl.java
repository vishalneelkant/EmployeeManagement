package com.EmployeeManagement.service.serviceImpl;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import com.EmployeeManagement.service.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public String createEmployee(Employee emp) {
	
		Employee e = employeeRepo.save(emp);
		return "added " + e.getEmployeeName() + " " + "with id" + " " + e.getEmployeeId(); 
	}

	@Override
	public Employee getEmployee(Long empId) {
		
		Optional<Employee> optional = employeeRepo.findById(empId);
		return optional.get();
	}

	@Override
	public String deleteEmployee(Long empId) {
		Optional<Employee> emp = employeeRepo.findById(empId);
		if(emp.isPresent()) {
			employeeRepo.deleteById(empId);
			return "Deleted " + empId;
		}
		else {
			return "Employee Not found";
		}
	} 
	
	@Override
	public List<Employee> getAllEmployee(){
		List<Employee> empList = new ArrayList<>();
		Iterable<Employee> empIterator = employeeRepo.findAll();
		
		for(Employee e : empIterator) {
			Employee emp = new Employee();
			emp.setDept(e.getDept());
			emp.setDesignation(e.getDesignation());
			emp.setEmployeeId(e.getEmployeeId());
			emp.setEmployeeName(e.getEmployeeName());
			emp.setSalary(e.getSalary());
			
			empList.add(emp);
		}
		
		return empList;
		
	}
	
	@Override
	public Employee updateEmployee(Long empId, Employee employee) {
		
		Employee empToSave = new Employee();
		
		Optional<Employee> optionalEmp =  employeeRepo.findById(empId);
		Employee empFromRepo = optionalEmp.get();
		
		if(employee.getDept()==null || employee.getDept().isEmpty()) {
			empToSave.setDept(empFromRepo.getDept());
		}
		else {
			empToSave.setDept(employee.getDept());
		}
		
		if(employee.getDesignation()==null|| employee.getDesignation().isEmpty()) {
			empToSave.setDesignation(empFromRepo.getDesignation());
		}
		else {
			empToSave.setDesignation(employee.getDesignation());
		}
		
		if(employee.getEmployeeName()==null || employee.getEmployeeName().isEmpty()) {
			empToSave.setEmployeeName(empFromRepo.getEmployeeName());
		}
		else {
			empToSave.setEmployeeName(employee.getEmployeeName());
		}
		
		if(employee.getSalary()==null) {
			empToSave.setSalary(empFromRepo.getSalary());
		}
		else {
			empToSave.setSalary(employee.getSalary());
		}
		
		empToSave.setEmployeeId(empFromRepo.getEmployeeId());
		
		employeeRepo.save(empToSave);
		return empToSave;
	}
	
	
}
