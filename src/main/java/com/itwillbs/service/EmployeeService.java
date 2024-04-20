package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.EmployeeDAO;
import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.SalesDTO;
import com.itwillbs.domain.ShipmentDTO;
import com.itwillbs.domain.StoreDTO;


@Service
public class EmployeeService {
	
	@Inject
	private EmployeeDAO employeeDAO;

	//사원번호, 비밀번호 확인
	public EmployeeDTO userCheck(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService userCheck()");
		return employeeDAO.userCheck(employeeDTO);
	}
	
	//지점 출력
	public List<StoreDTO> getStoreList(PageDTO pageDTO){
		System.out.println("EmployeeService getStoreList()");
		
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		
		System.out.println("서비스" + pageDTO);
		
		return employeeDAO.getStoreList(pageDTO);
	}//getJijumList
	

	//지점 필터링 출력
	public List<StoreDTO> searchStoreList(StoreDTO storeDTO) {
		System.out.println("EmployeeService searchStoreList()");
		
		int currentPage = storeDTO.getCurrentPage();
		int pageSize = storeDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		storeDTO.setStartRow(startRow - 1);
		storeDTO.setEndRow(endRow);
		
		System.out.println("서비스" + storeDTO);

		return employeeDAO.searchStoreList(storeDTO);
	}//searchStoreList

	
	//재료 출력
	public List<ItemDTO> getItemList(PageDTO pageDTO){
		System.out.println("EmployeeService getItemList()");
		
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setPageSize(pageSize);
		pageDTO.setEndRow(endRow);
		
		
		return employeeDAO.getItemList(pageDTO);
	}//getItemList
	
	//재료 필터링 출력
	public List<ItemDTO> searchItemList(ItemDTO itemDTO) {
		System.out.println("EmployeeService searchItemList()");
		
		int currentPage = itemDTO.getCurrentPage();
		int pageSize = itemDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		itemDTO.setStartRow(startRow - 1);
		itemDTO.setEndRow(endRow);
		
		System.out.println("서비스" + itemDTO);
		
		return employeeDAO.searchItemList(itemDTO);
	}//searchItemList
	
	//수주 출력
	public List<OrderDTO> getOrderList(PageDTO pageDTO){
		System.out.println("EmployeeService getOrderList()");
		
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		
		return employeeDAO.getOrderList(pageDTO);
	}//getSujuList
	
	//수주 필터링 출력
	public List<OrderDTO> searchOrderList(OrderDTO orderDTO) {
		System.out.println("EmployeeService searchOrderList()");
		
		int currentPage = orderDTO.getCurrentPage();
		int pageSize = orderDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		orderDTO.setStartRow(startRow - 1);
		orderDTO.setEndRow(endRow);
		
		System.out.println("서비스" + orderDTO);
		
		return employeeDAO.searchOrderList(orderDTO);
	}//searchOrderList
	
	//출하 출력

	public List<ShipmentDTO> getShipmentList(PageDTO pageDTO){
		System.out.println("EmployeeService getShipmentList()");
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
//		pageDTO.setPageSize(pageSize);
		pageDTO.setEndRow(endRow);
		
		return employeeDAO.getShipmentList(pageDTO);
	}//getShipmentList
	
	//출하 필터링 출력
	public List<ShipmentDTO> searchShipmentList(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeService searchShipmentList()");
		int currentPage = shipmentDTO.getCurrentPage();
		int pageSize = shipmentDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		shipmentDTO.setStartRow(startRow - 1);
		shipmentDTO.setEndRow(endRow);
		return employeeDAO.searchShipmentList(shipmentDTO);
	}//searchShipmentList
	
	//사원 출력
	public List<EmployeeDTO> getEmpList(PageDTO pageDTO){
		System.out.println("EmployeeService getEmpList()");
		
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setPageSize(pageSize);
		pageDTO.setEndRow(endRow);
		
		return employeeDAO.getEmpList(pageDTO);
	}//getSawonList

	//사원 필터링 출력
	public List<EmployeeDTO> searchEmpList(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService searchEmpList()");
		int currentPage = employeeDTO.getCurrentPage();
		int pageSize = employeeDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		employeeDTO.setStartRow(startRow - 1);
		employeeDTO.setEndRow(endRow);
		return employeeDAO.searchEmpList(employeeDTO);
	}//searchEmpList

	//팝업=========================================================
	//지점 추가
	public void storeInsert(StoreDTO storeDTO) {
		System.out.println("EmployeeService storeInsert()");
		employeeDAO.storeInsert(storeDTO);
	}

	public StoreDTO getStore(int num) {
		System.out.println("EmployeeService getStore()");
		return employeeDAO.getStore(num);
	}

	//지점 수정
	public void storeUpdate(StoreDTO storeDTO) {
		System.out.println("EmployeeService storeUpdate()");
		employeeDAO.storeUpdate(storeDTO);
	}

	//재료 추가
	public void itemInsert(ItemDTO itemDTO) {
		System.out.println("EmployeeService itemInsert()");
		employeeDAO.itemInsert(itemDTO);
	}

	public ItemDTO getItem(int item_num) {
		System.out.println("EmployeeService getItem()");
		return employeeDAO.getItem(item_num);
	}
	
	//재료 수정
	public void itemUpdate(ItemDTO itemDTO) {
		System.out.println("EmployeeService itemInsertPro()");
		employeeDAO.itemUpdate(itemDTO);
	}

	//수주 수정
	public void orderUpdate(OrderDTO orderDTO) {
		System.out.println("EmployeeService orderInsert()");
		employeeDAO.orderUpdate(orderDTO);
	}

	//사원 추가
	public void employeeInsert(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService employeeInsert()");
		employeeDAO.employeeInsert(employeeDTO);
	}
	
	//사원 수정(관리자)
	public void employeeUpdate1(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService employeeUpdate_admin()");
		employeeDAO.employeeUpdate1(employeeDTO);
	}
	
	//사원 수정(사원)
	public void employeeUpdate(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeService employeeUpdate()");
		employeeDAO.employeeUpdate(employeeDTO);
		
	}

	public OrderDTO getOrder(int od_num) {
		System.out.println("EmployeeService getOrder()");
		return employeeDAO.getOrder(od_num);
	}


	public void shipmentInsert(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeService shipmentInsert()");
		employeeDAO.shipmentInsert(shipmentDTO);
	}

	public ShipmentDTO getShipment(int od_num) {
		System.out.println("EmployeeService getShipment()");
		return employeeDAO.getShipment(od_num);
	}

	public void shipmentUpdate(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeService shipmentUpdate()");
		employeeDAO.shipmentUpdate(shipmentDTO);
		
	}

	public EmployeeDTO getEmployee(int emp_num) {
		System.out.println("EmployeeService getEmployee()");
		return employeeDAO.getEmployee(emp_num);
	}


	public void shipmentDelete(int od_num) {
		System.out.println("EmployeeService shipmentDelete()");
		employeeDAO.shipmentDelete(od_num);
	}


// == 페이징

	//지점
		public int getStoreCount(StoreDTO storeDTO) {
			System.out.println("EmployeeService getStoreCount()");
			return employeeDAO.getStoreCount(storeDTO);
		}

		//재료
		public int getItemCount(ItemDTO itemDTO) {
			System.out.println("EmployeeService getIngredientCount()");
			return employeeDAO.getItemCount(itemDTO);
		}
	    //수주
		public int getOrderCount(OrderDTO orderDTO) {
			System.out.println("EmployeeService getOrderCount()");
			return employeeDAO.getOrderCount(orderDTO);
		}
		
		//출하
		public int getShipmentCount(ShipmentDTO shipmentDTO) {
			System.out.println("EmployeeService getShipmentCount()");
			return employeeDAO.getShipmentCount(shipmentDTO);
		}
	    
		//사원
		public int getEmployeeCount(EmployeeDTO employeeDTO) {
			System.out.println("EmployeeService getEmpCount()");
			return employeeDAO.getEmployeeCount(employeeDTO);
		}


//===그래프
		public List<SalesDTO> getTop5() {
			System.out.println("EmployeeService getTop5()");
			return employeeDAO.getTop5();
		}


// == 페이징		
		public int getStoreCount(PageDTO pageDTO) {
			System.out.println("EmployeeService getStoreCount()");
			return employeeDAO.getStoreCount(pageDTO);
		}

		public int getItemCount(PageDTO pageDTO) {
			System.out.println("EmployeeService getItemCount()");
			return employeeDAO.getItemCount(pageDTO);
		}

		public int getOrderCount(PageDTO pageDTO) {
			System.out.println("EmployeeService getOrderCount()");
			return employeeDAO.getOrderCount(pageDTO);
		}

		public int getShipmentCount(PageDTO pageDTO) {
			System.out.println("EmployeeService getShipmentCount()");
			return employeeDAO.getShipmentCount(pageDTO);
		}

		public int getEmployeeCount(PageDTO pageDTO) {
			System.out.println("EmployeeService getEmployeeCount()");
			return employeeDAO.getEmployeeCount(pageDTO);
		}
		
		public List<ShipmentDTO> getShipmentListEx() {
			System.out.println("EmployeeService getShipmentListEx()");
			return employeeDAO.getShipmentListEx();
		}

		public List<OrderDTO> getOrderListEx() {
			System.out.println("EmployeeService getOrderListEx()");
			return employeeDAO.getOrderListEx();

		}






}
