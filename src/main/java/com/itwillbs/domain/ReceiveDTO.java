package com.itwillbs.domain;

import java.sql.Timestamp;

public class ReceiveDTO {

	private int od_num; //거래번호
	private int num; //지점번호
	private int item_num; //물품번호
	private int rc_amount; //입고수량
	private int rc_amountBefore; //입고 수정 전 수량
	private Timestamp rc_time; //입고일시
	private String rc_minTime; //입고일시 최소범위
	private String rc_maxTime; //입고일시 최대범위
	private String rc_note; //입고적요
	private String sh_note; //출하적요
	private int pay; //결제여부
	private int item_price; //단가
	private int item_minPrice; //최소 단가
	private int item_maxPrice; //최대 단가
	private String name; //지졈명
	private String item_name; //재료명
	private int item_type; //재료유형
	
	

	public int getItem_type() {
		return item_type;
	}
	public void setItem_type(int item_type) {
		this.item_type = item_type;
	}
	public int getOd_num() {
		return od_num;
	}
	public void setOd_num(int od_num) {
		this.od_num = od_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getRc_amount() {
		return rc_amount;
	}
	public void setRc_amount(int rc_amount) {
		this.rc_amount = rc_amount;
	}
	public int getRc_amountBefore() {
		return rc_amountBefore;
	}

	public void setRc_amountBefore(int rc_amountBefore) {
		this.rc_amountBefore = rc_amountBefore;
	}

	public Timestamp getRc_time() {
		return rc_time;
	}
	public void setRc_time(Timestamp rc_time) {
		this.rc_time = rc_time;
	}
	public String getRc_minTime() {
		return rc_minTime;
	}

	public void setRc_minTime(String rc_minTime) {
		this.rc_minTime = rc_minTime;
	}

	public String getRc_maxTime() {
		return rc_maxTime;
	}

	public void setRc_maxTime(String rc_maxTime) {
		this.rc_maxTime = rc_maxTime;
	}

	public String getRc_note() {
		return rc_note;
	}
	public void setRc_note(String rc_note) {
		this.rc_note = rc_note;
	}
	public String getSh_note() {
		return sh_note;
	}
	public void setSh_note(String sh_note) {
		this.sh_note = sh_note;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getItem_minPrice() {
		return item_minPrice;
	}
	public void setItem_minPrice(int item_minPrice) {
		this.item_minPrice = item_minPrice;
	}
	public int getItem_maxPrice() {
		return item_maxPrice;
	}
	public void setItem_maxPrice(int item_maxPrice) {
		this.item_maxPrice = item_maxPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	//==페이징
	
	private int pageSize;
	private String pageNum;
	private int currentPage;
	
	private int startRow;
	private int endRow;
	
	private int pageBlock;
	private int startPage;
	private int endPage;
	
	private int count;
	private int pageCount;
		
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
	@Override
	public String toString() {
		return "ReceiveDTO [od_num=" + od_num + ", num=" + num + ", item_num=" + item_num + ", rc_amount=" + rc_amount
				+ ", rc_time=" + rc_time + ", rc_minTime=" + rc_minTime + ", rc_maxTime=" + rc_maxTime + ", rc_note="
				+ rc_note + ", sh_note=" + sh_note + ", pay=" + pay + ", item_price=" + item_price + ", item_minPrice="
				+ item_minPrice + ", item_maxPrice=" + item_maxPrice + ", name=" + name + ", item_name=" + item_name
				+ ", item_type=" + item_type + ", pageSize=" + pageSize + ", pageNum=" + pageNum + ", currentPage="
				+ currentPage + ", startRow=" + startRow + ", endRow=" + endRow + ", pageBlock=" + pageBlock
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", count=" + count + ", pageCount=" + pageCount
				+ "]";
	}
	
}
