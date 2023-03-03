package com.mhj.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mhj.s1.member.MemberDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	//Role이 Admin이면 통과
	//아니면 home.jsp로 보냄
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Contorller 진입 전");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		if(memberDTO != null) {
			if(memberDTO.getRoleDTOs().getRoleName().equals("ADMIN")) {
				return true;
			}
		}
		
		//로그인 X, Admin이 아닌 경우
		request.setAttribute("result", "권한이 없습니다.");
		request.setAttribute("URL", "../../../../");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		
		return false;
	}

}