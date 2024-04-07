package com.codelab.EmployeeManagermentSystem.repository;

import com.codelab.EmployeeManagermentSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
