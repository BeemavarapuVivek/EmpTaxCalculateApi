package com.viz.empDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleException(DataSourceException dse){
		return new ErrorResponse(dse.getMessage(), HttpStatus.CONFLICT.value());
	}
	
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleException(EmployeeNotFoundException nfe) {
		return new ErrorResponse(nfe.getMessage(),HttpStatus.CONFLICT.value());
	}
}
