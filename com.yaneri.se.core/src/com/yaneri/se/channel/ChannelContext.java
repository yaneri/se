package com.yaneri.se.channel;

import java.util.Locale;

import com.yaneri.se.core.Context;
import com.yaneri.se.core.Request;
import com.yaneri.se.core.Response;

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
