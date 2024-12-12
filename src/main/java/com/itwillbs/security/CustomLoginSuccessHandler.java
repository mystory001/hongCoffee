package com.itwillbs.security;

import java.io.IOException;  // IO 예외 처리를 위한 클래스
import java.util.ArrayList;  // List 관련 클래스
import java.util.List;  // List 인터페이스

import javax.servlet.ServletException;  // 서블릿 관련 예외 처리를 위한 클래스
import javax.servlet.http.HttpServletRequest;  // HTTP 요청 객체를 처리하기 위한 클래스
import javax.servlet.http.HttpServletResponse;  // HTTP 응답 객체를 처리하기 위한 클래스

import org.springframework.security.core.Authentication;  // Spring Security에서 인증 정보를 담고 있는 Authentication 객체
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;  // 로그인 성공 후 동작을 처리하는 인터페이스

// 로그인 성공 후 특정 역할에 따라 페이지를 리다이렉트하는 클래스를 구현한 것
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    // 로그인 성공 시 호출되는 메서드
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                         Authentication authentication) throws IOException, ServletException {
        
        // 로그인 성공을 콘솔에 출력
        System.out.println("Login Success");

        // 사용자 역할을 저장할 리스트
        List<String> roleNames = new ArrayList<String>();

        // 인증 객체에서 사용자 권한(역할)을 가져와 리스트에 추가
        authentication.getAuthorities().forEach(authority -> {
            roleNames.add(authority.getAuthority());  // 각 권한 이름을 roleNames 리스트에 추가
        });

        // "ROLE_ADMIN" 권한이 있으면 관리자 페이지로 리다이렉트
        if (roleNames.contains("ROLE_ADMIN")) {
            // 관리자 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/emp/main?emp_num=" + request.getParameter("emp_num"));
            return;
        }

        // "ROLE_MEMBER" 권한이 있으면 멤버 페이지로 리다이렉트
        if (roleNames.contains("ROLE_MEMBER")) {
            // 멤버 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/emp/main?emp_num=" + request.getParameter("emp_num"));
            return;
        }

        // "ROLE_USER" 권한이 있으면 사용자 페이지로 리다이렉트
        if (roleNames.contains("ROLE_USER")) {
            // 사용자 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/store/main");
            return;
        }

        // 해당 역할이 없으면 기본 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/");
    }

}
