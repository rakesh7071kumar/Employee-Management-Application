package com.rakesh.ems.service;

import java.util.List;

import com.rakesh.ems.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employee);
	
	EmployeeDto getEmployeeById(long empid);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(long empId,EmployeeDto empdto);
	
	void deleteEmployee(long empId);

}
