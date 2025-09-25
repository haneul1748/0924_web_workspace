package com.kh.java.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.common.Template;
import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.Member;

public class MemberService {

	private MemberDao md = new MemberDao();
	
	public Member login(Member member) {
		// 로그인 처리 -> DAO에 보내서 있나없나 -> 결과값 반환
		// validateMember(member);
		SqlSession sqlSession = Template.getsqlSession();
		
		Member loginMember = md.login(sqlSession, member);
		
		sqlSession.close();
		
		return loginMember;
	}
	
	public void validateMember(Member member) {
		
		if(member.getUserId() == null || member.getUserId().trim().isEmpty()) {
			return;
		}
		
		String pattern = "^[a-zA-Z0-9]{4,20}$";
		if(!member.getUserId().matches(pattern)) {
			return;
		}
		
		// 비밀번호 검증 로직
		
		
	}
}
