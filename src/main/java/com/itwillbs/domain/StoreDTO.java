package com.itwillbs.domain;

public class StoreDTO {

	private int num; //지점번호
	private String pw; //지점비밀번호
	private String name; //지점명
	private String boss; //점주명
	private String phone; //연락처
	private String tel; //전화번호
	private String email; //이메일
	private String address; //주소
	private int postalcode; //우편번호
	private String note; //적요
	private int state; //상태(정상영업=0, 미영업=1, 폐업=2 미설정=3)
	private String address_detail; //상세주소
	
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	//==
	
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
		return "StoreDTO [num=" + num + ", pw=" + pw + ", name=" + name + ", boss=" + boss + ", phone=" + phone
				+ ", tel=" + tel + ", email=" + email + ", address=" + address + ", postalcode=" + postalcode
				+ ", note=" + note + ", state=" + state + ", address_detail=" + address_detail + ", pageSize="
				+ pageSize + ", pageNum=" + pageNum + ", currentPage=" + currentPage + ", startRow=" + startRow
				+ ", endRow=" + endRow + ", pageBlock=" + pageBlock + ", startPage=" + startPage + ", endPage="
				+ endPage + ", count=" + count + ", pageCount=" + pageCount + "]";
	}
	
	
	
}
