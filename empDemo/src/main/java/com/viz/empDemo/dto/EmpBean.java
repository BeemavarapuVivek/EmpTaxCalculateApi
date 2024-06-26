package com.viz.empDemo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpBean {

	@NotBlank(message = "Invalid firstName: Empty firstName")
	@Nonnull
	private String firstName;
	
	@NotBlank(message = "Invalid lastName: Empty lastName")
	@Nonnull
	private String lastName;
	
	@Email(message = "Invalid email")
	private String email;
	
//	@NotBlank(message = "Invalid phoneNumbers: Empty phoneNumbers")
//	@Nonnull
	private List<String> phoneNumbers;
	
	@NotBlank(message = "Invalid Date: Empty Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd")
	private String doj;
	
	
//	@NotBlank(message = "Invalid salary: Empty salary")
	private Double salary;

	
}
