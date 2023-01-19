package com.nurlan.university.service.controller;

import com.nurlan.university.service.entity.University;
import com.nurlan.university.service.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping
    public List<University> getAll(){
        return universityService.getAll();
    }

    @GetMapping("/{id}")
    public University findById(@PathVariable Long id){
        return universityService.findById(id);
    }

    @PostMapping("/add")
    public University addUniversity(@RequestBody University university){
        return universityService.addUniversity(university);
    }
}
