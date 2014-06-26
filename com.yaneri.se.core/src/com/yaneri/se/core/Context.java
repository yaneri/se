package com.yaneri.se.core;

import java.util.Map;

public interface Context {
	
	public String id();
	
	public Context model(String key, String value);
	
	public Context models(Map<String, Object> map);

	public Object model(String key);
	
	public void dispatcher(Dispatcher dispatcher);
	
	public Dispatcher dispatcher();
	
	public State state();
	
	public void state(State state);
}
