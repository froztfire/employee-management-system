package com.codelab.EmployeeManagermentSystem.mapper;

import com.codelab.EmployeeManagermentSystem.dto.DepartmentDto;
import com.codelab.EmployeeManagermentSystem.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription())
                ;
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
