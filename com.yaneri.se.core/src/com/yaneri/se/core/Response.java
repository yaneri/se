package com.yaneri.se.core;

public class Response {
	
	final Object response;
	
	final Object output;
	
	private int status;
	
	public Response(Object response, Object output) {
		this.response = response;
		this.output = output;
	}

	@SuppressWarnings("unchecked")
	public <T> T getResponse() {
		return (T) response;
	}

	@SuppressWarnings("unchecked")
	public <V> V getOutput() {
		return (V) output;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
