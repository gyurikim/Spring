<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/login</title>
</head>
<body>
<c:choose>
	<c:when test="${isSuccess }">
		<p>${id }님 로그인 되었습니다</p>
		<a href="${pageContext.request.contextPath}/">확인</a>
	</c:when>
	<c:otherwise>
		<p>로그인 실패!</p>
		<a href="${pageContext.request.contextPath}/users/loginform.do">다시 로그인 하러가기</a>
	</c:otherwise>
</c:choose>
</body>
</html>