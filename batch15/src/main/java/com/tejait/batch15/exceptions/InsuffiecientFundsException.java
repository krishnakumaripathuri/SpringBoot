package com.tejait.batch15.exceptions;

public class InsuffiecientFundsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InsuffiecientFundsException() {
		super();
		
	}
	
	public InsuffiecientFundsException(String msg) {
		super(msg);
	}

}
