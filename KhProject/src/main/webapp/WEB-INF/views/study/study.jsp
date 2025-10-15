<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<h1>AJAX</h1>
	<h2>아주 중요!!! 별이 다섯개!!!★★★★★</h2>
	<pre>
		AJAX = Asynchronous JavaScript And XML
		"페이지를 새로고침하지않고 서버와 데이터를 주고받을 수 있는 기술"
		"비동기 통신"
		
		우리가 그동안 개발했던 방식은 동기방식
		동기방식 : 
		1. 사용자가 버튼 클릭
		2. 서버가 요청을 받고 전체 HTML데이터를 응답
		3. 브라우저가 전체 페이지 다시 로딩 -> 화면 전체 깜빡임
		
		비동기 방식 : 
		1. 사용자가 버튼 클릭
		2. JavaScript를 이용해서 데이터만 서버로 띡 전송
		3. 서버는 JSON/XML데이터만 응답
		4. JavaScript를 이용해서 필요한 부분만 생신 -> 부드럽고, 빠름
		
		<hr>
		
		<h3>AJAX 장단점</h3>
		
		장점 : 사용자 경험(U.X)향상
			  서버 부하 감소
			  네트워크 트래픽 절약
			  실시간성 구현 가능
	 	
	 	단점 : SEO에 취약함
	 	   	  브라우저 히스토리 관리 복잡
	 	   	  JavaScript 의존성
	 	   	  보안 취약점 증가 (XSS)
	 	   
	 	SPA(Single Page Application) 전성시대
	 	React, Vue, Angular => AJAX기반 라이브러리 및 프레임워크
	 	
	</pre>
	
	<h2>JSON</h2>
	
	<pre>
		홍길동(hong)
		
		인천의전사독 재미따
		
		댓글 0		따봉개수 2 야유개수 1
		
		<reply>
		<nickName>홍길동</nickName>
		<id>hong</id>
		<reply></reply>
		<tabom>2</tabom>
		<uuuu>1</uuuu>
		</reply>
		(구세대 방식)
		
		reply : {
			"nickName" : "홍길동",
			"id" : "hong",
			"content" : "아하하 인천의 전사독 너무 재밌고",
			reply : [],
			tabom : 2,
			uuuu : 1
		}
		(표준방식)
		JSON == JavaScript Object Notation
		
		"사람이 읽기 쉽고, 기계가 파싱하기 쉬운 데이터 교환 형식"
		텍스트 기반이라 아주 가볍다
		
		진짜로 자바스크립트는 아니다★★★★★ 자바스크립트 객체모양으로 문자열을 만든거
		문법이 아주 엄격함!! 자바스크립트 객체
		{
			name : "홍길동", 		// 키에 따옴표 없음 가능
			age : 15, 			// 작은 따옴표 사용가능
			address : '서울',		// 마지막 속성값에 컴마 가능
		}
		
		Json 형식
		{
			"name" : "홍길동",
			"address" : "서울",
			"age" : 15
		}
		장점 : 
		다곧성이 뛰어남(XML과 비교해서 훨씬 읽기 쉬움)
		데이터 자체가 가볍다.(XML대비해서 30%더 가벼움)
		파싱 속도 빠름
		언어 독립적
		JavaScript 네이티브 지원
		
		단점 :
		주석 불가
		날짜 타입 없음(문자열로 처리)
		함수 불가능
		
		웹개발의 표준!!! 데이터 형식
		Rest API의 기본 포맷!!!
		설정파일XML -> JSON(설정 파일은 YAML이 더 인기있음)
	</pre>
	
	<pre>
		우리는 AJAX를 이용해서 아이디 중복체크기능을 구현해볼 예정
		근데 시간이 애매해서 그냥 다음주에 댓글까지 하겠음 아이디 중복체크 + 댓글기능
		AJAX사용방법
		1. XMLHTTPRequest 객체 사용하기				-
		2. jQuery 사용해서 Aajax메소드 호출하기			+
		3. fetch API 활용해서 fetch호출하기			+
		4. Reacr 배울 때 Axios라이브러리 설치해서 사용하기	+
	</pre>
	
	<pre>
		* JQuery를 사용한 AJAX 통신
		[ 표현법 ]
		
		// 자바 스크립트에서 값 여러개 다룰 때 사용하는거
		// 1. 배열 | 2. 객체
		$.ajax({
			속성명 : 값,
			속성명 : 값,
			속성명 : 값,	
			...
		});  =========> 4일 동안 숙제 : Web으로 CRUD구현 + 인터페이스 / 다형성 / J.S복습
		
		* 주요 속성
		 - url : 요청할 URL(필수로 작성) => form태그의 action 속성
		 - type : 요청 전송방식(GET/POST... FETCH, PUT, DELETE, OPTION...)
		          => form 태그의 method속성
		 - data : 요청 시 전달 값({키 : 밸류, 키 : 밸류}) => form 태그의 inputd요소 value값
		 - sucess : 통신 성공 시 실행할 콜박 함수를 정의
		 -------------------------------------------------------------------------------------
		 - error : 통신 실패 시 실행할 콜백함수를 정의
		 - complete : 성공하든 실해하든 무조건 끝나면 실행할 콜백함수를 정의
		  
		
		
		
	</pre>
	
	<h2>jQuery를 사용한 AJAX요청 및 응답</h2>
	
	<h3>1. 버튼을 클릭하여 서버에 데이터를 전송하고 단순 문자열 데이터 응답받기</h3>
	
	<div class="form-group">
		<div class="form-control">
		입력 : <input type="text" id="input1" />
		</div>
		<div class="form-control">
			<button class="btn-sm btn-primary" id="btn1">요청보내기!</button>
		</div>
	</div>
	
	응답 : <label id="output1">응답 없음</label>
	
	<script>
		
		// 요청 보내기 버튼을 클릭하면!!
		$('#btn1').click(function(){
			
			// 동기식 요청
			// location.href = "ajax1.do?input1=머시기";
			
			// 비동기식 요청(jQuery 버전)
			
			$.ajax({
				url : "ajax1.do",
				type : "get",
				data : {
					value : $('#input1').val()
				},
				success : function(result) {
					console.log("AJAX요청 성공 !");
					console.log(result);
					$("#output1").text(result);
				},
				error : function() {
					console.log("AJAX요청 실패 !");
				},
				complete : function() {
					console.log("무조껀함!");
				}
			});
		});
	
	</script>
	
	<hr>
	
	<h3>2. 버튼 클릭 시 DB조회 결과 응답</h3>
	
	아이디 : <input type="text" id="userId" /> <br>
	비밀번호 : <input type="password" id="userPwd" /> <br>
	<button onclick="memberInfo();">정보조회</button>
	
	<br/><br/>
	사용자 이름 : <label id="name">현재 응답 없음</label>
	사용자 이메일 : <label id="email">현재 응답 없음</label>
	
	<script>
		function memberInfo(){
			$.ajax({
				url : "ajax2.do",
				type : "post",
				data : {
					id : $('#userId').val(),
					pwd : $('#userPwd').val()
				},
				success : function(response) {
					console.log("AJAX요청 성공!");
					console.log(response);
					// $('#name').text(response[0]); 1 배열 인덱스로 뽑기
					// $('#email').text(response[1]); 2
					
					$('#name').text(response.name); // 한눈에 보기쉽고 해석하기 쉬움
					$('#email').text(response.email); 
				},
				error : function(e) {
					console.log(e);
				}
			});
		}
	</script>
	
	<h3>3. 서버로 요청 후, 여러 개의 객체 응답받아 출력해보기</h3>
	
	<br>
	
	아이디 입력 : <input type="text" id="search-id"/>
	
	<table id="table-result" class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	
	<button class="btn btn-sm btn-danger" onclick="find();">게시글 조회</button>
	
	<script>
		function find() {
			
			$.ajax({
				url : "ajax3.do",
				type : "get",
				success : function(result){
					// console.log(result);
				
					let str = '';
					
					for(e of result) {
						// console.log(e.board);
						const board = e.board;
						str += `
								<tr>
									<td>\${board.boardNo}</td>
									<td>\${board.boardTitle}</td>
									<td>\${board.boardWriter}</td>
								</tr>
								`;
					}
					$('tbody').html(str);
				}
			});
			
			
			
		}
	</script>
</body>
</html>