package com.usermanager.atosusermanager.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserManagerFuncException extends Exception {
	private final HttpStatus httpStatus;
	private final String errorCode;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserManagerFuncException(String message, String errorCode, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}

}
