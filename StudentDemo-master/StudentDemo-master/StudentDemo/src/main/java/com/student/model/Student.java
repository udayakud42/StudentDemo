package com.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "StudentDemo")
public class Student {
    
    @Id
    private String id;
    private Long studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dOB;
    private String eMail;
    private String mobileNumber;

}
