package com.tejait.batch15.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice // Spring boot will recognize this is global exception handler class
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorDtls> idNotFoundException(HttpServletRequest request) {
		Date date = new Date();
		ErrorDtls error = new ErrorDtls(date, 407, "Id Not Found", "given Id Not Available", request.getRequestURI());
		System.out.println(error);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MobileAlreadyExists.class)
	public ResponseEntity<ErrorDtls> mobileAlreadyExists(HttpServletRequest request) {
		Date date = new Date();
		ErrorDtls error = new ErrorDtls(date, 409, "Mobile Number is Already Exists",
				"given MobilesNumber is ON Already Available", request.getRequestURI());
		System.out.println(error);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MailAlreadyExists.class)
	public ResponseEntity<ErrorDtls> mailAlreadyExists(HttpServletRequest request){
		ErrorDtls error=new ErrorDtls(new Date(),450, "Mail is Already Exist", "Given Mail Is Already In Available",request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDtls> globalExceptionMethod(HttpServletRequest request){
		ErrorDtls error=new ErrorDtls(new Date(),550,"something went wrong", "unknown error is occured",request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(InvalidAmount.class)
	public ResponseEntity<ErrorDtls> invalidAmount(HttpServletRequest request){
		ErrorDtls error=new ErrorDtls(new Date(),750,"invalid amount is not exists","unknown error is occures and runtime exception it will give",request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.BAD_GATEWAY);
	}

}
