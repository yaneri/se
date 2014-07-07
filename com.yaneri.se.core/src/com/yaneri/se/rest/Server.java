package com.yaneri.se.rest;

public interface Server {
	public Server get(String path, Handler hand) throws Exception;

	public Server post(String path, Handler hand) throws Exception;

	public Server put(String path, Handler hand) throws Exception;

	public Server del(String path, Handler hand) throws Exception;

	public Server upd(String path, Handler hand) throws Exception;
}
