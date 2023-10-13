package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDTO;
import com.student.exception.BadRequest;
import com.student.exception.DataNotFoundException;
import com.student.model.Student;
import com.student.repository.StudentRepo;
import com.student.util.StudentUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private StudentUtil util;

    public StudentDTO getStudentById(long id){
        log.info("getStudentById in Service is called");
         Student studentById = util.getStudentById(id); 
         StudentDTO dto = new StudentDTO();
         BeanUtils.copyProperties(studentById, dto);
         return dto;
        }

    public List<StudentDTO> getAllStudent(){
        log.info("getAllStudent in Service is called");
        List<Student> li = repo.findAll();        
        return li.stream().map(student -> new StudentDTO(student.getStudentId(),student.getFirstName(),student.getMiddleName(),
        		student.getLastName(),student.getDOB(),student.getEMail(),student.getMobileNumber())).collect(Collectors.toList());
    }

	public String saveStudent(StudentDTO stu) {
		log.info("saveStudent in Service is called");
		try {
			Student st = new Student();
			BeanUtils.copyProperties(stu, st);
			Student saved = repo.save(st);
			return "Student saved with ID : " + saved.getStudentId();
		} catch (Exception e) {
			throw new BadRequest("Student data not saved to DB");
		}	
	}
	
	public Student updateStudent(long id, StudentDTO stu){
		log.info("updateStudent in Service is called");
		try {
			Student existingStu = repo.findByStudentId(id).orElseThrow(()->new DataNotFoundException("Student not found with ID : "+ id));
			if(existingStu != null) {
				existingStu.setFirstName(stu.getFirstName());
				existingStu.setMiddleName(stu.getMiddleName());
				existingStu.setLastName(stu.getLastName());
				existingStu.setDOB(stu.getDOB());
				existingStu.setEMail(stu.getEMail());
				existingStu.setMobileNumber(stu.getMobileNumber());
				Student saved = repo.save(existingStu);				
				return saved;
			}
		} catch (Exception e) {
			throw new BadRequest("Student data not saved to DB");
		}
		return null;				
	}
}
