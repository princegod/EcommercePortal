package com.microservice.eventmanagementapi.exception;

public class NotCheckedInException extends RuntimeException {
	
	public NotCheckedInException(String errorMessage) {
		super(errorMessage);
	}

}
