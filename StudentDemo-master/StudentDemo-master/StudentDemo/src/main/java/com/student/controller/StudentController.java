package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentService serv;
    @GetMapping("/find/{stuId}")
    public Student findOne(@PathVariable String stuId){
        log.info("findOne in Controller is called");
        Student st = serv.getStudentById(stuId);
        return st;
    }

//    @PostMapping("create")
//    public String Create(@RequestParam Student stu){
//        log.info("Create in Controller is called");
//        serv.saveStudent(stuId);
//        return stuId;
//    }
}
