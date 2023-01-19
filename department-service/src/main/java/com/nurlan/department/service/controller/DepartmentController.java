package com.nurlan.department.service.controller;


import com.nurlan.department.service.entity.Department;
import com.nurlan.department.service.exceptions.DepartmentNotFoundException;
import com.nurlan.department.service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping
    public ResponseEntity<List<Department>> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @ExceptionHandler(value = DepartmentNotFoundException.class)
    public ResponseEntity<String> departmentNotFound(DepartmentNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }
}
