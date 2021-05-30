package com.example.demo.exceptions;

import com.example.demo.util.MessageUtils;

public class NotFoundExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundExeption() {
		super(MessageUtils.NO_RECORDS_FOUND);
	}
	
}
 