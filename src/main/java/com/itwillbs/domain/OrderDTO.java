package com.itwillbs.domain;

import java.sql.Timestamp;

public class OrderDTO {
	
	private int od_num; //거래 번호
	private int num; //지점 번호
	private int item_num; //재료 번호
	private int od_amount; //발주량/수주량


	private String od_time; //발주일시
	private String od_minTime; //최소 발주일시
	private String od_maxTime; //최대 발주일시

	private int shipment_not; //출하여부
	private int received_not; //입고여부
	private String od_note; //발주적요
	private String ob_note; //수주적요
	private String name; //지점명
	private String item_name; //재료명
	private int item_price; //단가
	private int item_minPrice; //최소 단가
	private int item_maxPrice; //최대 단가
	private int item_type; //재료유형


	@Override
	public String toString() {
		return "OrderDTO [od_num=" + od_num + ", num=" + num + ", item_num=" + item_num + ", od_amount=" + od_amount
				+ ", od_time=" + od_time + ", od_minTime=" + od_minTime + ", od_maxTime=" + od_maxTime
				+ ", shipment_not=" + shipment_not + ", received_not=" + received_not + ", od_note=" + od_note
				+ ", ob_note=" + ob_note + ", name=" + name + ", item_name=" + item_name + ", item_price=" + item_price
				+ ", item_minPrice=" + item_minPrice + ", item_maxPrice=" + item_maxPrice + ", item_type=" + item_type
				+ ", pageSize=" + pageSize + ", pageNum=" + pageNum + ", currentPage=" + currentPage + ", startRow="
				+ startRow + ", endRow=" + endRow + ", pageBlock=" + pageBlock + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", count=" + count + ", pageCount=" + pageCount + "]";
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
	public int getOd_amount() {
		return od_amount;
	}
	public void setOd_amount(int od_amount) {
		this.od_amount = od_amount;
	}
	public String getOd_time() {
		return od_time;
	}
	public void setOd_time(String od_time) {
		this.od_time = od_time;
	}
	public String getOd_minTime() {
		return od_minTime;
	}

	public void setOd_minTime(String od_minTime) {
		this.od_minTime = od_minTime;
	}
	public String getOd_maxTime() {
		return od_maxTime;
	}
	public void setOd_maxTime(String od_maxTime) {
		this.od_maxTime = od_maxTime;
	}
	public int getShipment_not() {
		return shipment_not;
	}
	public void setShipment_not(int shipment_not) {
		this.shipment_not = shipment_not;
	}

	public int getReceived_not() {
		return received_not;
	}
	public void setReceived_not(int received_not) {
		this.received_not = received_not;
	}
	public String getOd_note() {
		return od_note;
	}
	public void setOd_note(String od_note) {
		this.od_note = od_note;
	}
	public String getOb_note() {
		return ob_note;
	}
	public void setOb_note(String ob_note) {
		this.ob_note = ob_note;
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
	public int getItem_type() {
		return item_type;
	}
	public void setItem_type(int item_type) {
		this.item_type = item_type;
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


	
}