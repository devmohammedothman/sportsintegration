package com.quasas.sports.boot.shared;

public enum StatusCode {
	
	SUCCESSFULL( 2001) , 
	BADREQUEST (4001),
	NOTFOUND (4002);
	
	
	    private final int value;
	    
	    StatusCode(int value)
	    {
	    	this.value = value;
	    }
	    
	    public int getValue()
	    {
	    	return this.value;
	    }

}
