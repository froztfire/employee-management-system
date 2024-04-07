package com.codelab.EmployeeManagermentSystem.repository;

import com.codelab.EmployeeManagermentSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
