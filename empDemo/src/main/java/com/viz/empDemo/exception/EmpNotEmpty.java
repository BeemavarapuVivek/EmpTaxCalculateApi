package com.viz.empDemo.exception;

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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
