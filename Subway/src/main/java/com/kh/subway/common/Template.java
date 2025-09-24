package com.kh.subway.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template { 

	// Connection 객체의 역할을 대신할 SqlSession객체를 만들어서 반환해주는 메소드를 구현할 것
	
	public static SqlSession getsqlSession() {
		
		SqlSession sqlSession = null;
		
		// mybatis-config.xml 파일에 있는 내용을 읽어와서
		// 해당 DB와 접속된 SqlSession객체를 반환
		
		String config = "/mybatis-config.xml";
	
		// /는 모든 src폴더의 최상위 폴더라는 의미(classes)
		
		try {
			InputStream stream = Resources.getResourceAsStream(config);
			
			// 1단계 : SqlStreamFactoryBuilder 만들기
			// 만드는 방법 : 기본생성자를 호출한다.
			// new SqlSessionFactoryBuilder();
			// 2단계 : SqlSessionFactory 만들기
			// 만드는 방법 : 메소드를 호출한다
			// .build(접속 내용을 담은 파일을 읽어온 입력스트림);
			// 3단계 : SqlSession 만들기
			// 만드는 방법 : 메소드를 호출한다.
			// .openSession();
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
	
}
