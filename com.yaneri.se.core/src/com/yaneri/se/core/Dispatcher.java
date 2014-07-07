package com.yaneri.se.core;

public interface Dispatcher {
	
	public void dispatch(Context context) throws Exception;

	public void forward(String id, Context context) throws Exception;
}