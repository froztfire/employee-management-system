package com.codelab.EmployeeManagermentSystem.controller;

import com.codelab.EmployeeManagermentSystem.dto.DepartmentDto;
import com.codelab.EmployeeManagermentSystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //CREATE API TO ADD DEPARTMENT
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto result = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    //CREATE API TO GET ALL DEPARTMENT
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> listAllDepartment() {
        List<DepartmentDto> result = departmentService.getAllDepartment();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //CREATE API TO GET DEPARTMENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
        DepartmentDto department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto updatedDepartment){
        DepartmentDto savedDepartment = departmentService.updateDepartment(departmentId, updatedDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Department Deleted",HttpStatus.OK);
    }
}
