package com.kpi.ninja.assignment.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {
	
	private HttpStatus status;
	
	private final List<ApiError> apiErrors=new ArrayList<>();
	
	public ApiErrorResponse(HttpStatus status)
	{
		this.status=status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<ApiError> getApiErrors() {
		return apiErrors;
	}

	
}
