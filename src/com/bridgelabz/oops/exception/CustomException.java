package com.bridgelabz.oops.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomException() {
		super("Error Occured");
	}

	public CustomException(String errorMsg, Throwable error) {
		super(errorMsg, error);
	}
}
