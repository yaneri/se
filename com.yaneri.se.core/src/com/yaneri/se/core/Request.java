package com.yaneri.se.core;

public class Request {
	
	final Object header;
	
	final Object request;
	
	final Object input;

	public Request(Object header, Object request, Object input) {
		this.header = header;
		this.request = request;
		this.input = input;
	}
	
	@SuppressWarnings("unchecked")
	public <H> H getHeader() {
		return (H) header;
	}

	@SuppressWarnings("unchecked")
	public <T> T getRequest() {
		return (T) request;
	}

	@SuppressWarnings("unchecked")
	public <V> V getInput() {
		return (V) input;
	}
}
