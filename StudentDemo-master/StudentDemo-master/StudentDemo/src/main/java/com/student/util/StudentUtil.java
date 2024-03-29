package com.student.util;

import com.student.exception.DataNotFoundException;
import com.student.model.Student;
import com.student.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Component
@Slf4j
public class StudentUtil {
    @Autowired
    private StudentRepo repo;

    public Student getStudentById (long id){
    	log.info("getStudentById is called from Util Class...");
    	return repo.findByStudentId(id).orElseThrow(()-> new DataNotFoundException("Student not found with ID : "+ id));         	 
    }

    public Date getDateFromString(String inputDate) {
        log.info("Control entered into date parsed ");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date formattedDOB = null;
        try {
            formattedDOB = sdf.parse(inputDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        log.info("date parsed :: " + formattedDOB);
        return formattedDOB;
    }
    
    
}
