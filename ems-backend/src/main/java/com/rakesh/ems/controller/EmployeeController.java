package com.rakesh.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.ems.dto.EmployeeDto;
import com.rakesh.ems.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employee)
	{ 
			EmployeeDto emp=employeeService.createEmployee(employee);
			return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<EmployeeDto> getByEmpId(@PathVariable long id)
	{
		EmployeeDto empdto=employeeService.getEmployeeById(id);
		return ResponseEntity.ok(empdto);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees()
	{
		List<EmployeeDto> emp=employeeService.getAllEmployees();
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id ,@RequestBody EmployeeDto empdto)
	{
		EmployeeDto emp=employeeService.updateEmployee(id,empdto);
		return  ResponseEntity.ok(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long empId)
	{
		employeeService.deleteEmployee(empId);
		return ResponseEntity.ok("Delete Sucessfully");
	}

}
