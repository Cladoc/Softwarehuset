package com.group5.projectplanner.app;
//Author: Casper Egholm Jørgensen (s163950)
public class OperationNotAllowedException extends Exception {
	String errorMessage = "";
	
	public OperationNotAllowedException(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	public String getMessage(){
		return errorMessage;
	}
}
