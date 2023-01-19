package com.nurlan.student.service.VO;

import com.nurlan.student.service.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestTemplateVO {

    private Student student;
    private University university;
    private Department department;
}
