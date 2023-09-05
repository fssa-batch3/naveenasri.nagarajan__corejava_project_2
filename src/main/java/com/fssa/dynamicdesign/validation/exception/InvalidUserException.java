package com.fssa.dynamicdesign.validation.exception;


public class InvalidUserException extends Exception {

	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable msg) {
		super(msg);
	}
}