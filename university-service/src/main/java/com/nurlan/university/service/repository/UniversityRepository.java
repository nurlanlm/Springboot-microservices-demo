package com.nurlan.university.service.repository;

import com.nurlan.university.service.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
