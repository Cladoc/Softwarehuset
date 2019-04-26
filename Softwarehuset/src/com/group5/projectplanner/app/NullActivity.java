package com.group5.projectplanner.app;

public class NullActivity extends Activity {
	
	@Override
	public void setName(String name) {}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Null Activity";
	}


	@Override
	public boolean isNil() {
		return true;
	}

	//Author: Casper (s163950)
	@Override
	public boolean equals(Object obj){
		return false;	
	}
	
}
