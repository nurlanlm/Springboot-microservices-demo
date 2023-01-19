package com.nurlan.department.service.repository;

import com.nurlan.department.service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
