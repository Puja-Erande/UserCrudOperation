package com.kpi.ninja.assignment.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1936125292965483671L;
	private ApiErrorResponse response;
	
	public ApiException(HttpStatus status)
	{
		
		this.response=new ApiErrorResponse(status);
		
		
	}

	public ApiException(String source, String code, String description) {
		this.response=new ApiErrorResponse(HttpStatus.BAD_REQUEST);
		this.response.getApiErrors().add(new ApiError(source, code, description));
		
	}

	
	public List<ApiError> getApiErrorResponse()
	{
		return this.response.getApiErrors();
	}
}
