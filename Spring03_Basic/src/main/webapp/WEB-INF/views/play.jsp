<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/play</title>
</head>
<body>
	<h1>로그인된 회원 전용 공간입니다</h1>
	<p><strong>${id }</strong>님 환영합니다~</p>
	<a href="${pageContext.request.contextPath}/">인덱스로 가기</a>
</body>
</html>