<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error/500.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>
	<div class="container">
		<h1>500</h1>
		<p class="alert alert-danger">요청 처리중에 오류가 발생했습니다. 빠른시일내에 복구하겠습니다<a href="${pageContext.request.contextPath}/home.do">확인YO!</a></p>
	</div>
</body>
</html>