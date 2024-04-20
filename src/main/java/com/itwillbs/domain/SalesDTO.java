package com.itwillbs.domain;

import java.sql.Timestamp;

public class SalesDTO {

	private int num; //지점번호
	private String name; //지점명
	private int maechul; //매출
	private Timestamp rs_date; //영업일

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaechul() {
		return maechul;
	}
	public void setMaechul(int maechul) {
		this.maechul = maechul;
	}
	public Timestamp getRs_date() {
		return rs_date;
	}
	public void setRs_date(Timestamp rs_date) {
		this.rs_date = rs_date;
	}
	
	
} // class SalesDTO