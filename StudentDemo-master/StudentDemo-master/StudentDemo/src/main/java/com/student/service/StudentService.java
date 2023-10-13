package com.student.service;

import com.student.exception.DataNotFoundException;
import com.student.model.Student;
import com.student.repository.StudentRepo;
import com.student.util.StudentUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public Student getStudentById(String id){
        log.info("getStudentById in Service is called");
        Student stu = repo.findById(id).get();

        if (stu != null){
            return stu;
        }
        throw new DataNotFoundException("No Student found for the provided ID" + id);
    }

    public List<Student> getAllStudent(){
        log.info("getAllStudent in Service is called");
        List<Student> li = repo.findAll();
        return li;
    }
}
