package com.itwillbs.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.SalesDTO;
import com.itwillbs.domain.ShipmentDTO;
import com.itwillbs.domain.StoreDTO;
import com.itwillbs.service.EmployeeService;

@Controller
@RequestMapping("/emp/*")
public class EmployeeController {
	
	@Inject
	private EmployeeService employeeService;

	//0. 로그인 진행 과정
//	@PostMapping("/loginPro")
//	public String loginPro(EmployeeDTO employeeDTO, HttpSession session) {
//		System.out.println("EmployeeService loginPro()");
//		
//		EmployeeDTO employeeDTO1 = employeeService.userCheck(employeeDTO);
//		if (employeeDTO1 != null) {
//			session.setAttribute("emp_num", employeeDTO1.getEmp_num());
//			session.setAttribute("emp_name", employeeDTO1.getEmp_name());
//			session.setAttribute("emp_right", employeeDTO1.getEmp_right());
//			session.setAttribute("emp_rank", employeeDTO1.getEmp_rank());
//			return "redirect:/emp/main";
//		} else {
//			return "/emp/msg";
//		}
//	}

	
	@GetMapping("/login")
	public String login(HttpSession session) {
		System.out.println("EmployeeService login()");
	
		return "/emp/login";
	}

	
	//1. 대시 보드
	@GetMapping("/main")
	public String main(HttpSession session, HttpServletRequest request) {
		System.out.println("EmployeeController main()");
		
		if (request.getParameter("emp_num") != null) {
			int emp_num = Integer.parseInt(request.getParameter("emp_num"));
			
			EmployeeDTO employeeDTO = employeeService.getEmployee(emp_num);
			
			session.setAttribute("emp_num", employeeDTO.getEmp_num());
			session.setAttribute("emp_name", employeeDTO.getEmp_name());
			session.setAttribute("emp_right", employeeDTO.getEmp_right());
			session.setAttribute("emp_rank", employeeDTO.getEmp_rank());
		}
		
		return "/emp/main";
	}

	//1-1. 13일의 금요일 제이슨
		@GetMapping("/mainJson")
		@ResponseBody
		public ResponseEntity<List<SalesDTO>> mainJson() {
			List<SalesDTO> salesList = employeeService.getTop5();
			ResponseEntity<List<SalesDTO>> entity = new ResponseEntity<List<SalesDTO>>(salesList, HttpStatus.OK);
			return entity;
		}
	
	
	//2. 기준 정보 관리
	//2-1. 지점 관리
	@GetMapping("/store")
	public String store(HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("EmployeeController store()");

		
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
		// 전체 글개수 구하기  int 리턴할형 count = getStoreCount(pageDTO) 검색어 포함
		int count = employeeService.getStoreCount(pageDTO);
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
		
		System.out.println(pageDTO);
		
		List<StoreDTO> storeList = employeeService.getStoreList(pageDTO);
	    model.addAttribute("storeList",storeList);
		model.addAttribute("pageDTO",pageDTO);
		
		return "/emp/store";
	}//jijumList
	
	
	//2-1-1. 지점 필터링
	@GetMapping("/storeSearch")
	public String storeSearch(HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("EmployeeController storeSearch()");
		
		StoreDTO storeDTO = new StoreDTO();
		
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
		// 전체 글개수 구하기  int 리턴할형 count = getStoreCount(pageDTO) 검색어 포함
		int count = employeeService.getStoreCount(pageDTO);
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
		String name = request.getParameter("name");
		storeDTO.setName(name);
		
		String boss = request.getParameter("boss");
		storeDTO.setBoss(boss);
		
		String address = request.getParameter("address");
		storeDTO.setAddress(address);
		
		String phone = request.getParameter("phone");
		storeDTO.setPhone(phone);
		
		String sState = request.getParameter("state");
		
		try {
			storeDTO.setState(sState != null ? Integer.parseInt(sState) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getStoreCount(storeDTO) 검색어 포함
		count = employeeService.getStoreCount(storeDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		//필터 페이징 storeDTO 저장
		storeDTO.setPageSize(pageSize);
		storeDTO.setPageNum(pageNum);
		storeDTO.setCurrentPage(currentPage);
		storeDTO.setCount(count);
		storeDTO.setPageBlock(pageBlock);
		storeDTO.setStartPage(startPage);
		storeDTO.setEndPage(endPage);
		storeDTO.setPageCount(pageCount);
		
		
		//===========리스트
		List<StoreDTO> storeList;
		
		if (name == "" && boss == "" && address == "" && phone == "" && sState == null) {
			storeList = employeeService.getStoreList(pageDTO);
		} else {
			storeList = employeeService.searchStoreList(storeDTO);
			pageDTO.setCount(-1);
			model.addAttribute("storeDTO", storeDTO);
		}
		model.addAttribute("storeList", storeList);
        model.addAttribute("pageDTO", pageDTO);
		return "/emp/store";
	}//storeSearch

	
	//2-2. 재료 관리
	@GetMapping("/item")
	public String item(HttpServletRequest request, Model model,PageDTO pageDTO) {
		System.out.println("EmployeeController item()");
		
		
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
				// 전체 글개수 구하기  int 리턴할형 count = getIngredientCount(pageDTO) 검색어 포함
				int count = employeeService.getItemCount(pageDTO);
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
		
			List<ItemDTO> itemList = employeeService.getItemList(pageDTO);
		
			model.addAttribute("itemList",itemList);
			model.addAttribute("pageDTO",pageDTO);
			
		return "/emp/item";
	}//jeryoList
		
		
	//2-2-1. 재료 필터링
	@GetMapping("/itemSearch")
	public String itemSearch(HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("EmployeeController itemSearch()");
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
				// 전체 글개수 구하기  int 리턴할형 count = getItemCount(pageDTO) 검색어 포함
				int count = employeeService.getItemCount(pageDTO);
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
		
		
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getItemCount(itemDTO) 검색어 포함
		count = employeeService.getItemCount(itemDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		//필터 페이징 itemDTO 저장
		count = employeeService.getItemCount(itemDTO);
		itemDTO.setPageSize(pageSize);
		itemDTO.setPageNum(pageNum);
		itemDTO.setCurrentPage(currentPage);
		itemDTO.setCount(count);
		itemDTO.setPageBlock(pageBlock);
		itemDTO.setStartPage(startPage);
		itemDTO.setEndPage(endPage);
		itemDTO.setPageCount(pageCount);
		

		List<ItemDTO> itemList;

		if (item_type == 100 && item_name == null && item_minPrice == 0 && item_maxPrice == 0) {
			itemList = employeeService.getItemList(pageDTO);
		} else {
			itemList = employeeService.searchItemList(itemDTO);
			pageDTO.setCount(-1);
			model.addAttribute("itemDTO", itemDTO);
		}

		model.addAttribute("itemList", itemList);
		model.addAttribute("pageDTO",pageDTO);
		 
		return "/emp/item";
	}//itemSearch
	

	//3. 영업 관리
	//3-1. 수주 관리
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model model,PageDTO pageDTO) {
		System.out.println("EmployeeController order()");
		
		
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
		// 전체 글개수 구하기  int 리턴할형 count = getOrderCount(pageDTO) 검색어 포함
		int count = employeeService.getOrderCount(pageDTO);
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

		
			List<OrderDTO> orderList = employeeService.getOrderList(pageDTO);
		
			model.addAttribute("orderList",orderList);
			model.addAttribute("pageDTO",pageDTO);
		
			return "/emp/order";
	}//sujuList

	
	//3-1-1. 수주 필터링
	@GetMapping("/orderSearch")
	public String orderSearch(HttpServletRequest request, Model model, PageDTO pageDTO) throws Exception {
		System.out.println("EmployeeController orderSearch()");

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
		
		// 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getStoreCount(pageDTO) 검색어 포함
		int count = employeeService.getOrderCount(pageDTO);
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
		String name = request.getParameter("name");
		orderDTO.setName(name);

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
		orderDTO.setOd_minTime(od_minTime);
		orderDTO.setOd_maxTime(od_maxTime);

		
//		if (od_time != "") {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date d1 = format.parse(od_time);
//			Timestamp date1 = new Timestamp(d1.getTime());
//			orderDTO.setOd_time(od_time);
//		}

		String shipment_sNot = request.getParameter("shipment_not");

		try {
			orderDTO.setShipment_not(shipment_sNot != null ? Integer.parseInt(shipment_sNot) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// 필터 페이징 작업
				// 전체 글개수 구하기  int 리턴할형 count = getItemCount(orderDTO) 검색어 포함
				count = employeeService.getOrderCount(orderDTO);
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
		
		//리스트
		List<OrderDTO> orderList;

		if (name == "" && item_name == "" && item_sminPrice == null && item_smaxPrice == null && od_minTime == "" && od_maxTime == "" && shipment_sNot == null) {
			orderList = employeeService.getOrderList(pageDTO);
		} else {
			orderList = employeeService.searchOrderList(orderDTO);
			pageDTO.setCount(-1);
			model.addAttribute("orderDTO", orderDTO);		
			
		}

		model.addAttribute("orderList", orderList);
		model.addAttribute("pageDTO", pageDTO);
		return "/emp/order";
	}//orderSearch

	
	//3-2. 출하 관리
	@GetMapping("/shipment")
	public String shipment(HttpServletRequest request, Model model, PageDTO pageDTO) {
		System.out.println("EmployeeController shipment()");
		
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
		// 전체 글개수 구하기  int 리턴할형 count = getShipmentCount(pageDTO) 검색어 포함
		int count = employeeService.getShipmentCount(pageDTO);
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
		
			List<ShipmentDTO> shipmentList = employeeService.getShipmentList(pageDTO);
		
			model.addAttribute("shipmentList",shipmentList);
			model.addAttribute("pageDTO",pageDTO);
			
				
		return "/emp/shipment";
	}//chulhaList

		
	//3-2-1. 출하 필터링
	@GetMapping("/shipmentSearch")
	public String shipmentSearch(HttpServletRequest request, Model model, PageDTO pageDTO) throws Exception {
		System.out.println("EmployeeController shipmentSearch()");
		ShipmentDTO shipmentDTO = new ShipmentDTO();

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
				// 전체 글개수 구하기  int 리턴할형 count = getStoreCount(pageDTO) 검색어 포함
				int count = employeeService.getShipmentCount(pageDTO);
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
		String name = request.getParameter("name");
		shipmentDTO.setName(name);

		String item_name = request.getParameter("item_name");
		shipmentDTO.setItem_name(item_name);
		
		String item_sminPrice = request.getParameter("item_minPrice");
		
		String item_smaxPrice = request.getParameter("item_maxPrice");

		try {
			shipmentDTO.setItem_minPrice(item_sminPrice != null ? Integer.parseInt(item_sminPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			shipmentDTO.setItem_maxPrice(item_smaxPrice != null ? Integer.parseInt(item_smaxPrice) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String sh_minTime = request.getParameter("sh_minTime");
		String sh_maxTime = request.getParameter("sh_maxTime");
		shipmentDTO.setSh_minTime(sh_minTime);
		shipmentDTO.setSh_maxTime(sh_maxTime);
		
		int received_not = Integer.parseInt(request.getParameter("received_not"));
		shipmentDTO.setReceived_not(received_not);

//		if (sh_time != "") {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			Date d1 = format.parse(sh_time);
//			Timestamp date1 = new Timestamp(d1.getTime());
//		}

		
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getItemCount(orderDTO) 검색어 포함
		count = employeeService.getShipmentCount(shipmentDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		
		
		//필터 페이징 shipmentDTO 저장
		shipmentDTO.setPageSize(pageSize);
		shipmentDTO.setPageNum(pageNum);
		shipmentDTO.setCurrentPage(currentPage);
		shipmentDTO.setCount(count);
		shipmentDTO.setPageBlock(pageBlock);
		shipmentDTO.setStartPage(startPage);
		shipmentDTO.setEndPage(endPage);
		shipmentDTO.setPageCount(pageCount);
		
		
		List<ShipmentDTO> shipmentList;

		if (name == "" && item_name == "" && item_sminPrice == null && item_smaxPrice == null && sh_minTime == "" && sh_maxTime == "" && received_not==100 ) {
			shipmentList = employeeService.getShipmentList(pageDTO);
		} else {
			shipmentList = employeeService.searchShipmentList(shipmentDTO);
			pageDTO.setCount(-1);
			model.addAttribute("shipmentDTO", shipmentDTO);	
		}

		model.addAttribute("shipmentList", shipmentList);
		model.addAttribute("pageDTO", pageDTO);

		return "/emp/shipment";
	}//shipmentSearch

	
	//4. 사원 관리
	//4-1. 사원 관리
	@GetMapping("/emp")
	public String emp(HttpServletRequest request, Model model,PageDTO pageDTO) {
		System.out.println("EmployeeController emp()");
		
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
				// 전체 글개수 구하기  int 리턴할형 count = getStoreCount(pageDTO) 검색어 포함
				int count = employeeService.getEmployeeCount(pageDTO);
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
		
		
			List<EmployeeDTO> empList = employeeService.getEmpList(pageDTO);
		
			model.addAttribute("empList",empList);
			model.addAttribute("pageDTO",pageDTO);

		return "/emp/emp";
	}//sawonList

	
	//4-1-1. 사원 필터링
	@GetMapping("/empSearch")
	public String empSearch(HttpServletRequest request, Model model,PageDTO pageDTO) {
		System.out.println("EmployeeController empSearch()");
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		
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
		// 전체 글개수 구하기  int 리턴할형 count = getStoreCount(employeeDTO) 검색어 포함
		int count = employeeService.getEmployeeCount(pageDTO);
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
		String emp_sDept = request.getParameter("emp_dept");

		try {
			employeeDTO.setEmp_dept(emp_sDept != null ? Integer.parseInt(emp_sDept) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String emp_sRank = request.getParameter("emp_rank");
		
		try {
			employeeDTO.setEmp_rank(emp_sRank != null ? Integer.parseInt(emp_sRank) : 100);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String emp_sNum = request.getParameter("emp_num");

		try {
			employeeDTO.setEmp_num(emp_sNum != "" ? Integer.parseInt(emp_sNum) : 0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String emp_name = request.getParameter("emp_name");
		employeeDTO.setEmp_name(emp_name);
		
		// 필터 페이징 작업
		// 전체 글개수 구하기  int 리턴할형 count = getEmployeeCount(pageDTO) 검색어 포함
		count = employeeService.getEmployeeCount(employeeDTO);
		// 전체 페이지개수 구하기
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		// 끝페이지 , 전체 페이지수 비교 => 끝페이지 크면 => 전체 페이지수로 끝페이지 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		
		//필터 페이징 employeeDTO 저장
		employeeDTO.setPageSize(pageSize);
		employeeDTO.setPageNum(pageNum);
		employeeDTO.setCurrentPage(currentPage);
		employeeDTO.setCount(count);
		employeeDTO.setPageBlock(pageBlock);
		employeeDTO.setStartPage(startPage);
		employeeDTO.setEndPage(endPage);
		employeeDTO.setPageCount(pageCount);
		List<EmployeeDTO> empList;
		
		if (emp_sDept == null && emp_sRank == null && emp_sNum == "" && emp_name == "") {
			empList = employeeService.getEmpList(pageDTO);
		} else {
			empList = employeeService.searchEmpList(employeeDTO);
			pageDTO.setCount(-1);
			model.addAttribute("employeeDTO", employeeDTO);	
		}
		
		model.addAttribute("empList", empList);
		model.addAttribute("pageDTO",pageDTO);
		
		return "/emp/emp";
	}//empSearch

	
	//5. 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		System.out.println("EmployeeController logout()");
		session.invalidate();
		return "redirect:/emp/login";
	}
	
	
	//팝업 주소 매핑
	//2-1-1. 지점 관리 - 추가
	@GetMapping("popup/store_insert")
	public String store_insert() {
		System.out.println("EmployeeController store_insert()");

		return "/emp/popup/store_insert";
	}
	

	@PostMapping("/popup/store_insertPro")
	public String store_insertPro(StoreDTO storeDTO) {
		System.out.println("EmployeeController store_insertPro()");
		
		// 비밀번호 암호화
		storeDTO.setPw(new BCryptPasswordEncoder().encode(storeDTO.getPw()));
		
		employeeService.storeInsert(storeDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	//2-1-2. 지점 관리 - 수정

	//2-1-2. 지점 관리 - 수정 팝업
	@GetMapping("popup/store_update")
	public String store_update(HttpServletRequest request, HttpSession session, Model model) {
		System.out.println("EmployeeController store_update()");

		int num = Integer.parseInt(request.getParameter("num"));
		StoreDTO storeDTO = new StoreDTO();
		storeDTO = employeeService.getStore(num);
		model.addAttribute("storeDTO", storeDTO);
		

		return "/emp/popup/store_update";
	}

	
	@PostMapping("/popup/store_updatePro")
	public String store_updatePro(StoreDTO storeDTO) {
		System.out.println("EmployeeController store_updatePro()");
		
		// 비밀번호 암호화
		storeDTO.setPw(new BCryptPasswordEncoder().encode(storeDTO.getPw()));
		employeeService.storeUpdate(storeDTO);
		
		return "redirect:/emp/popup/close";
	}
	

	//2-2-1. 재료 관리 - 추가
	@GetMapping("popup/item_insert")
	public String item_insert() {
		System.out.println("EmployeeController item_insert()");
		
		return "/emp/popup/item_insert";
	}
	
	@PostMapping("popup/item_insertPro")
	public String item_insertPro(ItemDTO itemDTO) {
		System.out.println("EmployeeController item_insertPro()");
		employeeService.itemInsert(itemDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	//2-2-2 재료 관리 - 수정
	@GetMapping("popup/item_update")
	public String item_update(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController item_update()");
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		ItemDTO itemDTO = new ItemDTO();
		itemDTO = employeeService.getItem(item_num);
		model.addAttribute("itemDTO", itemDTO);
		
		return "/emp/popup/item_update";
	}
	
	@PostMapping("popup/item_updatePro")
	public String item_updatePro(ItemDTO itemDTO) {
		System.out.println("EmployeeController item_updatePro()");
		employeeService.itemUpdate(itemDTO);

		return "redirect:/emp/popup/close";
	}
	
	
	//3-1-1 수주 관리 - 수정
	@GetMapping("popup/order_update")
	public String order_update(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController order_update()");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		OrderDTO orderDTO = new OrderDTO();
		orderDTO = employeeService.getOrder(od_num);
		model.addAttribute("orderDTO",orderDTO);
		return "/emp/popup/order_update";
	}
	
	@PostMapping("popup/order_updatePro")
	public String order_updatePro(OrderDTO orderDTO) {
		System.out.println("EmployeeController order_updatePro()");
		employeeService.orderUpdate(orderDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	
	//3-1-2 수주 관리 - 출하 추가
	@GetMapping("popup/shipment_insert")
	public String shipment_insert(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController shipment_insert()");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		OrderDTO orderDTO = employeeService.getOrder(od_num);
		
		model.addAttribute("orderDTO", orderDTO);
		return "/emp/popup/shipment_insert";
	}
	

	@PostMapping("popup/shipment_insertPro")
	public String shipment_insertPro(HttpServletRequest request, ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeController shipment_insertPro()");
		
		employeeService.shipmentInsert(shipmentDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	
	//3-2-2 출하 관리 - 수정
	@GetMapping("popup/shipment_update")
	public String shipment_update(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController shipment_update()");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		ShipmentDTO shipmentDTO = employeeService.getShipment(od_num);
		model.addAttribute("shipmentDTO", shipmentDTO);
		
		return "/emp/popup/shipment_update";
	}
	
	@GetMapping("popup/shipment_updatePro")
	public String shipment_updatePro(HttpServletRequest request, ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeController shipment_updatePro()");
			
		employeeService.shipmentUpdate(shipmentDTO);
		
		return "redirect:/emp/popup/close";
	}
	
	//3-2-3 출하 - 삭제
	@GetMapping("popup/shipment_delete")
	public String shipment_delete(HttpServletRequest request) {
		System.out.println("EmployeeController shipment_delete()");
		
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		
		employeeService.shipmentDelete(od_num);
		
		return "redirect:/emp/shipment";
	}
	
	
	//4-1-1. 사원 관리 - 추가
	@GetMapping("popup/emp_insert")
	public String emp_insert() {
		System.out.println("EmployeeController emp_insert()");
		
		return "/emp/popup/emp_insert";
	}
	
	@PostMapping("popup/emp_insertPro")
	public String emp_insertPro(EmployeeDTO employeeDTO, HttpServletRequest request) {
		System.out.println("EmployeeController emp_insertPro()");
		
//		employeeDTO.setEmp_dept(request.getParameter("emp_dept"));
//		employeeDTO.setEmp_email(request.getParameter("emp_email"));
//		employeeDTO.setEmp_name(request.getParameter("emp_name"));
//		employeeDTO.setEmp_note(request.getParameter("emp_note"));
//		employeeDTO.setEmp_num(Integer.parseInt(request.getParameter("emp_num")));
//		employeeDTO.setEmp_phone(request.getParameter("emp_phone"));
//		employeeDTO.setEmp_pw(request.getParameter("emp_pw"));
//		employeeDTO.setEmp_rank(request.getParameter("emp_rank"));
//		employeeDTO.setEmp_right(Integer.parseInt(request.getParameter("emp_right")));
//		employeeDTO.setEmp_state(Integer.parseInt(request.getParameter("emp_state")));
		
//		String hire_date = request.getParameter("hire_date");
//		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//		Date d1;
//		try {
//			d1 = format1.parse(hire_date);
//		} catch (ParseException e) {
//			d1 = new Date();
//			e.printStackTrace();
//		}
//		Timestamp jdate1 = new Timestamp(d1.getTime());
//		employeeDTO.setHire_date(jdate1);
//		
//		String emp_birth = request.getParameter("emp_birth");
//		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
//		Date d2;
//		try {
//			d2 = format2.parse(emp_birth);
//		} catch (ParseException e) {
//			d2 = new Date();
//			e.printStackTrace();
//		}
//		Timestamp jdate2 = new Timestamp(d2.getTime());
//		employeeDTO.setEmp_birth(jdate2);
		
		// 비밀번호 암호화
				employeeDTO.setEmp_pw(new BCryptPasswordEncoder().encode(employeeDTO.getEmp_pw()));
		
		employeeService.employeeInsert(employeeDTO);
		return "redirect:/emp/popup/close";
	}
	
	//중복 확인
	@GetMapping("/emp_numCheck")
	@ResponseBody
	public String emp_numCheck(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeController emp_numCheck()");
		
		EmployeeDTO employeeDTO1 = employeeService.getEmployee(employeeDTO.getEmp_num());
		
		String result ="";
		if(employeeDTO1 != null) {
			result = "emp_numDup";
		} else {
			result = "emp_numOk";
		}
		System.out.println(result);
		return result;
	}
	
	//4-1-2. 사원 관리 - 수정(관리자)
	@GetMapping("popup/emp_update_admin")
	public String emp_update_admin(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController emp_update_admin()");
		int emp_num = Integer.parseInt(request.getParameter("emp_num"));
		EmployeeDTO employeeDTO = employeeService.getEmployee(emp_num);		
		model.addAttribute("employeeDTO", employeeDTO);
				
		return "/emp/popup/emp_update_admin";
	}
	
	@PostMapping("popup/emp_updateProAdmin")
	public String emp_updateProAdmin(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeController emp_updatePro_admin()");
		
		// 비밀번호 암호화
				employeeDTO.setEmp_pw(new BCryptPasswordEncoder().encode(employeeDTO.getEmp_pw()));
		
		employeeService.employeeUpdate1(employeeDTO);
		return "redirect:/emp/popup/close";
	}
	
	
	//4-1-3. 사원 관리 - 수정(일반)
	@GetMapping("popup/emp_update")
	public String emp_update(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController emp_update()");
		int emp_num = Integer.parseInt(request.getParameter("emp_num"));
		EmployeeDTO employeeDTO = employeeService.getEmployee(emp_num);		
		
		model.addAttribute("employeeDTO", employeeDTO);
		
		return "/emp/popup/emp_update";
	}
	
	@PostMapping("popup/emp_updatePro")
	public String emp_update(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeController emp_updatePro()");
		
		// 비밀번호 암호화
				employeeDTO.setEmp_pw(new BCryptPasswordEncoder().encode(employeeDTO.getEmp_pw()));
		
		employeeService.employeeUpdate(employeeDTO);
		return "redirect:/emp/popup/close";
	}
	
	//창 닫기
	@GetMapping("popup/close")
	public String close() {
		System.out.println("close()");
		return "/emp/popup/close";
	}
	
	//===============상세
	//재료 상세
	@GetMapping("detail/d_item")
	public String d_item(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController d_item");
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		ItemDTO itemDTO = employeeService.getItem(item_num);
		model.addAttribute("itemDTO", itemDTO);
		return "emp/detail/d_item";
	}
	
	//지점 상세
	@GetMapping("detail/d_store")
	public String d_store(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController d_store");
		int num = Integer.parseInt(request.getParameter("num"));
		StoreDTO storeDTO = employeeService.getStore(num);
		model.addAttribute("storeDTO", storeDTO);
		return "emp/detail/d_store";
	}
	
	//수주 상세
	@GetMapping("detail/d_order")
	public String d_order(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController d_order");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		OrderDTO orderDTO = employeeService.getOrder(od_num);
		model.addAttribute("orderDTO", orderDTO);
		return "emp/detail/d_order";
	}
	
	//출하 상세
	@GetMapping("detail/d_shipment")
	public String d_shipment(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController d_shipment");
		int od_num = Integer.parseInt(request.getParameter("od_num"));
		ShipmentDTO shipmentDTO = employeeService.getShipment(od_num);
		model.addAttribute("shipmentDTO", shipmentDTO);
		return "emp/detail/d_shipment";
	}

	//사원 상세
	@GetMapping("detail/d_emp")
	public String d_emp(HttpServletRequest request, Model model) {
		System.out.println("EmployeeController d_emp");
		int emp_num = Integer.parseInt(request.getParameter("emp_num"));
		EmployeeDTO employeeDTO = employeeService.getEmployee(emp_num);
		model.addAttribute("employeeDTO", employeeDTO);
		return "emp/detail/d_emp";
	}
	

		
}
