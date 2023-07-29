package com.Cinema.GlobalExceptionHandling;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.Cinema.Exception.NoIdFoundException;
import com.Cinema.Exception.RatingException;
import com.Cinema.Exception.YearException;



@RestControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(YearException.class)
	public String handleYearException() {
		return "Invalid Data";
	}
	@ExceptionHandler(com.Cinema.Exception.MovieNotFoundException.class)
	public ResponseEntity<Object> MovieNotFoundException() {
		return new ResponseEntity<Object> ("Invalid Movie Name",HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(RatingException.class) 
	public ResponseEntity<Object> RatingException() {
		return new ResponseEntity<Object>("Range Given Is Wrong",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> NoSuchElementException() {
		return new ResponseEntity<Object>("ID is not Present",HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler(NoIdFoundException.class) 
	public ResponseEntity<Object> NoIdFoundExeption() {
		return new  ResponseEntity<Object>("NoIdFound",HttpStatus.BAD_REQUEST);
	}
	
}
