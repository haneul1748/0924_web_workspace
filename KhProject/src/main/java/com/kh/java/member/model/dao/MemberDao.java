package com.kh.java.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.member.model.vo.Member;

public class MemberDao {
	
	public Member login(SqlSession sqlSession, Member member) {
		// 설명할게 많다.
		return sqlSession.selectOne("memberMapper.login", member);
	}

}
