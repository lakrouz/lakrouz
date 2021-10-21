package com.usermanager.atosusermanager.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserManagerException extends Exception {
	private final HttpStatus httpStatus;
	private final String errorCode;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserManagerException(String message, String errorCode, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}

}
