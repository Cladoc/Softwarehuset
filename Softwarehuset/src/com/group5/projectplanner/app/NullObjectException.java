package com.group5.projectplanner.app;

public class NullObjectException extends Throwable{
	String errorMessage = "";
	
	public NullObjectException(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	public String getMessage(){
		return errorMessage;
	}
	
}
