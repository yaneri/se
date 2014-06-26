package com.yaneri.se.channel;

public class Response {
	
	final Object response;
	final Object output;

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
}
