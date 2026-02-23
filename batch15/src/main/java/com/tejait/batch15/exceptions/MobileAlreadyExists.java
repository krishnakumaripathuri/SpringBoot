package com.tejait.batch15.exceptions;

public class MobileAlreadyExists extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  MobileAlreadyExists() {
		super();
		
	}
	
	public MobileAlreadyExists(String msg) {
		super(msg);
	}
}
