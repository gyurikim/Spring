<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<c:choose>
		<c:when test="${not empty name && not empty addr }">
			<p><strong>${dto.name }</strong>님 정보가 수정되었습니다</p>
		</c:when>
		<c:otherwise>
			<p>정보 수정을 실패하였습니다</p>
		</c:otherwise>
	</c:choose>
	
	</div>
</body>
</html>