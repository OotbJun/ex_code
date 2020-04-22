<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="./login_process.do" method="post">
		ID : <input type="text" name="m_id"><br>
		PW : <input type="password" name="m_pw"><br>
		<input type="submit" value="로그인">
		<a href="./join_member_page.do">회원가입</a>
	</form>
</body>
</html>