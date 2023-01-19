package com.nurlan.student.service.controller;

import com.nurlan.student.service.VO.RestTemplateVO;
import com.nurlan.student.service.entity.Student;
import com.nurlan.student.service.exception.StudentNotFoundException;
import com.nurlan.student.service.service.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public RestTemplateVO getStudentInfo(@PathVariable Long id){
        return studentService.getStudentInfo(id);
    }

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFoundException(StudentNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }





}
