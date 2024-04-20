package com.itwillbs.domain;

public class ShipmentDTO {

	private int od_num; //거래번호
	private int num; //지점번호
	private int item_num; //물품번호
	private int sh_amount; //입고수량
	private String sh_time; //입고일
	private String sh_minTime; // 최소 입고일
	private String sh_maxTime; // 최대 입고일
	private String sh_note; //출하적요
	private int item_price; //단가
	private int item_minPrice; //최소 단가
	private int item_maxPrice; //최대 단가
	private String name; //지졈명
	private String item_name; //재료명
	private int pay; //결제여부
	private int received_not;//입고여부

	
	@Override
	public String toString() {
		return "ShipmentDTO [od_num=" + od_num + ", num=" + num + ", item_num=" + item_num + ", sh_amount=" + sh_amount
				+ ", sh_time=" + sh_time + ", sh_minTime=" + sh_minTime + ", sh_maxTime=" + sh_maxTime + ", sh_note="
				+ sh_note + ", item_price=" + item_price + ", item_minPrice=" + item_minPrice + ", item_maxPrice="
				+ item_maxPrice + ", name=" + name + ", item_name=" + item_name + ", pay=" + pay + ", received_not="
				+ received_not + ", pageSize=" + pageSize + ", pageNum=" + pageNum + ", currentPage=" + currentPage
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", pageBlock=" + pageBlock + ", startPage="
				+ startPage + ", endPage=" + endPage + ", count=" + count + ", pageCount=" + pageCount + "]";
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
	public int getSh_amount() {
		return sh_amount;
	}
	public void setSh_amount(int sh_amount) {
		this.sh_amount = sh_amount;
	}
	public String getSh_time() {
		return sh_time;
	}
	public void setSh_time(String sh_time) {
		this.sh_time = sh_time;
	}
	public String getSh_minTime() {
		return sh_minTime;
	}
	public void setSh_minTime(String sh_minTime) {
		this.sh_minTime = sh_minTime;
	}
	public String getSh_maxTime() {
		return sh_maxTime;
	}
	public void setSh_maxTime(String sh_maxTime) {
		this.sh_maxTime = sh_maxTime;
	}
	public String getSh_note() {
		return sh_note;
	}
	public void setSh_note(String sh_note) {
		this.sh_note = sh_note;
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
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getReceived_not() {
		return received_not;
	}
	public void setReceived_not(int received_not) {
		this.received_not = received_not;
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
