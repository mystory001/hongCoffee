package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.StoreDAO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.ProductDTO;
import com.itwillbs.domain.ReceiveDTO;
import com.itwillbs.domain.ResultDTO;
import com.itwillbs.domain.StockDTO;
import com.itwillbs.domain.StoreDTO;


@Service
public class StoreService {
	
	@Inject
	private StoreDAO storeDAO;
	
	//재료 출력
	public List<ItemDTO> getItemList(PageDTO pageDTO){
		System.out.println("StoreService getItemList()");
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		
		return storeDAO.getItemList(pageDTO);
	}//getItemList


	//재료 필터링 출력
	public List<ItemDTO> searchItemList(ItemDTO itemDTO) {
		System.out.println("StoreService searchItemList()");
				
		int currentPage = itemDTO.getCurrentPage();
		int pageSize = itemDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		itemDTO.setStartRow(startRow - 1);
		itemDTO.setEndRow(endRow);
		
		System.out.println("서비스" + itemDTO);
		
		return storeDAO.searchItemList(itemDTO);
	}//searchItemList	

	
	//재고 출력
	public List<StockDTO> getStockList(PageDTO pageDTO){
		System.out.println("StoreService getStockList()");

		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		return storeDAO.getStockList(pageDTO);
	}//getStockList
	
	
	//재고 필터링 출력
	public List<StockDTO> searchStockList(StockDTO stockDTO) {
		System.out.println("StoreService searchStockList(()");
		int currentPage = stockDTO.getCurrentPage();
		int pageSize = stockDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		stockDTO.setStartRow(startRow - 1);
		stockDTO.setEndRow(endRow);
		System.out.println("서비스" + stockDTO);
		return storeDAO.searchStockList(stockDTO);
	}//searchStockList
	
	
	//발주 출력

	public List<OrderDTO> getOrderList(PageDTO pageDTO){

		System.out.println("StoreService getOrderList()");
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		

		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		
		
		return storeDAO.getOrderList(pageDTO);

	}//getOrderList
	

	//발주 필터링 출력
	public List<OrderDTO> searchOrderList(OrderDTO orderDTO) {
		System.out.println("StoreService searchOrderList()");
		int currentPage = orderDTO.getCurrentPage();
		int pageSize = orderDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		orderDTO.setStartRow(startRow - 1);
		orderDTO.setEndRow(endRow);
		System.out.println("서비스" + orderDTO);
		return storeDAO.searchOrderList(orderDTO);
	}//searchOrderList

	
	//입고 출력
	public List<ReceiveDTO> getReceiveList(PageDTO pageDTO){
		System.out.println("StoreService getReceiveList()");
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		return storeDAO.getReceiveList(pageDTO);
	}//getReceiveList
	
	
	//입고 필터링 출력
	public List<ReceiveDTO> searchReceiveList(ReceiveDTO receiveDTO) {
		System.out.println("StoreService searchReceiveList()");
		int currentPage = receiveDTO.getCurrentPage();
		int pageSize = receiveDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		receiveDTO.setStartRow(startRow - 1);
		receiveDTO.setEndRow(endRow);
		System.out.println("서비스" + receiveDTO);
		return storeDAO.searchReceiveList(receiveDTO);
	}//searchReceiveList
	
	
	//소모 출력
	public List<ResultDTO> getConsumeList(PageDTO pageDTO){
		System.out.println("StoreService getConsumeList()");
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		return storeDAO.getConsumeList(pageDTO);
	}//getSomoList

	
	//소모 필터링 출력
	public List<ResultDTO> searchConsumeList(ResultDTO resultDTO) {
		System.out.println("StoreService searchConsumeList()");
		int currentPage = resultDTO.getCurrentPage();
		int pageSize = resultDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		resultDTO.setStartRow(startRow - 1);
		resultDTO.setEndRow(endRow);
		System.out.println("서비스" + resultDTO);
		return storeDAO.searchConsumeList(resultDTO);
	}//searchSomoList
	
	
	//판매 출력
	public List<ResultDTO> getSellList(PageDTO pageDTO){
		System.out.println("StoreService getSellList()");
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		return storeDAO.getSellList(pageDTO);
	}//getPanmeList

	
	//판매 필터링 출력
	public List<ResultDTO> searchSellList(ResultDTO resultDTO) {
		System.out.println("StoreService searchSellList()");
		int currentPage = resultDTO.getCurrentPage();
		int pageSize = resultDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		resultDTO.setStartRow(startRow - 1);
		resultDTO.setEndRow(endRow);
		System.out.println("서비스" + resultDTO);
		return storeDAO.searchSellList(resultDTO);
	}//searchPanmeList
	
	
	//실적 출력
	public List<ResultDTO> getResultList(PageDTO pageDTO){
		System.out.println("StoreService getEmpList()");
		int currentPage = pageDTO.getCurrentPage();
		int pageSize = pageDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		return storeDAO.getResultList(pageDTO);
	}//getResultList

	
	//실적 필터링 출력
	public List<ResultDTO> searchResultList(ResultDTO resultDTO) {
		System.out.println("StoreService searchResultList()");
		int currentPage = resultDTO.getCurrentPage();
		int pageSize = resultDTO.getPageSize();
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		
		resultDTO.setStartRow(startRow - 1);
		resultDTO.setEndRow(endRow);
		System.out.println("서비스" + resultDTO);	
		return storeDAO.searchResultList(resultDTO);
	}//searchResultList

	
	//로그인
	public StoreDTO userCheck(StoreDTO storeDTO) {
		System.out.println("StoreService userCheck()");
		return storeDAO.userCheck(storeDTO);
	}



	public void stockInsert(StockDTO stockDTO) {
		System.out.println("StoreService stockInsert()");
		storeDAO.stockInsert(stockDTO);
	}

	public StockDTO getStock(int num) {
		System.out.println("StoreService getStock()");
		return storeDAO.getStock(num);
	}



	public int getItemNum(String item_name) {
		System.out.println("StoreService getItemNum()");
		return storeDAO.getItemNum(item_name);
	}



	public OrderDTO getOrder(int od_num) {
		System.out.println("StoreService getOrder()");
		return storeDAO.getOrder(od_num);
	}


	public void receiveInsert(ReceiveDTO receiveDTO) {
		System.out.println("StoreService receiveInsert()");
		storeDAO.receiveInsert(receiveDTO);
	}

	public void orderInsert(OrderDTO orderDTO) {
		System.out.println("StoreService orderInsert()");
		storeDAO.orderInsert(orderDTO);
	}

	public void orderUpdate(OrderDTO orderDTO) {
		System.out.println("StoreService orderUpdate()");
		storeDAO.orderUpdate(orderDTO);
	}

	public void receiveUpdate(ReceiveDTO receiveDTO) {
		System.out.println("StoreService receiveUpdate()");
		storeDAO.receiveUpdate(receiveDTO);
	}



	public ReceiveDTO getReceive(int od_num) {
		System.out.println("StoreService getReceive()");
		return storeDAO.getReceive(od_num);
	}
	
	public ItemDTO getItem(int item_num) {
		System.out.println("StoreService getItem()");
		return storeDAO.getItem(item_num);
	}
	
	//==그래프
	
	//재고 그래프
		public List<StockDTO> getStock6(int num) {
			System.out.println("StoreService getStock6()");
			return storeDAO.getStock6(num);
		}



		public List<ResultDTO> getResultMain(int num) {
			System.out.println("StoreService getResultMain()");
			return storeDAO.getResultMain(num);
		}



	public void consumeInsert(ResultDTO resultDTO) {
		System.out.println("StoreService consumeInsert()");
		storeDAO.consumeInsert(resultDTO);
	}


	public int getStockNum(StockDTO stockDTO) {
		System.out.println("StoreService getStockNum()");
		return storeDAO.getStockNum(stockDTO);
	}

	public int getResultCount(ResultDTO resultDTO) {
		System.out.println("StoreService getResultCount()");
		return storeDAO.getResultCount(resultDTO);
	}
	public int getResultCount(PageDTO pageDTO) {
		System.out.println("StoreService getResultCount()");
		return storeDAO.getResultCount(pageDTO);
	}
	
	public int getConsumeCount(PageDTO pageDTO) {
		System.out.println("StoreService getConsumeCount()");
		return storeDAO.getConsumeCount(pageDTO);
	}
	
	public int getSellCount(PageDTO pageDTO) {
		System.out.println("StoreService getSellCount()");
		return storeDAO.getSellCount(pageDTO);
	}
	
	public int getSellCount(ResultDTO resultDTO) {
		System.out.println("StoreService getSellCount()");
		return storeDAO.getSellCount(resultDTO);
	}
	
	public int getAmount(int stock_num) {
		System.out.println("StoreService getAmount()");
		return storeDAO.getAmount(stock_num);
	}

	public int getConsumeCount(ResultDTO resultDTO) {
		System.out.println("StoreService getConsumeCount()");
		return storeDAO.getConsumeCount(resultDTO);
	}
	

	public Object getConsume(int rs_num) {
		System.out.println("StoreService getConsume");
		return storeDAO.getConsume(rs_num);
	}


	public void consumeUpdate(ResultDTO resultDTO) {
		System.out.println("StoreService consumeUpdate()");
		storeDAO.consumUpdate(resultDTO);
	}


	public void sellInsert(ResultDTO resultDTO) {
		System.out.println("StoreService sellInsert()");
		storeDAO.sellInsert(resultDTO);
	}


	public void stockUpdate(StockDTO stockDTO) {
		System.out.println("StoreService stockUpdate()");
		storeDAO.stockUpdate(stockDTO);
	}


	public ResultDTO getSales(int rs_num) {
		System.out.println("StoreService getSales()");
		return storeDAO.getSales(rs_num);
	}


	public void salesUpdate(ResultDTO resultDTO) {
		System.out.println("StoreService salesUpdate()");
		storeDAO.salesUpdate(resultDTO);
	}

	// == 페이징
	
	//지점
	public int getItemCount(ItemDTO itemDTO) {
		System.out.println("StoreService getItemCount()");
		return storeDAO.getItemCount(itemDTO);
	}
	
	public int getStockCount(StockDTO stockDTO) {
		System.out.println("StoreService getStockCount()");
		return storeDAO.getStockCount(stockDTO);
	}
	
	public int getOrderCount(OrderDTO orderDTO) {
		System.out.println("StoreService getOrderCount()");
		return storeDAO.getOrderCount(orderDTO);
	}
	
	public int getReceiveCount(ReceiveDTO receiveDTO) {
		System.out.println("StoreService getReceiveCount()");
		return storeDAO.getReceiveCount(receiveDTO);
	}
	
	// == 페이징
	public int getItemCount(PageDTO pageDTO) {
		System.out.println("StoreService getItemCount()");
		return storeDAO.getItemCount(pageDTO);
	}
	
	public int getStockCount(PageDTO pageDTO) {
		System.out.println("StoreService getStockCount()");
		return storeDAO.getStockCount(pageDTO);
	}


	public int getOrderCount(PageDTO pageDTO) {
		System.out.println("StoreService getOrderCount()");
		return storeDAO.getOrderCount(pageDTO);
	}

	public int getReceiveCount(PageDTO pageDTO) {
		System.out.println("StoreService getReceiveCount()");
		return storeDAO.getReceiveCount(pageDTO);
	}
	
	

	public void orderDelete(int od_num) {
		System.out.println("StoreService orderDelete()");
		storeDAO.orderDelete(od_num);
	}

	public void autoPay() {
		System.out.println("StoreService autoPay()");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		System.out.println(now);
		storeDAO.autoPay(now);
	}



	



}
