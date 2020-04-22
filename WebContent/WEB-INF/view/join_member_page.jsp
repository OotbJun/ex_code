<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원가입</h1>
	<form action="./join_member_process.do" method="post">
		ID : <input type="text" name="m_id"><br>
		PW : <input type="password" name="m_pw"><br>
		Nick : <input type="text" name="m_nick"><br>
		Phone : <input type="text" name="m_phone"><br>
		<input type="submit" value = "회원가입">
	</form>
</body>
</html>