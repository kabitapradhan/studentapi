package com.sts.payload;


public class ApiResponse {
	
	private String message;
	private boolean dt;
	
	
	public ApiResponse() {
		super();
	}
	public ApiResponse(String message, boolean dt) {
		this.message = message;
		this.dt = dt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isDt() {
		return dt;
	}
	public void setDt(boolean dt) {
		this.dt = dt;
	}
	

}
