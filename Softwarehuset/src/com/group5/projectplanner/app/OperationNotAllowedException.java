package com.group5.projectplanner.app;
//Author: Casper (s163950)
public class OperationNotAllowedException extends Throwable {
	String errorMessage = "";
	
	public OperationNotAllowedException(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	public String getMessage(){
		return errorMessage;
	}
}
