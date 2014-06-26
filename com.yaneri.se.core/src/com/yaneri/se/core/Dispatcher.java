package com.yaneri.se.core;

public interface Dispatcher {
	
	void dispatch(Context context) throws Exception;

	void forward(String id, Context context) throws Exception;
}