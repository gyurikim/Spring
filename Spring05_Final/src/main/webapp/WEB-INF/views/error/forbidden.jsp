<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>
	<div class="container">
		<h1>금지된 요청입니다</h1>
		<p class="alert-link alert-danger">${msg } <a href="${pageContext.request.contextPath}/home.do">확인</a> </p>
	</div>
</body>
</html>