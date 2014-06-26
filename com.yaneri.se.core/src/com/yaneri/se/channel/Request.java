package com.yaneri.se.channel;

public class Request {
	
	final Object request;
	final Object input;

	public Request(Object request, Object input) {
		this.request = request;
		this.input = input;
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
