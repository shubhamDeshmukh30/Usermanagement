package com.neosoft.springbootpoc.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.neosoft.springbootpoc.customexception.InvalidId;
import com.neosoft.springbootpoc.customexception.cityNotBeNull;

@ControllerAdvice
public class GlobalExceptionhandler {

	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<?> invalididHandling(InvalidId invalidId, WebRequest request) {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(cityNotBeNull.class)
	public ResponseEntity<?> invalidCityNameHandling(InvalidId invalidId, WebRequest request) {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	
}
