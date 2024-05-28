package com.viz.empDemo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public EmployeeNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
}
