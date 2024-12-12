package com.itwillbs.security;

import java.io.IOException; // IO 예외 처리를 위한 클래스

import javax.servlet.ServletException; // 서블릿 관련 예외 처리를 위한 클래스
import javax.servlet.http.HttpServletRequest; // HTTP 요청 객체를 처리하기 위한 클래스
import javax.servlet.http.HttpServletResponse; // HTTP 응답 객체를 처리하기 위한 클래스

import org.springframework.security.access.AccessDeniedException; // 접근 거부 예외 클래스
import org.springframework.security.web.access.AccessDeniedHandler; // 접근 거부 처리 핸들러 인터페이스

// Spring Security에서 접근 거부 시 커스텀 처리를 위해 사용되는 클래스
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	// AccessDeniedException이 발생했을 때 호출되는 메소드
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		System.out.println("CustomAccessDeniedHandler handle()");
		
		// 권한이 부족하여 접근을 거부당한 경우, 해당 URL로 리다이렉트
		// request.getContextPath()는 애플리케이션의 기본 경로를 가져옴
		// "/emp/accessError"로 리다이렉트하여 권한 부족에 대한 안내 페이지를 보여줄 수 있음
		response.sendRedirect(request.getContextPath() + "/emp/accessError");
	}

}

/*
 * 동작 방식 및 설명: 
 * 1. 클래스 선언:
 * AccessDeniedHandler 인터페이스 : 사용자가 권한이 없을 때 발생하는 AccessDeniedException을 처리하는 데 사용 
 * 
 * 2. handle (): AccessDeniedException이 발생했을 때 호출
 * 매개변수
 * -HttpServletRequest request: 현재 HTTP 요청 객체 
 * -HttpServletResponse response: 현재 HTTP 응답 객체 
 * AccessDeniedException accessDeniedException: 접근 거부 예외 객체 
 * 이 메서드 내에서 발생한 예외를 처리한 후, 사용자를 지정된 URL로 리다이렉트하는 역할
 * 
 * 3. 리다이렉트 처리:
 * response.sendRedirect(request.getContextPath() + "/emp/accessError");는 사용자에게 권한이 없을 때 /emp/accessError URL로 리다이렉트하도록 설정
 * request.getContextPath()는 애플리케이션의 기본 경로를 반환합니다. 
 * 이 리다이렉트는 보통 사용자가 접근할 수 없는 페이지에 접근하려 할 때 안내 페이지나 오류 페이지로 이동시키는데 사용 
 */

/*
 * 동작 흐름: 
 * 1. 사용자가 권한이 없는 리소스에 접근하려고 할 때 AccessDeniedException이 발생합니다. 
 * 2. 이 예외를 CustomAccessDeniedHandler가 처리하게 되며, handle() 메서드가 호출됩니다. 
 * 3. handle() 메서드 내부에서는 사용자에게 /emp/accessError 페이지로 리다이렉트하는 방식으로 권한 부족 오류를 처리합니다.
 */