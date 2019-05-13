package com.group5.projectplanner.app;
public class OperationNotAllowedException extends Throwable {
	String errorMessage = "";
	
	public OperationNotAllowedException(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	public String getMessage(){
		return errorMessage;
	}
}
