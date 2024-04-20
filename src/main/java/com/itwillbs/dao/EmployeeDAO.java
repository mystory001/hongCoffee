package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.EmployeeDTO;
import com.itwillbs.domain.ItemDTO;
import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.SalesDTO;
import com.itwillbs.domain.ShipmentDTO;
import com.itwillbs.domain.StoreDTO;

@Repository
public class EmployeeDAO {

	//마이바티스 객체생성 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.EmpMapper";
	
	//지점 목록
	public List<StoreDTO> getStoreList(PageDTO pageDTO) {
		System.out.println("EmployeesDAO getStoreList()");
		
		return sqlSession.selectList(namespace + ".getStoreList", pageDTO);
	}//getJijumList()
	

	//지점 필터링 목록
	public List<StoreDTO> searchStoreList(StoreDTO storeDTO) {
		System.out.println("EmployeesDAO searchStoreList()");


		return sqlSession.selectList(namespace + ".searchStoreList", storeDTO);
	}//searchStoreList()
	
	//재료 목록
	public List<ItemDTO> getItemList(PageDTO pageDTO) {
		System.out.println("EmployeesDAO getItemList()");
		
		return sqlSession.selectList(namespace + ".getItemList", pageDTO);
	}//getItemList()
	
	//재료 필터링 목록
	public List<ItemDTO> searchItemList(ItemDTO itemDTO) {
		System.out.println("EmployeesDAO searchItemList()");
		
		return sqlSession.selectList(namespace + ".searchItemList", itemDTO);
	}//searchItemList()

	
	//수주 목록
	public List<OrderDTO> getOrderList(PageDTO pageDTO) {
		System.out.println("EmployeesDAO getOrderList()");
		
		return sqlSession.selectList(namespace + ".getOrderList", pageDTO);
	}//getSujuList()
	
	//수주 필터링 목록
	public List<OrderDTO> searchOrderList(OrderDTO orderDTO) {
		System.out.println("EmployeesDAO searchOrderList()");
		
		return sqlSession.selectList(namespace + ".searchOrderList", orderDTO);
	}//searchOrderList()
	
	//출하 목록
	public List<ShipmentDTO> getShipmentList(PageDTO pageDTO) {
		System.out.println("EmployeesDAO getShipmentList()");
		
		return sqlSession.selectList(namespace + ".getShipmentList", pageDTO);
	}//getChulhaList()
	
	//출하 필터링 목록
	public List<ShipmentDTO> searchShipmentList(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeesDAO searchShipmentList()");
		
		return sqlSession.selectList(namespace + ".searchShipmentList", shipmentDTO);
	}//searchShipmentList()
		
	//사원 목록
	public List<EmployeeDTO> getEmpList(PageDTO pageDTO) {
		System.out.println("EmployeesDAO getEmpList()");
		
		return sqlSession.selectList(namespace + ".getEmpList", pageDTO);
	}//getSawonList()

	//사원 필터링 목록
	public List<EmployeeDTO> searchEmpList(EmployeeDTO employeeDTO) {
		System.out.println("EmployeesDAO searchEmpList()");
		
		return sqlSession.selectList(namespace + ".searchEmpList", employeeDTO);
	}//searchEmpList
	
	//로그인
	public EmployeeDTO userCheck(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO userCheck()");
		return sqlSession.selectOne(namespace + ".userCheck", employeeDTO);
	}


	public void storeInsert(StoreDTO storeDTO) {
		System.out.println("EmployeeDAO storeInsert()");
		sqlSession.insert(namespace+".storeInsert", storeDTO);
		
	}

	public void storeUpdate(StoreDTO storeDTO) {
		System.out.println("EmployeeDAO storeUpdate()");
		sqlSession.update(namespace+".storeUpdate", storeDTO);
	}

	public void employeeInsert(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO employeeInsert()");
		sqlSession.insert(namespace+".employeeInsert", employeeDTO);
	}

	public void employeeUpdate1(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO employeeUpdate_admin()");
		sqlSession.update(namespace+".employeeUpdate1", employeeDTO);
	}

	public void employeeUpdate(EmployeeDTO employeeDTO) {
		System.out.println("EmployeeDAO employeeUpdate()");
		sqlSession.update(namespace+".employeeUpdate", employeeDTO);
		
	}

	public void orderUpdate(OrderDTO orderDTO) {
		System.out.println("EmployeeDAO orderUpdate()");
		sqlSession.update(namespace+".orderUpdate", orderDTO);
	}

	public StoreDTO getStore(int num) {
		System.out.println("EmployeeDAO getStore()");
		return sqlSession.selectOne(namespace+".getStore", num);
	}

	public void itemInsert(ItemDTO itemDTO) {
		System.out.println("EmployeeDAO itemInsert()");
		sqlSession.insert(namespace+".itemInsert", itemDTO);
	}

	public ItemDTO getItem(int item_num) {
		System.out.println("EmployeeDAO getItem()");
		return sqlSession.selectOne(namespace+".getItem", item_num);
	}

	public void itemUpdate(ItemDTO itemDTO) {
		System.out.println("EmployeeDAO itemUpdate()");
		sqlSession.update(namespace+".itemUpdate", itemDTO);
	}

	public OrderDTO getOrder(int od_num) {
		System.out.println("EmployeeDAO getOrder()");
		return sqlSession.selectOne(namespace+".getOrder", od_num);
	}

	public void shipmentInsert(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeDAO shipmentInsert()");
		sqlSession.insert(namespace+".shipmentInsert", shipmentDTO);
		sqlSession.update(namespace+".shipmentState", shipmentDTO);
	}

	public void shipmentUpdate(ShipmentDTO shipmentDTO) {
		System.out.println("EmployeeDAO shipmentUpdate()");
		sqlSession.update(namespace+".shipmentUpdate", shipmentDTO);
	}

	public ShipmentDTO getShipment(int od_num) {
		System.out.println("EmployeeDAO getShipment()");
		return sqlSession.selectOne(namespace+".getShipment", od_num);
	}

	public EmployeeDTO getEmployee(int emp_num) {
		System.out.println("EmployeeDAO getEmployeeA()");
		return sqlSession.selectOne(namespace+".getEmployee",emp_num);
	}

	public void shipmentDelete(int od_num) {
		System.out.println("EMployeeDAO shipmentDelete()");
		sqlSession.delete(namespace+".shipmentDelete", od_num);
		sqlSession.update(namespace+".shipmentStateReset",od_num);
	}

			//페이지 처리
			public int getStoreCount(StoreDTO storeDTO) {
				System.out.println("EmployeeDAO getStoreCount");
				return sqlSession.selectOne(namespace + ".getStoreCountS", storeDTO);
			}
		
			public int getItemCount(ItemDTO itemDTO) {
				System.out.println("EmployeeDAO getIngredientCount");
				return sqlSession.selectOne(namespace + ".getItemCountI", itemDTO);
			}

			public int getOrderCount(OrderDTO orderDTO) {
				System.out.println("EmployeeDAO getOrderCount");
				return sqlSession.selectOne(namespace + ".getOrderCountO", orderDTO);
			}

			public int getShipmentCount(ShipmentDTO shipmentDTO) {

				System.out.println("EmployeeDAO getShipmentCount");
				return sqlSession.selectOne(namespace + ".getShipmentCountS", shipmentDTO);

			}
			
			public int getEmployeeCount(EmployeeDTO employeeDTO) {

				System.out.println("EmployeeDAO getEmployeeCount");
				return sqlSession.selectOne(namespace + ".getEmployeeCountE", employeeDTO);

			}

	
			// 메인 그래프용 매출 TOP5 지점들 가져오기
			public List<SalesDTO> getTop5() {
				System.out.println("EmployeeDAO getTop5()");
				return sqlSession.selectList(namespace+".getTop5");
			}



			public int getStoreCount(PageDTO pageDTO) {
				System.out.println("EmployeeDAO getStoreCount");
				return sqlSession.selectOne(namespace + ".getStoreCount");
			}


			public int getItemCount(PageDTO pageDTO) {
				System.out.println("EmployeeDAO getItemCount");
				return sqlSession.selectOne(namespace + ".getItemCount");
			}


			public int getOrderCount(PageDTO pageDTO) {
				System.out.println("EmployeeDAO getOrderCount");
				return sqlSession.selectOne(namespace + ".getOrderCount");
			}


			public int getShipmentCount(PageDTO pageDTO) {
				System.out.println("EmployeeDAO getShipmentCount");
				return sqlSession.selectOne(namespace + ".getShipmentCount");

			}


			public int getEmployeeCount(PageDTO pageDTO) {
				System.out.println("EmployeeDAO getEmployeeCount");
				return sqlSession.selectOne(namespace + ".getEmployeeCount");
			}

			public List<ShipmentDTO> getShipmentListEx() {
				System.out.println("EmployeeDAO getShipmentListEx()");
				return sqlSession.selectList(namespace+".getShipmentListEx");
			}


			public List<OrderDTO> getOrderListEx() {
				System.out.println("EmployeeDAO getOrderListEx()");
				return sqlSession.selectList(namespace+".getOrderListEx");
			}
	
	

	

}
