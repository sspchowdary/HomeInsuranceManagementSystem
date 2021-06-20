package com.cg.hims.exceptions;


	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class PolicyNotFoundException extends Exception{

	    public PolicyNotFoundException(String message) {
			super(message);
		}

		private static final long serialVersionUID = 1L;

	   
	    
	}


