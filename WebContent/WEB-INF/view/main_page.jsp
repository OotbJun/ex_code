<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${!empty sessionUserInfo }">
		${sessionUserInfo.m_nick } 님 환영합니다. <br>
		<a href="./logout_process.do">로그아웃</a><br>
	</c:when>
	<c:otherwise>
		비회원으로 접급하였습니다. <a href="./login_page.do">로그인</a><br>
	</c:otherwise>
</c:choose>

<h1>메인 게시판</h1>
<table border = "1"> 
	<tr><td>글번호</td><td>글제목</td><td>작성자</td><td>작성일<td></tr>
	
	<c:forEach items="${contentList }" var="data">  
	<%-- data 라는 페이지 컨텍스트에 contentList의 개별 객체를 넣어준다  --%>
	<%-- items에는 컨트롤러 에서 리퀘스트 어트리뷰트 객체의 이름을 작성해준다. --%>
	<tr>
		<td>${data.boardVo.b_no } </td>
		<td><a href = "./read_content_page.do?b_no=${data.boardVo.b_no }">${data.boardVo.b_title } </a></td>
		<td>${data.memberVo.m_nick } </td>	
		<td>${data.boardVo.b_writedate } </td>
	</tr>
	</c:forEach>
</table>

<br>

	<c:if test="${!empty sessionUserInfo }">
	<a href="./write_content_page.do">글쓰기</a>
	</c:if>  <!-- 세션에서 뽑아오는 데이터가 null인지 판별한다 -->
</body>
</html>