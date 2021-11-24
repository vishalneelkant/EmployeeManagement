package com.EmployeeManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {
	
	private Long employeeId;
	private String employeeName;
	private String dept;
	private String designation;
	private String salary;
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(Long employeeId, String employeeName, String dept, String designation, String salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dept = dept;
		this.designation = designation;
		this.salary = salary;
	}
	
	
}
