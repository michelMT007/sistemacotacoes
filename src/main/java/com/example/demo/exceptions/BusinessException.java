package com.example.demo.exceptions;

@SuppressWarnings("serial")

public class BusinessException extends RuntimeException{

	public BusinessException(String message) {
		
		super(message);
	}
}
