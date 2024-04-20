package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.OrderDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.domain.ShipmentDTO;
import com.itwillbs.service.EmployeeService;

@Controller
@RequestMapping("/excel/*")
public class ExcelController {
	
	@Inject
	private EmployeeService employeeService;
	
	@GetMapping("/orderList")
	public void orderList(HttpServletRequest request, HttpServletResponse response, Model model,PageDTO pageDTO) throws Exception {
		System.out.println("ExcelController orderList()");
		
		List<OrderDTO> orderList = employeeService.getOrderListEx();
		
		//워크북 생성
		Workbook o_wb = new HSSFWorkbook();
		Sheet o_sheet = o_wb.createSheet("수주 목록");
		Row o_row = null;
		Cell o_cell = null;
		int o_rowNo = 0;
		
		Font o_font = o_wb.createFont();
		o_font.setBold(true);
		
		//테이블 헤더용 스타일 - 컬럼
		CellStyle o_headStyle = o_wb.createCellStyle(); //스타일 선언
		o_headStyle.setBorderTop(BorderStyle.THIN); //셀 위 테두리 실선 적용
		o_headStyle.setBorderBottom(BorderStyle.THIN); //셀 아래 테두리 실선 적용
		o_headStyle.setBorderLeft(BorderStyle.THIN); //셀 왼쪽 테두리 실선 적용
		o_headStyle.setBorderRight(BorderStyle.THIN); //셀 오른쪽 테두리 실선 적용
		o_headStyle.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex()); //셀 배경색
		o_headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		o_headStyle.setAlignment(HorizontalAlignment.CENTER); //가로 가운데 정렬
		o_headStyle.setVerticalAlignment(VerticalAlignment.CENTER); //세로 가운데 정렬
		o_headStyle.setFont(o_font); //font 적용
		 
		//데이터용 경계 스타일 테두리 지정 - 데이터
		CellStyle o_bodyStyle = o_wb.createCellStyle();
		o_bodyStyle.setBorderTop(BorderStyle.THIN);
		o_bodyStyle.setBorderBottom(BorderStyle.THIN);
		o_bodyStyle.setBorderLeft(BorderStyle.THIN);
		o_bodyStyle.setBorderRight(BorderStyle.THIN);
		o_bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		o_bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		//헤더 생성
		String[] o_arr = {"거래번호", "지점명", "재료명", "수주량", "단가", "총금액", "수주일시", "출하여부", "발주적요", "수주적요"};
		o_row = o_sheet.createRow(o_rowNo++);
		for(int i = 0; i < o_arr.length; i++) {
			o_cell = o_row.createCell(i);
			o_cell.setCellStyle(o_headStyle);
			o_cell.setCellValue(o_arr[i].toString());
		}
		
		//데이터 부분 생성
		for(OrderDTO orderDTO : orderList) {
			o_row = o_sheet.createRow(o_rowNo++);			
			o_sheet.autoSizeColumn(0);
			o_sheet.setColumnWidth(0, (o_sheet.getColumnWidth(0))+1024);
			o_cell = o_row.createCell(0);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getOd_num());
			
			o_sheet.autoSizeColumn(1);
			o_sheet.setColumnWidth(1, (o_sheet.getColumnWidth(1))+1024);
			o_cell = o_row.createCell(1);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getName());
			
			o_sheet.autoSizeColumn(2);
			o_sheet.setColumnWidth(2, (o_sheet.getColumnWidth(2))+1024);
			o_cell = o_row.createCell(2);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getItem_name());
			
			o_sheet.autoSizeColumn(3);
			o_sheet.setColumnWidth(3, (o_sheet.getColumnWidth(3))+1024);
			o_cell = o_row.createCell(3);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getOd_amount());
			
			o_sheet.autoSizeColumn(4);
			o_sheet.setColumnWidth(4, (o_sheet.getColumnWidth(4))+1024);
			o_cell = o_row.createCell(4);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getItem_price());
			
			o_sheet.autoSizeColumn(5);
			o_sheet.setColumnWidth(5, (o_sheet.getColumnWidth(5))+1024);
			o_cell = o_row.createCell(5);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getOd_amount()*orderDTO.getItem_price());
			
			o_sheet.autoSizeColumn(6);
			o_sheet.setColumnWidth(6, (o_sheet.getColumnWidth(6))+1024);
			o_cell = o_row.createCell(6);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getOd_time().toString());
			
			o_sheet.autoSizeColumn(7);
			o_sheet.setColumnWidth(7, (o_sheet.getColumnWidth(7))+1024);
			o_cell = o_row.createCell(7);
			o_cell.setCellStyle(o_bodyStyle);
			if(orderDTO.getShipment_not() == 0) {
				o_cell.setCellValue("미출하");
			} else {
				o_cell.setCellValue("출하완료");
			}
			
//			o_sheet.autoSizeColumn(8);
//			o_sheet.setColumnWidth(8, (o_sheet.getColumnWidth(8))+1024);
//			o_cell = o_row.createCell(8);
//			o_cell.setCellStyle(o_bodyStyle);
//			if(orderDTO.getReceived_not() == 0) {
//				o_cell.setCellValue("미입고");
//			} else {
//				o_cell.setCellValue("입고완료");
//			}
			
			o_sheet.autoSizeColumn(8);
			o_sheet.setColumnWidth(8, (o_sheet.getColumnWidth(8))+1024);
			o_cell = o_row.createCell(8);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getOd_note());
			
			o_sheet.autoSizeColumn(9);
			o_sheet.setColumnWidth(9, (o_sheet.getColumnWidth(9))+924);
			o_cell = o_row.createCell(9);
			o_cell.setCellStyle(o_bodyStyle);
			o_cell.setCellValue(orderDTO.getOb_note());
		}
		
		//엑셀 파일 생성
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=orderList.xlsx");
		o_wb.write(response.getOutputStream());
		o_wb.close();
	}//orderList
	
	@GetMapping("/shipmentList")
	public void shipmentList(HttpServletRequest request, HttpServletResponse response, Model model, PageDTO pageDTO) throws Exception {
		System.out.println("ExcelController shipmentList()");
		
		List<ShipmentDTO> shipmentList = employeeService.getShipmentListEx();
		
		//워크북 생성
		Workbook s_wb = new HSSFWorkbook();
		Sheet s_sheet = s_wb.createSheet("출하 목록");
		Row s_row = null;
		Cell s_cell = null;
		int s_rowNo = 0;
		
		Font s_font = s_wb.createFont();
		s_font.setBold(true);
		
		//테이블 헤더용 스타일 - 컬럼
		CellStyle s_headStyle = s_wb.createCellStyle(); //스타일 선언
		s_headStyle.setBorderTop(BorderStyle.THIN); //셀 위 테두리 실선 적용
		s_headStyle.setBorderBottom(BorderStyle.THIN); //셀 아래 테두리 실선 적용
		s_headStyle.setBorderLeft(BorderStyle.THIN); //셀 왼쪽 테두리 실선 적용
		s_headStyle.setBorderRight(BorderStyle.THIN); //셀 오른쪽 테두리 실선 적용
		s_headStyle.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex()); //셀 배경색
		s_headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		s_headStyle.setAlignment(HorizontalAlignment.CENTER); //가로 가운데 정렬
		s_headStyle.setVerticalAlignment(VerticalAlignment.CENTER); //세로 가운데 정렬
		s_headStyle.setFont(s_font); //font 적용
		 
		//데이터용 경계 스타일 테두리 지정 - 데이터
		CellStyle s_bodyStyle = s_wb.createCellStyle();
		s_bodyStyle.setBorderTop(BorderStyle.THIN);
		s_bodyStyle.setBorderBottom(BorderStyle.THIN);
		s_bodyStyle.setBorderLeft(BorderStyle.THIN);
		s_bodyStyle.setBorderRight(BorderStyle.THIN);
		s_bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		s_bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		//헤더 생성
		String[] s_arr = {"거래번호", "지점명", "재료명", "출하량", "단가", "총금액", "출하일시", "입고여부", "결제여부", "출하적요"};
		s_row = s_sheet.createRow(s_rowNo++);
		for(int i = 0; i < s_arr.length; i++) {
			s_cell = s_row.createCell(i);
			s_cell.setCellStyle(s_headStyle);
			s_cell.setCellValue(s_arr[i].toString());
		}
		
		//데이터 부분 생성
		for(ShipmentDTO shipmentDTO : shipmentList) {
			s_row = s_sheet.createRow(s_rowNo++);			
			s_sheet.autoSizeColumn(0);
			s_sheet.setColumnWidth(0, (s_sheet.getColumnWidth(0))+1024);
			s_cell = s_row.createCell(0);
			s_cell.setCellStyle(s_bodyStyle);
			s_cell.setCellValue(shipmentDTO.getOd_num());
			
			s_sheet.autoSizeColumn(1);
			s_sheet.setColumnWidth(1, (s_sheet.getColumnWidth(1))+1024);
			s_cell = s_row.createCell(1);
			s_cell.setCellStyle(s_bodyStyle);
			s_cell.setCellValue(shipmentDTO.getName());
			
			s_sheet.autoSizeColumn(2);
			s_sheet.setColumnWidth(2, (s_sheet.getColumnWidth(2))+1024);
			s_cell = s_row.createCell(2);
			s_cell.setCellStyle(s_bodyStyle);
			s_cell.setCellValue(shipmentDTO.getItem_name());
			
			s_sheet.autoSizeColumn(3);
			s_sheet.setColumnWidth(3, (s_sheet.getColumnWidth(3))+1024);
			s_cell = s_row.createCell(3);
			s_cell.setCellStyle(s_bodyStyle);
			s_cell.setCellValue(shipmentDTO.getSh_amount());
			
			s_sheet.autoSizeColumn(4);
			s_sheet.setColumnWidth(4, (s_sheet.getColumnWidth(4))+1024);
			s_cell = s_row.createCell(4);
			s_cell.setCellStyle(s_bodyStyle);
			s_cell.setCellValue(shipmentDTO.getItem_price());
			
			s_sheet.autoSizeColumn(5);
			s_sheet.setColumnWidth(5, (s_sheet.getColumnWidth(5))+1024);
			s_cell = s_row.createCell(5);
			s_cell.setCellStyle(s_bodyStyle);
			s_cell.setCellValue(shipmentDTO.getSh_amount() * shipmentDTO.getItem_price());
			
			s_sheet.autoSizeColumn(6);
			s_sheet.setColumnWidth(6, (s_sheet.getColumnWidth(6))+1024);
			s_cell = s_row.createCell(6);
			s_cell.setCellStyle(s_bodyStyle);
			s_cell.setCellValue(shipmentDTO.getSh_time().toString());
			
			s_sheet.autoSizeColumn(7);
			s_sheet.setColumnWidth(7, (s_sheet.getColumnWidth(7))+1024);
			s_cell = s_row.createCell(7);
			s_cell.setCellStyle(s_bodyStyle);
			if(shipmentDTO.getReceived_not() == 0) {
				s_cell.setCellValue("미입고");
			} else {
				s_cell.setCellValue("입고완료");
			}
			
			s_sheet.autoSizeColumn(8);
			s_sheet.setColumnWidth(8, (s_sheet.getColumnWidth(8))+1024);
			s_cell = s_row.createCell(8);
			s_cell.setCellStyle(s_bodyStyle);
			if(shipmentDTO.getPay() == 0) {
				s_cell.setCellValue("미결제");
			} else {
				s_cell.setCellValue("결제완료");
			}
			
			s_sheet.autoSizeColumn(9);
			s_sheet.setColumnWidth(9, (s_sheet.getColumnWidth(9))+1024);
			s_cell = s_row.createCell(9);
			s_cell.setCellStyle(s_bodyStyle);
			s_cell.setCellValue(shipmentDTO.getSh_note());
		}
		
		//엑셀 파일 생성
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=shipmentList.xlsx");
		s_wb.write(response.getOutputStream());
		s_wb.close();
	}//shipmentList


}
