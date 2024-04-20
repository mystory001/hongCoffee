package com.itwillbs.domain;


public class NowDTO {
	
	private int year;
	private int month;
	private int date;
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "NowDTO [year=" + year + ", month=" + month + ", date=" + date + "]";
	}
	
	
}