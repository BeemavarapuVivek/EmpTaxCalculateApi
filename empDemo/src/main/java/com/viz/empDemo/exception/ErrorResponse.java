package com.viz.empDemo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	private String msg;
	
	private int statusCode;

	public ErrorResponse(String msg, int statusCode) {
		super();
		this.msg = msg;
		this.statusCode = statusCode;
	}

	
	
	
}
