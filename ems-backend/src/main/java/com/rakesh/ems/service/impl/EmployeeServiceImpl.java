package com.rakesh.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.ems.dto.EmployeeDto;
import com.rakesh.ems.entity.Employee;
import com.rakesh.ems.exception.ResourceNotFoundException;
import com.rakesh.ems.mapper.EmployeeMapper;
import com.rakesh.ems.repository.EmployeeRepository;
import com.rakesh.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employee) {
		
		Employee em1=EmployeeMapper.mapToEmployee(employee);
		Employee savedEmployee=employeeRepository.save(em1);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(long empId) {
		 Employee emp=employeeRepository.findById(empId)
				 .orElseThrow(()->new ResourceNotFoundException("Emloyee not present in the data with the Id"+empId));
		 EmployeeDto empdto=EmployeeMapper.mapToEmployeeDto(emp);
		 return empdto;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> emp=employeeRepository.findAll();
		return emp.stream()
				.map((e)->EmployeeMapper.mapToEmployeeDto(e))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(long empId,EmployeeDto empdto) {
		
		Employee emp=EmployeeMapper.mapToEmployee(empdto);
		
		Employee empN=employeeRepository.findById(empId)
				.orElseThrow(()->new ResourceNotFoundException(""));
		empN.setFirstName(emp.getFirstName());
		empN.setLastName(emp.getLastName());
		empN.setEmail(emp.getEmail());
		employeeRepository.save(empN);
		
		return EmployeeMapper.mapToEmployeeDto(empN);
	}

	@Override
	public void deleteEmployee(long empId) {
		
		Employee emp=employeeRepository.findById(empId)
							.orElseThrow(()-> new ResourceNotFoundException("Emloyee not present in the data with the Id"+empId));
		
		employeeRepository.delete(emp);
		
		
		
	}

	

	
				
		 
		
	} 


