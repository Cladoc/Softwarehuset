package com.group5.projectplanner.app;
//Author: Casper Egholm J�rgensen (s163950)
public class FormattingException extends Throwable {
	String errorMessage = "";
	
	public FormattingException(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
	public String getMessage(){
		return errorMessage;
	}
}
