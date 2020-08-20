package com.movierating.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RatingException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public RatingException(String message) {
		super(message);
	}
	
	public RatingException(String message, Throwable t) {
		super(message, t);
	}

}
