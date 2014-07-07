package com.yaneri.se.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public void service(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
