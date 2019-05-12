package com.group5.projectplanner.app;
public class FormattingException extends Throwable {
	String errorMessage = "";
	
	public FormattingException(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	public String getMessage(){
		return errorMessage;
	}
}
