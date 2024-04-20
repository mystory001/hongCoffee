package com.itwillbs.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.ResultDTO;
import com.itwillbs.domain.StockDTO;
import com.itwillbs.domain.StoreDTO;
import com.itwillbs.service.StoreService;

@Controller
@RequestMapping("/store/*")
public class StoreController {

	@Inject
	private StoreService storeService;

	// 로그인 주소매핑
	@GetMapping("/login")
	public String login() {
		System.out.println("StoreController login()");

		return "store/login";
	}

	// 로그인 버튼을 눌렀을 때 처리 과정
	@PostMapping("/loginPro")
	public String loginPro(StoreDTO storeDTO, HttpSession session) {
		System.out.println("StoreController loginPro()");

		StoreDTO storeDTO1 = storeService.userCheck(storeDTO);
		if (storeDTO1 != null) {
			session.setAttribute("num", storeDTO1.getNum());
			session.setAttribute("sname", storeDTO1.getName());
			session.setAttribute("boss", storeDTO1.getBoss());
			session.setAttribute("state", storeDTO1.getState());
			return "redirect:/store/main";
		} else {
			return "/store/msg";
		}
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("StoreController logout()");
		session.invalidate();
		return "redirect:/store/login";
	}

	// 1. 대시 보드
	@GetMapping("/main")
	public String main() {
		System.out.println("StoreController main()");

		return "store/main";

	}

	//1-1. 13일의 금요일 제이슨
	@GetMapping("/mainJson")
	public ResponseEntity<List<StockDTO>> mainJson(HttpSession session) {
		System.out.println("StoreController mainJson");
		int num = (int)session.getAttribute("num");
		List<StockDTO> stockList = storeService.getStock6(num);
		ResponseEntity<List<StockDTO>> entity = new ResponseEntity<List<StockDTO>>(stockList, HttpStatus.OK);
		return entity;
	}

	//1-2. 홍현희 남편 제이슨
	@GetMapping("/mainJson2")
	public ResponseEntity<List<ResultDTO>> mainJson2(HttpSession session) {
		System.out.println("StoreController mainJson2");
		int num = (int)session.getAttribute("num");
		List<ResultDTO> resultList = storeService.getResultMain(num);
		ResponseEntity<List<ResultDTO>> entity = new ResponseEntity<List<ResultDTO>>(resultList, HttpStatus.OK);
		return entity;
	}

	// 2. 기준 정보 관리 - 재료 관리
		@GetMapping("/store/item")
		public String item(HttpServletRequest request, Model model,PageDTO pageDTO) {
		System.out.println("StoreController item()");
			
		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
			
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getItemCount(pageDTO) 검색어 포함
		int count = storeService.getItemCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
					
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
								
		List<ItemDTO> itemList = storeService.getItemList(pageDTO);
		model.addAttribute("itemList", itemList);
		model.addAttribute("pageDTO",pageDTO);
			
		return "store/item";
		}// itemList

		// 2-1. 재료 필터링
		@GetMapping("/itemSearch")
		public String itemSearch(HttpServletRequest request, Model model,PageDTO pageDTO) {
		System.out.println("StoreController itemSearch()");
		ItemDTO itemDTO = new ItemDTO();

		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
					
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getItemCount(itemDTO) 검색어 포함
		int count = storeService.getItemCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
			// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		//필터 작업
			
		String item_sType = request.getParameter("item_type");
		int item_type = 100;

		try {
			if (item_sType != null || item_sType != "") {
				item_type = Integer.parseInt(item_sType);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		itemDTO.setItem_type(item_type);

		String item_name = request.getParameter("item_name");
		itemDTO.setItem_name(item_name);

		String item_sminPrice = request.getParameter("item_minPrice");
		int item_minPrice = 0;
		String item_smaxPrice = request.getParameter("item_maxPrice");
		int item_maxPrice = 0;

		try {
			if (item_sminPrice != null || item_sminPrice != "") {
				item_minPrice = Integer.parseInt(item_sminPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			if (item_smaxPrice != null || item_smaxPrice != "") {
				item_maxPrice = Integer.parseInt(item_smaxPrice);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		itemDTO.setItem_minPrice(item_minPrice);
		itemDTO.setItem_maxPrice(item_maxPrice);
		
		int item_state = Integer.parseInt(request.getParameter("item_state"));
		itemDTO.setItem_state(item_state);
			
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getItemCount(itemDTO) 검색어 포함
		count = storeService.getItemCount(itemDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		//필터 페이징 itemDTO 저장
		itemDTO.setPageSize(pageSize);
		itemDTO.setPageNum(pageNum);
		itemDTO.setCurrentPage(currentPage);
		itemDTO.setCount(count);
		itemDTO.setPageBlock(pageBlock);
		itemDTO.setStartPage(startPage);
		itemDTO.setEndPage(endPage);
		itemDTO.setPageCount(pageCount);
					
		List<ItemDTO> itemList;

		if (item_type == 100 && item_name == null && item_minPrice == 0 && item_maxPrice == 0 && item_state == 100) {
			itemList = storeService.getItemList(pageDTO);
		} else {
			itemList = storeService.searchItemList(itemDTO);
			pageDTO.setCount(-1);
			model.addAttribute("itemDTO", itemDTO);
		}

		model.addAttribute("itemList", itemList);
		model.addAttribute("pageDTO",pageDTO);
		return "/store/item";
	}// itemSearch

	// 3. 물류 관리
	// 3-1. 재고 관리
	@GetMapping("/stock")
	public String stock(HttpSession session, HttpServletRequest request, Model model,PageDTO pageDTO) {
		System.out.println("StoreController stock()");

		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getStockCount(pageDTO) 검색어 포함
		int count = storeService.getStockCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
			
		List<StockDTO> stockList = storeService.getStockList(pageDTO);


		model.addAttribute("stockList", stockList);

		return "store/stock";
	}// stockList

	// 3-1-1. 재고 관리 필터링

	@GetMapping("/stockSearch")
	public String stockSearch(HttpSession session, HttpServletRequest request, Model model,PageDTO pageDTO) {
		System.out.println("StoreController stockSearch()");
		StockDTO stockDTO = new StockDTO();

		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
				pageNum = "1";
			}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getgetStockCount(pageDTO) 검색어 포함
		int count = storeService.getStockCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		
		//필터 작업
		int item_type = Integer.parseInt(request.getParameter("item_type"));
		String item_name = request.getParameter("item_name");
		String item_minPrice = request.getParameter("item_minPrice");
		String item_maxPrice = request.getParameter("item_maxPrice");
		stockDTO.setItem_type(item_type);
		stockDTO.setItem_name(item_name);
		try {
			stockDTO.setItem_minPrice(Integer.parseInt(item_minPrice));
			stockDTO.setItem_maxPrice(Integer.parseInt(item_maxPrice));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		stockDTO.setNum((int)session.getAttribute("num"));
		
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getStockCount(resultDTO) 검색어 포함
		count = storeService.getStockCount(stockDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
				
		//필터 페이징 stockDTO 저장
		stockDTO.setPageSize(pageSize);
		stockDTO.setPageNum(pageNum);
		stockDTO.setCurrentPage(currentPage);
		stockDTO.setCount(count);
		stockDTO.setPageBlock(pageBlock);
		stockDTO.setStartPage(startPage);
		stockDTO.setEndPage(endPage);
		stockDTO.setPageCount(pageCount);
		
		List<StockDTO> stockList;

		if (item_type == 100 && item_name == "" && item_minPrice == "" && item_maxPrice == "") {
			stockList = storeService.getStockList(pageDTO);
		} else {
			stockList = storeService.searchStockList(stockDTO);
			pageDTO.setCount(-1);
			model.addAttribute("stockDTO", stockDTO);
		}

		model.addAttribute("stockList", stockList);
		model.addAttribute("pageDTO", pageDTO);
		return "/store/stock";
	}// stockSearchList

	// 3-1-2 재고 관리 - 추가
	@GetMapping("/popup/stock_insert")
	public String stock_insert() {
		System.out.println("StoreController stock_insert()");

		return "/store/popup/stock_insert";
	}

	@PostMapping("/popup/stock_insertPro")
	public String stock_insertPro(StockDTO stockDTO) {
		System.out.println("StoreController stock_insertPro()");

		int item_num = storeService.getItemNum(stockDTO.getItem_name());
		stockDTO.setItem_num(item_num);
		storeService.stockInsert(stockDTO);

		return "/store/popup/close";
	}

	// 3-1-2 재고 관리 - 수정
	@GetMapping("/popup/stock_update")
	public String stock_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController stock_update()");

		int stock_num = Integer.parseInt(request.getParameter("stock_num"));
		StockDTO stockDTO = new StockDTO();
		stockDTO = storeService.getStock(stock_num);
		model.addAttribute("stockDTO", stockDTO);

		return "/store/popup/stock_update";
	}

	@PostMapping("/popup/stock_updatePro")
	public String stock_updatePro(HttpServletRequest request){
		System.out.println("StoreController stock_updatePro");

		StockDTO stockDTO = new StockDTO();
		stockDTO.setStock_num(Integer.parseInt(request.getParameter("stock_num")));
		stockDTO.setAmount(Integer.parseInt(request.getParameter("amount")));
		stockDTO.setStock_note(request.getParameter("stock_note"));

		storeService.stockUpdate(stockDTO);

		return "/store/popup/close";
	}

	// 3-2. 발주 관리
	@GetMapping("/order")
	public String order(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("StoreController order()");
		
		// 페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getOrderCount(pageDTO) 검색어 포함
		int count = storeService.getOrderCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
				endPage = pageCount;
		}
				
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
				
		List<OrderDTO> orderList = storeService.getOrderList(pageDTO);

		model.addAttribute("orderList", orderList);
		model.addAttribute("pageDTO", pageDTO);

		return "store/order";
	}// orderList

	// 3-2-1. 발주 필터링
	@GetMapping("/orderSearch")
	public String orderSearch(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) throws Exception {
		System.out.println("StoreController orderSearch()");
		OrderDTO orderDTO = new OrderDTO();

		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getStoreCount(pageDTO) 검색어 포함
		int count = storeService.getOrderCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
				
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		//필터 작업
		String item_name = request.getParameter("item_name");
		orderDTO.setItem_name(item_name);

		String item_sminPrice = request.getParameter("item_minPrice");
		String item_smaxPrice = request.getParameter("item_maxPrice");

		try {
			orderDTO.setItem_minPrice(item_sminPrice != null ? Integer.parseInt(item_sminPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			orderDTO.setItem_maxPrice(item_smaxPrice != null ? Integer.parseInt(item_smaxPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String od_minTime = request.getParameter("od_minTime");
		String od_maxTime = request.getParameter("od_maxTime");
//		if (od_time != "") {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date d1 = format.parse(od_time);
//			Timestamp date1 = new Timestamp(d1.getTime());
//			orderDTO.setOd_time(date1);
//		}
		orderDTO.setOd_minTime(od_minTime);
		orderDTO.setOd_maxTime(od_maxTime);


		int received_not = Integer.parseInt(request.getParameter("received_not"));
		orderDTO.setReceived_not(received_not);
		orderDTO.setNum((int)session.getAttribute("num"));
		
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getItemCount(orderDTO) 검색어 포함
		count = storeService.getOrderCount(orderDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		//필터 페이징 orderDTO 저장
		orderDTO.setPageSize(pageSize);
		orderDTO.setPageNum(pageNum);
		orderDTO.setCurrentPage(currentPage);
		orderDTO.setCount(count);
		orderDTO.setPageBlock(pageBlock);
		orderDTO.setStartPage(startPage);
		orderDTO.setEndPage(endPage);
		orderDTO.setPageCount(pageCount);
		
		
		List<OrderDTO> orderList;
		
		if (item_name == "" && item_sminPrice == null && item_smaxPrice == null && od_minTime == ""
				&& od_maxTime == "" && received_not == 100) {
			orderList = storeService.getOrderList(pageDTO);
		} else {
			orderList = storeService.searchOrderList(orderDTO);
			pageDTO.setCount(-1);
			model.addAttribute("orderDTO", orderDTO);
		}

		model.addAttribute("orderList", orderList);
		model.addAttribute("pageDTO", pageDTO);
		return "/store/order";
	}// orderSearchList

	// 3-3. 입고 관리
	@GetMapping("/receive")
	public String receive(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("StoreController receive()");
        
		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getStockCount(pageDTO) 검색어 포함
		int count = storeService.getReceiveCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
						
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);		
		
		List<ReceiveDTO> receiveList = storeService.getReceiveList(pageDTO);

		model.addAttribute("receiveList", receiveList);
		model.addAttribute("pageDTO", pageDTO);

		return "store/receive";

	}// receiveList

	// 3-3-1. 입고 필터링

	@GetMapping("/receiveSearch")
	public String receiveSearch(HttpSession session, HttpServletRequest request, Model model,PageDTO pageDTO) throws Exception {
		System.out.println("StoreController receiveSearch()");
		ReceiveDTO receiveDTO = new ReceiveDTO();
        
		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
				pageNum = "1";
			}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getReceiveCount(pageDTO) 검색어 포함
		int count = storeService.getReceiveCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		
		// 필터링
		String item_name = request.getParameter("item_name");
		receiveDTO.setItem_name(item_name);
		String item_sminPrice = request.getParameter("item_minPrice");
		String item_smaxPrice = request.getParameter("item_maxPrice");

		try {
			receiveDTO.setItem_minPrice(item_sminPrice != null ? Integer.parseInt(item_sminPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			receiveDTO.setItem_maxPrice(item_smaxPrice != null ? Integer.parseInt(item_smaxPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String rc_minTime = request.getParameter("rc_minTime");
		String rc_maxTime = request.getParameter("rc_maxTime");
		receiveDTO.setRc_minTime(rc_minTime);
		receiveDTO.setRc_maxTime(rc_maxTime);
		
		int pay = Integer.parseInt(request.getParameter("pay"));
		receiveDTO.setPay(pay);
		
		receiveDTO.setNum((int)session.getAttribute("num"));

		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getReceiveCount(receiveDTO) 검색어 포함
		count = storeService.getReceiveCount(receiveDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		//필터 페이징 receiveDTO 저장
		receiveDTO.setPageSize(pageSize);
		receiveDTO.setPageNum(pageNum);
		receiveDTO.setCurrentPage(currentPage);
		receiveDTO.setCount(count);
		receiveDTO.setPageBlock(pageBlock);
		receiveDTO.setStartPage(startPage);
		receiveDTO.setEndPage(endPage);
		receiveDTO.setPageCount(pageCount);
		
		List<ReceiveDTO> receiveList;

		if (item_name == "" && item_sminPrice == "" && item_smaxPrice == "" && rc_minTime == "" && rc_maxTime == "" && pay == 100) {
			receiveList = storeService.getReceiveList(pageDTO);
		} else {
			receiveList = storeService.searchReceiveList(receiveDTO);
			pageDTO.setCount(-1);
			model.addAttribute("receiveDTO", receiveDTO);
		}

		model.addAttribute("receiveList", receiveList);
		model.addAttribute("pageDTO", pageDTO);

		return "/store/receive";
	}// receiveSearchList

	// 3-3-1. 물류 관리 - 입고 추가
	@GetMapping("/popup/receive_insert")
	public String receive_insert(HttpServletRequest request, Model model) {
		System.out.println("StoreController  receive_insert");

		int od_num = Integer.parseInt(request.getParameter("od_num"));
		model.addAttribute("orderDTO", storeService.getOrder(od_num));

		return "store/popup/receive_insert";
	}// receive_insert

	@PostMapping("/popup/receive_insertPro")
	public String receive_insertPro(ReceiveDTO receiveDTO) {
		System.out.println("StoreController receive_insertPro");

		receiveDTO.setItem_num(storeService.getItemNum(receiveDTO.getItem_name()));
		storeService.receiveInsert(receiveDTO);

		return "store/popup/close";
	}// receive_insertPro

	// 3-2-1. 물류 관리 - 발주 추가
	@GetMapping("/popup/order_insert")
	public String order_insert() {
		System.out.println("StoreController order_insert()");

		return "store/popup/order_insert";
	}

	@PostMapping("/popup/order_insertPro")
	public String order_insertPro(OrderDTO orderDTO) {
		System.out.println("StoreController order_insertPro()");

		int item_num = storeService.getItemNum(orderDTO.getItem_name());
		orderDTO.setItem_num(item_num);
		storeService.orderInsert(orderDTO);

		return "store/popup/close";
	}

	// 3-2-2. 물류 관리 - 발주 수정
	@GetMapping("/popup/order_update")
	public String order_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController order_update()");

		int od_num = Integer.parseInt(request.getParameter("od_num"));
		model.addAttribute("orderDTO", storeService.getOrder(od_num));

		return "store/popup/order_update";
	}

	// 3-2-2. 물류 관리 - 발주 수정
	@GetMapping("/popup/order_delete")
	public String order_delete(HttpServletRequest request, Model model) {
		System.out.println("StoreController order_delete()");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		storeService.orderDelete(od_num);
		return "redirect:/store/order";
	}

	@PostMapping("/popup/order_updatePro")
	public String order_updatePro(OrderDTO orderDTO) {
		System.out.println("StoreController order_updatePro()");

		storeService.orderUpdate(orderDTO);

		return "store/popup/close";
	}

	// 3-3-1 입고 관리 - 수정
	@GetMapping("/popup/receive_update")
	public String receive_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController receive_update()");

		int od_num = Integer.parseInt(request.getParameter("od_num"));
		model.addAttribute("receiveDTO", storeService.getReceive(od_num));

		return "store/popup/receive_update";
	}

	@PostMapping("/popup/receive_updatePro")
	public String receive_updatePro(ReceiveDTO receiveDTO) {
		System.out.println("StoreController receive_updatePro()");

		storeService.receiveUpdate(receiveDTO);

		return "store/popup/close";
	}

	// 4. 영업 관리
	// 4-1. 실적 관리
	@GetMapping("/result")
	public String result(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("StoreController result()");


		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getResultCount(pageDTO) 검색어 포함
		int count = storeService.getResultCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
							
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);		
				
		List<ResultDTO> resultList = storeService.getResultList(pageDTO);

		model.addAttribute("resultList", resultList);
		model.addAttribute("pageDTO",pageDTO);

		return "store/result";
	}// resultList

	// 4-1-1. 실적 관리 - 실적 추가
	@GetMapping("/popup/result_insert")
	public String result_insert() {
		System.out.println("StoreController result_insert()");

		return "/store/popup/result_insert";
	}

	// 4-1-1. 실적 필터링
	@GetMapping("/resultSearch")
	public String resultSearch(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) throws Exception {
		System.out.println("StoreController resultSearch()");
		ResultDTO resultDTO = new ResultDTO();

		
		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}

		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
					
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getResultCount(pageDTO) 검색어 포함
		int count = storeService.getResultCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		// 필터링
		String rs_minDate = request.getParameter("rs_minDate");
		String rs_maxDate = request.getParameter("rs_maxDate");
		resultDTO.setRs_minDate(rs_minDate);
		resultDTO.setRs_maxDate(rs_maxDate);
			
		resultDTO.setNum((int)session.getAttribute("num"));
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getResultCount(ResultDTO) 검색어 포함
		count = storeService.getResultCount(resultDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
						
		//필터 페이징 resultDTO 저장
		resultDTO.setPageSize(pageSize);
		resultDTO.setPageNum(pageNum);
		resultDTO.setCurrentPage(currentPage);
		resultDTO.setCount(count);
		resultDTO.setPageBlock(pageBlock);
		resultDTO.setStartPage(startPage);
		resultDTO.setEndPage(endPage);
		resultDTO.setPageCount(pageCount);
						
		List<ResultDTO> resultList;

		if (rs_minDate == "" && rs_maxDate == "") {
			resultList = storeService.getResultList(pageDTO);
		} else {
			resultList = storeService.searchResultList(resultDTO);
			pageDTO.setCount(-1);
			model.addAttribute("resultDTO", resultDTO);
		}

		model.addAttribute("resultList", resultList);
		model.addAttribute("PageDTO", pageDTO);

		return "/store/result";
	}// resultSearch

	// 4-2. 소모 관리
	@GetMapping("/store/consume")
	public String consume(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("StoreController consume()");
		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getConsumeCount(pageDTO) 검색어 포함
		int count = storeService.getConsumeCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
						
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);		

		List<ResultDTO> consumeList = storeService.getConsumeList(pageDTO);

		model.addAttribute("consumeList", consumeList);
		model.addAttribute("pageDTO",pageDTO);
		return "store/consume";
	}// somoList

	@GetMapping("/popup/consume_insert")
	public String consume_insert(HttpServletRequest request) {
		System.out.println("StoreController consume_insert()");


		return "/store/popup/consume_insert";
	}

	@PostMapping("/popup/consume_insertPro")
	public String consume_insertPro(HttpServletRequest request) {
		System.out.println("StoreController consume_insertPro()");
		ResultDTO resultDTO = new ResultDTO(); 
		StockDTO stockDTO = new StockDTO();
		stockDTO.setNum(Integer.parseInt(request.getParameter("num")));
		stockDTO.setItem_name(request.getParameter("item_name"));
		int stock_num = storeService.getStockNum(stockDTO); 

		String rs_date = request.getParameter("rs_date");
		//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//		Date d1;
		//		try {
		//			d1 = format.parse(rs_date);
		//		} catch (ParseException e) {
		//			d1 = new Date();
		//		}
		//		Timestamp rdate = new Timestamp(d1.getTime());


		resultDTO.setRs_date(rs_date);
		resultDTO.setNum(Integer.parseInt(request.getParameter("num")));
		resultDTO.setConsume(Integer.parseInt(request.getParameter("consume")));
		resultDTO.setStock_num(stock_num);


		//양을 들고 와야함
		//아는 건 각 테이블의 외래키
		

		int amount = storeService.getAmount(stock_num);
		int consume = resultDTO.getConsume();
		System.out.println("컨슘 나와라 " + consume);
		if(amount < consume) {
			return "/store/popup/msg_error";
		}else {
			storeService.consumeInsert(resultDTO);
			return "store/popup/close";
		}
	}

	@GetMapping("/popup/msg_error")
	public String msg_error() {
		System.out.println("StoreController msg_error()");
		return "/store/popup/msg_error";
	}

	@GetMapping("/popup/consume_update")
	public String consume_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController consume_update()");

		int rs_num = Integer.parseInt(request.getParameter("rs_num"));
		model.addAttribute("resultDTO", storeService.getConsume(rs_num));


		return "/store/popup/consume_update";
	}

	@PostMapping("/popup/consume_updatePro")
	public String consume_updatePro(ResultDTO resultDTO) {
		System.out.println("StoreController consume_updatePro()");

		storeService.consumeUpdate(resultDTO);

		return "store/popup/close";
	}

	// 4-2-1. 소모 필터링

	@GetMapping("/consumeSearch")
	public String consumeSearch(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) throws Exception {
		System.out.println("StoreController consumeSearch()");
		ResultDTO resultDTO = new ResultDTO();
		
		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
				pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
			
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getConsumeCount(pageDTO) 검색어 포함
		int count = storeService.getConsumeCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		// 필터링
		String rs_minDate = request.getParameter("rs_minDate");
		String rs_maxDate = request.getParameter("rs_maxDate");
		resultDTO.setRs_minDate(rs_minDate);
		resultDTO.setRs_maxDate(rs_maxDate);
			
		resultDTO.setNum((int)session.getAttribute("num"));


		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getConsumeCount(resultDTO) 검색어 포함
		count = storeService.getConsumeCount(resultDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
				
		//필터 페이징 stockDTO 저장
		resultDTO.setPageSize(pageSize);
		resultDTO.setPageNum(pageNum);
		resultDTO.setCurrentPage(currentPage);
		resultDTO.setCount(count);
		resultDTO.setPageBlock(pageBlock);
		resultDTO.setStartPage(startPage);
		resultDTO.setEndPage(endPage);
		resultDTO.setPageCount(pageCount);
				
				
//		String rs_date = request.getParameter("rs_date");
//		if (rs_date != "") {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date d2 = format.parse(rs_date);
//			Timestamp date2 = new Timestamp(d2.getTime());
//			resultDTO.setRs_date(rs_date);
//		}

		int num = (int)session.getAttribute("num");
		resultDTO.setNum(num);
		List<ResultDTO> consumeList;

		if (rs_minDate == "" && rs_maxDate == "") {
			consumeList = storeService.getConsumeList(pageDTO);
		} else {
			consumeList = storeService.searchConsumeList(resultDTO);
			pageDTO.setCount(-1);
			model.addAttribute("resultDTO", resultDTO);
		}

		model.addAttribute("consumeList", consumeList);
		model.addAttribute("PageDTO", pageDTO);

		return "/store/consume";
	}// somoSearch

	// 4-3. 판매 관리
	@GetMapping("/sell")

	public String sell(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("StoreController sell()");

		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getSellCount(pageDTO) 검색어 포함
		int count = storeService.getSellCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
							
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);		
	
		List<ResultDTO> sellList = storeService.getSellList(pageDTO);


		System.out.println(sellList);
		model.addAttribute("sellList", sellList);
		model.addAttribute("pageDTO",pageDTO);

		return "store/sell";
	}// panmeList

	// 4-3-.1 판매 필터링
	@GetMapping("/sellSearch")

	public String sellSearch(HttpSession session, HttpServletRequest request, Model model, PageDTO pageDTO) throws Exception {
		System.out.println("StoreController sellSearch()");
		ResultDTO resultDTO = new ResultDTO();

		
		//===========페이징
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
				pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setNum((int)session.getAttribute("num"));
			
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getSellCount(pageDTO) 검색어 포함
		int count = storeService.getSellCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 10;
		// 한 화면에 보여줄 시작페이지 구하기
		// 1~10 => 1, 11~20 => 11,..
		int startPage = (currentPage - 1)/pageBlock * pageBlock + 1;
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 페이지개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		// pageDTO 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		// 필터링
		String rs_minDate = request.getParameter("rs_minDate");
		String rs_maxDate = request.getParameter("rs_maxDate");
		resultDTO.setRs_minDate(rs_minDate);
		resultDTO.setRs_maxDate(rs_maxDate);
			
		resultDTO.setNum((int)session.getAttribute("num"));
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getConsumeCount(resultDTO) 검색어 포함
		count = storeService.getConsumeCount(resultDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
				
		//필터 페이징 stockDTO 저장
		resultDTO.setPageSize(pageSize);
		resultDTO.setPageNum(pageNum);
		resultDTO.setCurrentPage(currentPage);
		resultDTO.setCount(count);
		resultDTO.setPageBlock(pageBlock);
		resultDTO.setStartPage(startPage);
		resultDTO.setEndPage(endPage);
		resultDTO.setPageCount(pageCount);
				

		List<ResultDTO> sellList;


		if (rs_minDate == "" && rs_maxDate == "") {
			sellList = storeService.getSellList(pageDTO);
		} else {
			sellList = storeService.searchSellList(resultDTO);
			pageDTO.setCount(-1);
			model.addAttribute("resultDTO", resultDTO);
		}

		model.addAttribute("sellList", sellList);
		model.addAttribute("PageDTO", pageDTO);

		return "/store/sell";
	}// panmeSearch

	@GetMapping("popup/sell_insert")
	public String sell_insert(HttpServletRequest request, Model model) {
		System.out.println("StoreController sell_insert()");


		return "/store/popup/sell_insert";
	}

	@PostMapping("popup/sell_insertPro")
	public String sell_insertPro(HttpServletRequest request, ResultDTO resultDTO) {
		System.out.println("StoreController sell_insertPro()");

		resultDTO.setNum(Integer.parseInt(request.getParameter("num")));
		resultDTO.setRs_date(request.getParameter("rs_date"));
		resultDTO.setProd_name(request.getParameter("prod_name"));
		resultDTO.setSales(Integer.parseInt(request.getParameter("sales")));
		//		resultDTO.setProd_price(Integer.parseInt(request.getParameter("prod_price")));

		System.out.println(resultDTO);

		storeService.sellInsert(resultDTO);

		return "/store/popup/close";
	}

	@GetMapping("/popup/sell_update")
	public String sell_update(HttpServletRequest request, Model model) {
		System.out.println("StoreController sell_update()");

		int rs_num = Integer.parseInt(request.getParameter("rs_num"));
		model.addAttribute("resultDTO", storeService.getSales(rs_num));

		System.out.println(rs_num);

		return "/store/popup/sell_update";
	}

	@PostMapping("/popup/sell_updatePro")
	public String sell_updatePro(ResultDTO resultDTO) {
		System.out.println("StoreController sell_updatePro()");

		storeService.salesUpdate(resultDTO);

		return "store/popup/close";
	}


	// 창 닫기
	@GetMapping("popup/close")
	public String close() {
		System.out.println("close()");
		return "/emp/popup/close";
	}

	//===============상세
	//재료 상세
	@GetMapping("detail/d_item")
	public String d_item(HttpServletRequest request, Model model) {
		System.out.println("StoreController d_item");
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		ItemDTO itemDTO = storeService.getItem(item_num);
		model.addAttribute("itemDTO", itemDTO);
		return "store/detail/d_item";
	}

	//재고 상세
	@GetMapping("detail/d_stock")
	public String d_stock(HttpServletRequest request, Model model) {
		System.out.println("StoreController d_stock");
		int stock_num = Integer.parseInt(request.getParameter("stock_num"));
		StockDTO stockDTO = storeService.getStock(stock_num);
		model.addAttribute("stockDTO", stockDTO);
		return "store/detail/d_stock";
	}


	//발주 상세
	@GetMapping("detail/d_order")
	public String d_order(HttpServletRequest request, Model model) {
		System.out.println("StoreController d_order");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		OrderDTO orderDTO = storeService.getOrder(od_num);
		model.addAttribute("orderDTO", orderDTO);
		return "store/detail/d_order";
	}

	//입고 상세
	@GetMapping("detail/d_receive")
	public String d_receive(HttpServletRequest request, Model model) {
		System.out.println("StoreController d_receive");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		ReceiveDTO receiveDTO = storeService.getReceive(od_num);
		model.addAttribute("receiveDTO", receiveDTO);
		return "store/detail/d_receive";
	}

	// 3-4 결제
	@GetMapping("/autoPay")
	public void autoPay(HttpSession session) {
		System.out.println("StoreController autoPay");
		storeService.autoPay();
	}

	//		@GetMapping("/check")
	//		public ResponseEntity<List<StockDTO>> check(StockDTO stockDTO) {
	//		    System.out.println("StoreController check()");
	//		    
	//		    List<StockDTO> stockDTOList = storeService.stockCheck(stockDTO.getStock_num());
	//		    
	////		    String result ="";
	////		    if(stockDTOList.isEmpty()) {
	////		        result = "out_of_stock";
	////		    } else {
	////		        result = "재고가 있습니다.";
	////		    }
	//		    ResponseEntity<List<StockDTO>> entity = new ResponseEntity<List<StockDTO>>(stockDTOList, HttpStatus.OK);
	//			return entity;
	//		}


}