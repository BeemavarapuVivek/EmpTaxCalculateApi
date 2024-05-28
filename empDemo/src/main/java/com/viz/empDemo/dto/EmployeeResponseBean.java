package com.viz.empDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseBean {

	private String code;
	
    private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Double yearlySalary;
	
	private Double totalTax;
	
	private Double totalCess;


	
}
