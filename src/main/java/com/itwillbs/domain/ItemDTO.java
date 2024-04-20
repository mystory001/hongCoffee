package com.itwillbs.domain;

public class ItemDTO {

	private int item_num; //재료 번호 PK, AUTO_INCREMENT
	private String item_name; //재료명
	private int item_type; //유형
	private int item_price; //단가
	private int item_minPrice; //최소 단가
	private int item_maxPrice; //최대 단가
	private int item_state; //재료 상태
	private String item_note; //물품 적요
	
	
	@Override
	public String toString() {
		return "ItemDTO [item_num=" + item_num + ", item_name=" + item_name + ", item_type=" + item_type
				+ ", item_price=" + item_price + ", item_minPrice=" + item_minPrice + ", item_maxPrice=" + item_maxPrice
				+ ", item_state=" + item_state + ", item_note=" + item_note + "]";
	}
	
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_type() {
		return item_type;
	}
	public void setItem_type(int item_type) {
		this.item_type = item_type;
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
	public int getItem_state() {
		return item_state;
	}
	public void setItem_state(int item_state) {
		this.item_state = item_state;
	}
	public String getItem_note() {
		return item_note;
	}
	public void setItem_note(String item_note) {
		this.item_note = item_note;
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
