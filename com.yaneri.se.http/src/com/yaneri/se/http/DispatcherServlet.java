package com.yaneri.se.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = -653515091852509244L;

	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected final void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}

	protected final void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}

	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}
}
