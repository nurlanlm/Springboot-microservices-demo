package com.nurlan.department.service.service;
import com.nurlan.department.service.entity.Department;
import com.nurlan.department.service.exceptions.DepartmentNotFoundException;
import com.nurlan.department.service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public ResponseEntity<Department> findById(Long id){

        Department department = departmentRepository.findById(id).orElseThrow(() ->
                new DepartmentNotFoundException("Department not found. ID: " + id));

        return new ResponseEntity<>(department, OK) ;
    }

    public ResponseEntity<Department> addDepartment(Department department) {
        return new ResponseEntity<>(departmentRepository.save(department), OK);
    }

    public ResponseEntity<List<Department>> getAll() {
        return new ResponseEntity<>(departmentRepository.findAll(), OK);
    }
}
