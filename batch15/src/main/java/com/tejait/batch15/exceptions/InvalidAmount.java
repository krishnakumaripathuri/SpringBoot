package com.tejait.batch15.exceptions;


public class InvalidAmount extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAmount() {
		super();
		
	}
	
	public InvalidAmount(String msg) {
		super(msg);
	}
}
