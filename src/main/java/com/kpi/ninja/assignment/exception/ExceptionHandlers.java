package com.kpi.ninja.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<Object> handleApiException(ApiException exception)
	{
		return new ResponseEntity<>(exception.getApiErrorResponse(),HttpStatus.NOT_FOUND);
		
	}

}
