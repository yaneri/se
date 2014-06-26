package com.yaneri.se.channel;

import java.util.Locale;

import com.yaneri.se.core.Context;

public interface ChannelContext {
	
	Request request();

	Response response();
	
	Locale locale();
	
	<T>void requestPayload(T payload);
	
	<T>T requestPayload();
	
	<V>void responsePayload(V payload);
	
	<V>V responsePayload();
	
	Context context();
}
