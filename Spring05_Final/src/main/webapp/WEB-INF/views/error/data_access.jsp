<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data_access.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>
	<div class="container">
		<h1>DB관련 예외 발생!!</h1>
		<p class="alert alert-danger">예외정보 : <strong>${exception.message }</strong></p>
		<a href="${pageContext.request.contextPath}/home.do">인덱스로 가기</a>
	</div>
</body>
</html>