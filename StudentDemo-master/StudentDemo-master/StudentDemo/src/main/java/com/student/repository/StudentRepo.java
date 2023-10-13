package com.student.repository;

import com.student.model.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepo extends MongoRepository<Student, String>{

    Optional<Student> findByStudentId (int Id);
}
