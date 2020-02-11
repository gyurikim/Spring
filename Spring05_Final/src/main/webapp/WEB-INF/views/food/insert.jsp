<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/insert</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
</head>
<body>
	<c:choose>
		<c:when test="${not empty dto.menu && not empty dto.loc }">
			<script>
				alert("정보를 저장하였습니다");
				location.href="list.do";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("정보를 저장을 실패하였습니다");
				location.href="insertform.do";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>