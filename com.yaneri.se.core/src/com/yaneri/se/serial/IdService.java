package com.yaneri.se.serial;

public interface IdService<T> {
	T generate();
	T[] generate(int n);
}
