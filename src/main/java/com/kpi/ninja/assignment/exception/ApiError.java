package com.kpi.ninja.assignment.exception;

public class ApiError {
	
	private String source;
	private String reasonCode;
	private String description;
	
	
	public ApiError(String string, String string2, String string3) {
		this.source=string;
		this.reasonCode=string2;
		this.description=string3;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
