<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시 글 수정</h1>
	<form action="./update_content_process.do" method="post">
		작성자 : ${contentDataVo.memberVo.m_nick }<br>
		제목 : <input type="text" name="b_title" value="${contentDataVo.boardVo.b_title }"> <br>
		내용 : <br>
		<textarea rows="10" cols="40" name="b_content">${contentDataVo.boardVo.b_content }</textarea>
		<input type = "hidden" value="${contentDataVo.boardVo.b_no }" name="b_no"> 
		<input type="submit" value="글 수정">
	</form>

</body>
</html>