package com.student.dto;

import java.util.Date;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	
	private Long studentId;
	@NotEmpty(message = "Enter First name")
	@Pattern(regexp = "^[a-zA-Z '.-]+$", message = "Please enter a valid name")
	@Size(min = 3, max = 25, message = "Minimum 3 characters required")
	private String firstName;
	@NotEmpty(message = "Enter Middle name")
	@Pattern(regexp = "^[a-zA-Z '.-]+$", message = "Please enter a valid name")
	@Size(min = 3, max = 25, message = "Minimum 3 characters required")
	private String middleName;
	@NotEmpty(message = "Enter Last name")
	@Pattern(regexp = "^[a-zA-Z '.-]+$", message = "Please enter a valid name")
	@Size(min = 3, max = 25, message = "Minimum 3 characters required")
	private String lastName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date dOB;
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_+-]+(\\.[A-Za-z0-9_+-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid email")
	@Size(min = 1, max = 50, message = "Please enter a valid email")
	private String eMail;
	@Pattern(regexp = "^.{0}|[ ]{1}|([0-9]{10})", message = "Mobile Phone Number not valid")
	private String mobileNumber;

}
