package com.viz.empDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(DataSourceException.class)
	@ResponseStatus(value=HttpStatus.BAD_GATEWAY)
	public ErrorResponse handleException(DataSourceException dse,WebRequest req){
		return new ErrorResponse(dse.getMessage(), HttpStatus.BAD_GATEWAY.value());
	}
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ErrorResponse handleException(EmployeeNotFoundException nfe,WebRequest req) {
		return new ErrorResponse(nfe.getMessage(),HttpStatus.NOT_FOUND.value());
	}
	
	@ExceptionHandler(EmpNotEmpty.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public ErrorResponse handleException(EmpNotEmpty en,WebRequest req) {
		return new ErrorResponse(en.getMessage(),HttpStatus.BAD_REQUEST.value());
	}
}
