package com.osp.icebreaker.constants;

public enum JobTypes {
	SEQ(0),
	OPENMP(1),
	OPENMPI(2),
	INTELMPI(3),
	GAMESSMP(4);
	
	@Override
	public String toString(){
		switch( this ){
			case SEQ:
				return "sequential";
			case OPENMP:
				return "openmp";
			case OPENMPI:
				return "openmpi";
			case INTELMPI:
				return "intelmpi";
			case GAMESSMP:
				return "gamessmp";
		}
		
		return "";
	}
	
	public boolean equal( int type ){
		return this.value == type; 
	}
	
	public boolean equal( String type ){
		return this.toString().equalsIgnoreCase(type);
	}
	
	private JobTypes(int value) {
		this.value = value;
	}
	
	private int value;
}
