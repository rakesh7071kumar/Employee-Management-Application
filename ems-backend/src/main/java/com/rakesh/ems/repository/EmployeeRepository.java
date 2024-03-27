package com.rakesh.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakesh.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
