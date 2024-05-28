package com.viz.empDemo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpNotEmpty extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public EmpNotEmpty() {
		
	}
	public EmpNotEmpty(String msg) {
		super(msg);
		this.msg = msg;
	}
}
