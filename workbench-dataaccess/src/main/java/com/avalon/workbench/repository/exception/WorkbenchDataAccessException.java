package com.avalon.workbench.repository.exception;


public class WorkbenchDataAccessException extends Exception {

	private static final long serialVersionUID = -463972374030603782L;

	private String message;
	private int errorCode;

	public WorkbenchDataAccessException() {
		super();
	}

	public WorkbenchDataAccessException(String mesString, int errorCode) {
		super(mesString + " :  " + errorCode);
		this.errorCode = errorCode;
		this.message = mesString;
	}

	public WorkbenchDataAccessException(Exception e) {
		super(e);
		this.message = e.getMessage();
	}
	@Override
	public String toString() {
		return message + " : " +errorCode;
	}

}
