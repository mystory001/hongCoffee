package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	//	로그인 성공 후에 특정한 동작을 하도록 제어
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("Login Success");
		
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect(request.getContextPath() + "/emp/main?emp_num=" + request.getParameter("emp_num"));
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect(request.getContextPath() + "/emp/main?emp_num=" + request.getParameter("emp_num"));
			return;
		}
		
		if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect(request.getContextPath() + "/store/main");
			return;
		}
		
		response.sendRedirect(request.getContextPath() + "/");
	}

}
