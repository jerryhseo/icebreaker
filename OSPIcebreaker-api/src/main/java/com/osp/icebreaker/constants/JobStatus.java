package com.osp.icebreaker.constants;

public enum JobStatus {
	INIT(0),
	QUEUED(1),
	RUNNING(2),
	CANCELED(3),
	SUSPENED(4),
	FAILED(5),
	SUCCESS(6);
	
	public String toString(){
		switch( this ){
			case INIT:	return "init";
			case QUEUED:	return "queued";
			case RUNNING:	return "running";
			case CANCELED:	return "canceled";
			case SUSPENED:	return "suspended";
			case FAILED:	return "failed";
			case SUCCESS:	return "success";
		}
		
		return "";
	}
	
	public boolean equal( int type ){
		return this.value == type; 
	}
	
	public boolean equal( String type ){
		return this.toString().equalsIgnoreCase(type);
	}
	
	public int value(){
		return this.value;
	}
	
	private int value;
	private JobStatus( int value){
		this.value = value;
	}
}
