package com.itwillbs.domain;


public class ResultDTO {

	private int rs_num;// 실적 번호
	private int num;// 지점번호
	private int prod_num;// 상품번호
	private int item_num;// 재료번호
	private int stock_num;// 재고번호
	private String rs_date; // 영업일

	private String rs_minDate; // 영업일
	private String rs_maxDate; // 영업일
	private int sales;// 판매량
	private int consume;// 소모량
	private int consumeBefore;// 소모량
	private String item_name; // 재료명
	private int item_type; // 재료유형
	private int item_price; // 단가
	private int maechul; // 판매량 * 판매가 = 매출
	private int jichul; // 소모량 * 단가 = 소모가
	private int income; // 매출 - 소모가 = 순수익
	private String prod_name; // 상품명
	private int prod_price; // 판매가
	private int prod_type; //상품 유형

	
	@Override
	public String toString() {
		return "ResultDTO [rs_num=" + rs_num + ", num=" + num + ", prod_num=" + prod_num + ", item_num=" + item_num
				+ ", stock_num=" + stock_num + ", rs_date=" + rs_date + ", rs_minDate=" + rs_minDate + ", rs_maxDate="
				+ rs_maxDate + ", sales=" + sales + ", consume=" + consume + ", consumeBefore=" + consumeBefore
				+ ", item_name=" + item_name + ", item_type=" + item_type + ", item_price=" + item_price + ", maechul="
				+ maechul + ", jichul=" + jichul + ", income=" + income + ", prod_name=" + prod_name + ", prod_price="
				+ prod_price + ", prod_type=" + prod_type + ", pageSize=" + pageSize + ", pageNum=" + pageNum
				+ ", currentPage=" + currentPage + ", startRow=" + startRow + ", endRow=" + endRow + ", pageBlock="
				+ pageBlock + ", startPage=" + startPage + ", endPage=" + endPage + ", count=" + count + ", pageCount="
				+ pageCount + "]";
	}



	public int getRs_num() {
		return rs_num;
	}
	public void setRs_num(int rs_num) {
		this.rs_num = rs_num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getStock_num() {
		return stock_num;
	}
	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}
	public String getRs_date() {
		return rs_date;
	}
	public void setRs_date(String rs_date) {
		this.rs_date = rs_date;
	}

	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getConsume() {
		return consume;
	}
	public void setConsume(int consume) {
		this.consume = consume;
	}
	public int getConsumeBefore() {
		return consumeBefore;
	}
	public void setConsumeBefore(int consumeBefore) {
		this.consumeBefore = consumeBefore;
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
	public int getMaechul() {
		return maechul;
	}
	public void setMaechul(int maechul) {
		this.maechul = maechul;
	}
	public int getJichul() {
		return jichul;
	}
	public void setJichul(int jichul) {
		this.jichul = jichul;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getProd_type() {
		return prod_type;
	}
	public void setProd_type(int prod_type) {
		this.prod_type = prod_type;
	}
	
	
	//==페이징
	
	public String getRs_minDate() {
		return rs_minDate;
	}
	public void setRs_minDate(String rs_minDate) {
		this.rs_minDate = rs_minDate;
	}
	public String getRs_maxDate() {
		return rs_maxDate;
	}
	public void setRs_maxDate(String rs_maxDate) {
		this.rs_maxDate = rs_maxDate;
	}


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
