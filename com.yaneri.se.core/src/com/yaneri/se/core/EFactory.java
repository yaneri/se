package com.yaneri.se.core;

import com.yaneri.se.core.impl.ContextImpl;

public class EFactory {
	
	public static Context getContext() {
		return new ContextImpl();
	}
}
