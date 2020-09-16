package com.osp.icebreaker.constants;

public enum JobActionKeys {
    ADD("ADD"),
    DELETE("DELETE"),
    CANCEL("CANCEL"),
    COPY("COPY"),
    SUSPEND("SUSPEND"),
    RESTART("RESTART"),
    PERMISSIONS("PERMISSIONS"),
    UPDATE("UPDATE"),
    RUN("RUN"),
    RERUN("RERUN"),
    VIEW("VIEW");
	
	@Override
	public String toString(){
		return this.value;
	}
	
	public boolean equal( String type ){
		return this.value.equalsIgnoreCase(type);
	}
	
	public String value(){
		return this.value;
	}
	
	private String value;
	
	private JobActionKeys( String value ){
		this.value = value;
	}
}
