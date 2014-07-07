package com.yaneri.se.serial;

public class IdFactory<T> implements IdService<T> {
	
	private String name;
	private String format;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public T generate() {
		return null;
	}
	
	public T[] generate(int n) {
		return null;
	}
}
