package com.nurlan.student.service.repository;

import com.nurlan.student.service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
