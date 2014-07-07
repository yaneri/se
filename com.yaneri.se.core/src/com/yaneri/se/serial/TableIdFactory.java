package com.yaneri.se.serial;

public class TableIdFactory<T> extends IdFactory<T> {
	int step;
	String table;
	boolean daycut;
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public boolean isDaycut() {
		return daycut;
	}
	public void setDaycut(boolean daycut) {
		this.daycut = daycut;
	}
	
}
