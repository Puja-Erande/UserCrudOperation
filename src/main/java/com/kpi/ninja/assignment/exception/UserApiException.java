package com.kpi.ninja.assignment.exception;

public class UserApiException extends ApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserApiException(String source,String code,String description)
	{

		super(source,code,description);
	}

}
