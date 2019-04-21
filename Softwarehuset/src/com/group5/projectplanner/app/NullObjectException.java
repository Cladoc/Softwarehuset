package com.group5.projectplanner.app;

//Author: Casper (s163950)
public class NullObjectException extends Throwable{
	String errorMessage = "";
	
	public NullObjectException(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	public String getMessage(){
		return errorMessage;
	}
	
}
