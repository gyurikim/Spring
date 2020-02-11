<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="food" name="category"/>
</jsp:include>
	<div class="container">
		<h1>회원정보 수정하는 폼</h1>
		<form action="update.do" method="post">
			<input type="hidden" name="num" value="${dto.num }" />
			<div class="form-group">
				<label for="num">번호</label>
				<input class="form-control" type="text" name="num" id="num" value="${dto.num }" disabled="disabled"/>
			</div>
			<div class="form-group">
				<label for="menu">가게메뉴</label>
				<input class="form-control" type="text" name="menu" id="menu" value="${dto.menu }"/>
			</div>
			<div class="form-group">
				<label for="loc">가게위치</label>
				<select class="form-control" name="loc" id="loc" value="${dto.loc }">
		            <option value="">선택</option>
		            <option value="서울">서울</option>
		            <option value="경기">경기</option>
		            <option value="부산">부산</option>
		            <option value="제주">제주</option>
		        </select>
			</div>
			<button type="submit">수정 확인</button>
			<button type="reset">수정 취소</button>
		</form>
	</div>
</body>
</html>