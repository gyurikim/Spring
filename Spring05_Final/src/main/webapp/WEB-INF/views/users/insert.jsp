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
		<p><strong>${dto.id }</strong>님 가입 되었습니다</p>
		<a href="${pageContext.request.contextPath}/users/loginform.do">로그인하러가기</a>
	</div>
</body>
</html>