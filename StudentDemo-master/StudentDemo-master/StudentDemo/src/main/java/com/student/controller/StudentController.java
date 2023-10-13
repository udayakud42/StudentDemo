package com.student.controller;

import com.student.dto.StudentDTO;
import com.student.model.Student;
import com.student.service.StudentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentService serv;
    
    @GetMapping("/find/{stuId}")
    public StudentDTO findOne(@PathVariable long stuId){
        log.info("findOne in Controller is called");
        return serv.getStudentById(stuId);        
    }
    
    @GetMapping("/find")
    public List<StudentDTO> findAll(){
        log.info("findOne in Controller is called");
        List<StudentDTO> allStudent = serv.getAllStudent();
        return allStudent;
    }

    @PostMapping("create")
    public String Create(@Valid @RequestBody StudentDTO stu){
        log.info("Create in Controller is called");      
        return serv.saveStudent(stu);
    }
    
    @PutMapping("update/{stuId}")
    public Student Update(@PathVariable long stuId, @Valid @RequestBody StudentDTO stu){
        log.info("Create in Controller is called");      
        return serv.updateStudent(stuId, stu);
    }
}
