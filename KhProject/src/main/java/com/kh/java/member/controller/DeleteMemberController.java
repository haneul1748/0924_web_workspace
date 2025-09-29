package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;

@WebServlet("/delete.me")
public class DeleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMemberController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 탈퇴란 뭘까?
		
		// 1. STATUS 컬럼으로 탈퇴여부를 지정 N으로 바꿔준다.
		// 2. 회원(행)을 식별할 식별값이 있어야함.
		// 3. 탈퇴에 성공하였다면 로그인 상태를 로그아웃으로 바꿔주고 마이페이지에서 -> 웰컴파일로
		
		// 현재 탈퇴 요청을 보낸 회원의 정보!!!
		// session에서 뽑아오는것이 안정적
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String userPwd = request.getParameter("userPwd");
		// 현재 요청 보낸 사용자를 식별할 수 있는 값
		Long userNo = ((Member)session.getAttribute("userInfo")).getUserNO();
		
		Member member = new Member();
		member.setUserPwd(userPwd);
		member.setUserNO(userNo);
		
		int result = new MemberService().delete(member);
		
		if(result > 0) {
			session.removeAttribute("userInfo");
			session.setAttribute("alertMsg", "안녕히가세요~");
			response.sendRedirect(request.getContextPath());
			
		} else {
			request.setAttribute("msg", "비밀번호를 확인하세요!");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.com").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
