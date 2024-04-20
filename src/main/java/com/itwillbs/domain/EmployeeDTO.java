package com.itwillbs.domain;

import java.sql.Timestamp;

public class EmployeeDTO {
	
	private int emp_num; //번호
	private String emp_pw; //비밀번호
	private String emp_name; //이름
	private String emp_phone; //연락처
	private String emp_email; //이메일
	private String emp_birth; //생년월일
	private int emp_state; //상태(재직=0,휴직=1,퇴직=2)
	private int emp_dept; //부서(인사부, 영업부, 재무부)
	private int emp_rank; //직급(대표, 팀장, 대리, 사원)
	private int emp_right; //권한(일반=0, 관리자=1)
	private String hire_date; //입사일
	private Timestamp quit_date; //퇴사일
	private String emp_note; //사원 적요
	
	public String getEmp_note() {
		return emp_note;
	}
	public void setEmp_note(String emp_note) {
		this.emp_note = emp_note;
	}
	public int getEmp_num() {
		return emp_num;
	}
	public void setEmp_num(int emp_num) {
		this.emp_num = emp_num;
	}
	public String getEmp_pw() {
		return emp_pw;
	}
	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_birth() {
		return emp_birth;
	}
	public void setEmp_birth(String emp_birth) {
		this.emp_birth = emp_birth;
	}
	public int getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(int emp_state) {
		this.emp_state = emp_state;
	}

	public int getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(int emp_dept) {
		this.emp_dept = emp_dept;
	}
	public int getEmp_rank() {
		return emp_rank;
	}
	public void setEmp_rank(int emp_rank) {
		this.emp_rank = emp_rank;
	}
	public int getEmp_right() {
		return emp_right;
	}
	public void setEmp_right(int emp_right) {
		this.emp_right = emp_right;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public Timestamp getQuit_date() {
		return quit_date;
	}
	public void setQuit_date(Timestamp quit_date) {
		this.quit_date = quit_date;
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
