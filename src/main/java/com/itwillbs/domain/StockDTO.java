package com.itwillbs.domain;

public class StockDTO {
	
	private int stock_num; //물품번호 PK,FK(item테이블 참조)
	private int num; //지점 번호(
	private int item_num;
	private String item_name; //물품명
	private int item_type; //유형
	private int amount; //보유량
	private int amount_min; //보유량 최소범위
	private int amount_max; //보유량 최대범위
	private int item_price; //단가
	private int item_minPrice; //최소 단가
	private int item_maxPrice; //최대 단가
	private String stock_note; //재고 적요
	private int item_state; //재료상태

	
	public int getStock_num() {
		return stock_num;
	}
	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAmount_min() {
		return amount_min;
	}
	public void setAmount_min(int amount_min) {
		this.amount_min = amount_min;
	}
	public int getAmount_max() {
		return amount_max;
	}
	public void setAmount_max(int amount_max) {
		this.amount_max = amount_max;
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
	public String getStock_note() {
		return stock_note;
	}
	public void setStock_note(String stock_note) {
		this.stock_note = stock_note;
	}

	public int getItem_num() {
		return item_num;
	}

	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}

	public int getItem_state() {
		return item_state;
	}
	public void setItem_state(int item_state) {
		this.item_state = item_state;
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
		return "StockDTO [stock_num=" + stock_num + ", num=" + num + ", item_num=" + item_num + ", item_name="
				+ item_name + ", item_type=" + item_type + ", amount=" + amount + ", amount_min=" + amount_min
				+ ", amount_max=" + amount_max + ", item_price=" + item_price + ", item_minPrice=" + item_minPrice
				+ ", item_maxPrice=" + item_maxPrice + ", stock_note=" + stock_note + ", item_state=" + item_state
				+ ", pageSize=" + pageSize + ", pageNum=" + pageNum + ", currentPage=" + currentPage + ", startRow="
				+ startRow + ", endRow=" + endRow + ", pageBlock=" + pageBlock + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", count=" + count + ", pageCount=" + pageCount + "]";
	}



}
