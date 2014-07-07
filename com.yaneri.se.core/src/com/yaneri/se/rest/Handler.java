package com.yaneri.se.rest;

import com.yaneri.se.core.Request;
import com.yaneri.se.core.Response;

public interface Handler {
	public void handle(Request req, Response res);
}
