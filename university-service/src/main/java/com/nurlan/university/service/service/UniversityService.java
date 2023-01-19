package com.nurlan.university.service.service;

import com.nurlan.university.service.entity.University;
import com.nurlan.university.service.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    public List<University> getAll(){
        return universityRepository.findAll();
    }

    public University findById(Long id){
        return universityRepository.findById(id).orElse(null);
    }

    public University addUniversity(University university){
        return universityRepository.save(university);
    }
}
