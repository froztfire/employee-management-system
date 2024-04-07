package com.codelab.EmployeeManagermentSystem.service;

import com.codelab.EmployeeManagermentSystem.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartment();

    DepartmentDto getDepartmentById(Long departmentId);

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto);

    void deleteDepartment(Long departmentId);
}
