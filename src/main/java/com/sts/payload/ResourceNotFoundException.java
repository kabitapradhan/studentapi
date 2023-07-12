package com.sts.payload;

public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long userId) {
		super(String.format("%s not found with %s : %s " ,resourceName ,fieldName , userId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = userId;
		
	}

}
