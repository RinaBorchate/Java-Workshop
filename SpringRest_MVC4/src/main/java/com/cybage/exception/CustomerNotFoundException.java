package com.cybage.exception;
public class CustomerNotFoundException extends RuntimeException {

	  public CustomerNotFoundException (String errorMessage) {
	        super(errorMessage);
}
}