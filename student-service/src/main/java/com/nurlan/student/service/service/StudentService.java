package com.nurlan.student.service.service;

import com.nurlan.student.service.VO.Department;
import com.nurlan.student.service.VO.RestTemplateVO;
import com.nurlan.student.service.VO.University;
import com.nurlan.student.service.entity.Student;
import com.nurlan.student.service.exception.StudentNotFoundException;
import com.nurlan.student.service.repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final RestTemplate restTemplate;

    private final StudentRepository studentRepository;

    public static final String STUDENT_SERVICE = "STUDENT-SERVICE";


    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }


    @CircuitBreaker(name = STUDENT_SERVICE)
    public RestTemplateVO getStudentInfo(Long id){
        RestTemplateVO vo = new RestTemplateVO();

        Student student = studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student not found ID: " + id));

        assert student != null;
        University university = restTemplate.getForObject("http://UNIVERSITY-SERVICE/universities/" +
                student.getUniversityId(), University.class);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +
                student.getDepartmentId(), Department.class);

        vo.setStudent(student);
        vo.setUniversity(university);
        vo.setDepartment(department);

        return vo;
    }

}
