package com.viz.empDemo.dto;



public class EmployeeResponseBean {

	private String code;
	
    private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Double yearlySalary;
	
	private Double totalTax;
	
	private Double totalCess;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public Double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(Double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public Double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}

	public Double getTotalCess() {
		return totalCess;
	}

	public void setTotalCess(Double totalCess) {
		this.totalCess = totalCess;
	}

	public EmployeeResponseBean(String code, String firstName, String lastName, String email, Double yearlySalary,
			Double totalTax, Double totalCess) {
		super();
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.yearlySalary = yearlySalary;
		this.totalTax = totalTax;
		this.totalCess = totalCess;
	}
	
	
}
