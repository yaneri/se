package com.yaneri.se.channel.impl;

import java.util.Locale;

import com.yaneri.se.channel.ChannelContext;
import com.yaneri.se.channel.Request;
import com.yaneri.se.channel.Response;
import com.yaneri.se.core.Context;
import com.yaneri.se.core.EFactory;

public class ChannelContextImpl implements ChannelContext {
	
	private Request request;
	
	private Response response;
	
	private Locale locale;

	private Object requestPayload;
	
	private Object responsePayload;
	
	private Context context;
	
	public Request request() {
		return this.request;
	}
	
	public Response response() {
		return this.response;
	}
	
	public Locale locale() {
		return this.locale;
	}
	
	public <T> void requestPayload(T payload) {
		this.requestPayload = payload;
	}

	@SuppressWarnings("unchecked")
	public <T> T requestPayload() {
		return (T) this.requestPayload;
	}

	public <V> void responsePayload(V payload) {
		this.requestPayload = payload;
	}

	@SuppressWarnings("unchecked")
	public <V> V responsePayload() {
		return (V) this.responsePayload;
	}

	@Override
	public Context context() {
		return context;
	}
	
	public ChannelContextImpl(Request req, Response res, Locale locale) {
		this.request = req;
		this.response = res;
		this.locale = locale;
		this.context = EFactory.getContext();
	}
}
