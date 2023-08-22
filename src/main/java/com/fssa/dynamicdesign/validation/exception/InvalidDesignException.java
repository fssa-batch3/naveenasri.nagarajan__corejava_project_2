package com.fssa.dynamicdesign.validation.exception;

public class InvalidDesignException extends Exception {

	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidDesignException(String msg) {
		super(msg);
	}

	public InvalidDesignException(Throwable e) {
		super(e);
	}
}

