package com.project.website.exceptionHandlers;

public class CustomExceptionHandler extends RuntimeException{
	
	public CustomExceptionHandler(String exception) {
		super(exception);
	}
}
