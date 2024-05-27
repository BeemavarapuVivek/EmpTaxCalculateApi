package com.viz.empDemo.exception;



public class ErrorResponse {

	private String msg;
	
	private int statusCode;

	public ErrorResponse(String msg, int statusCode) {
		super();
		this.msg = msg;
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
}
