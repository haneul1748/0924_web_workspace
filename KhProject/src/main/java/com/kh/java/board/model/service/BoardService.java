package com.kh.java.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.board.model.dao.BoardDao;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.board.model.vo.Category;
import com.kh.java.common.PageInfo;
import com.kh.java.common.Template;

public class BoardService {
	
	private BoardDao bd = new BoardDao();
	
	public int selectListCount() {
		
		SqlSession sqlSession = Template.getsqlSession();
		
		int listCount = bd.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public List<Board> selectBoardList(PageInfo pi) {
		SqlSession sqlSession = Template.getsqlSession();
		
		List<Board> boards = bd.selectBoardList(sqlSession, pi);
		
		sqlSession.close();
		
		return boards;
	}
	
	public List<Category> selectCategory() {
		SqlSession sqlSession = Template.getsqlSession();
		
		List<Category> categories = bd.selectCategory(sqlSession);
		
		sqlSession.close();
		
		return categories;
	}
	
	public void insert(Board board, Attachment at) {
		
		SqlSession sqlSession = Template.getsqlSession();
		
		// INSERT를 두 번 수행
		
		// BOARD테이블에 한 번 => 무조건
		int boardResult = bd.insertBoard(sqlSession, board);
		// ATTACHMENT테이블에 한 번 => 파일이 존재할 때만 가야함
		
		// 두 개의 DML구문을 하나의 트랜잭션으로 묶어서 처리
		
		// 트랜잭션처리까지 끝내고 난 후 성공실패여부를 반환
		
		
	}
}
