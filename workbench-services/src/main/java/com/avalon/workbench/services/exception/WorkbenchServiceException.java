package com.avalon.workbench.services.exception;

/**
 * 
 */
public class WorkbenchServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;
	private int errorCode;

	/**
	 * 
	 */
	public WorkbenchServiceException() {
		super();
	}

	/**
	 * 
	 * @param mesString
	 * @param errorCode
	 */
	public WorkbenchServiceException(String mesString, int errorCode) {
		super(mesString);
		this.errorCode = errorCode;
		this.message = mesString;
	}

	/**
	 * 
	 * @param e
	 */
	public WorkbenchServiceException(Exception e) {
		super(e.getMessage());
		this.message = e.getMessage();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
