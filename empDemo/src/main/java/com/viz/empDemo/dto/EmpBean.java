package com.viz.empDemo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public EmpBean(String firstName, String lastName, String email, List<String> phoneNumbers, String doj,
			Double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.doj = doj;
		this.salary = salary;
	}
	
	
}
