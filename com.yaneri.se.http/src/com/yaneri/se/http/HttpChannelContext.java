package com.yaneri.se.http;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaneri.se.channel.Request;
import com.yaneri.se.channel.Response;
import com.yaneri.se.channel.impl.ChannelContextImpl;


public class HttpChannelContext extends ChannelContextImpl {

	public HttpChannelContext(HttpServletRequest req, HttpServletResponse res, Locale locale) throws IOException {
		super(new Request(req, req.getInputStream()), new Response(res, res.getOutputStream()), locale);
	}
}
