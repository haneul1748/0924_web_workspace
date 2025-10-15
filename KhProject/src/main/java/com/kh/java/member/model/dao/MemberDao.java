package com.kh.java.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.member.model.vo.Member;

public class MemberDao {
	
	public Member login(SqlSession sqlSession, Member member) {
		// 설명할게 많다.
		return sqlSession.selectOne("memberMapper.login", member);
	}
	
	public int signUp(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.singUp" ,member);
	}

	public int update(SqlSession session, Map<String, String> map) {
		return session.update("memberMapper.update", map);
	}
	
	public int delete(SqlSession session, Member member) {
		return session.update("memberMapper.delete", member);
	}
	
	public int updatePwd(SqlSession session, Map<String, String> map) {
		return session.update("memberMapper.updatePwd", map);
	}
	
	public String checkId(SqlSession sqlSession, String id) {
		return sqlSession.selectOne("memberMapper.checkId", id);
	}
}
