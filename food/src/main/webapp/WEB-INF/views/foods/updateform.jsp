<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>회원정보 수정하는 폼</h1>
		<form action="update.do" method="post">
			<input type="hidden" name="num" value="${dto.num }" />
			<div>
				<label for="num">번호</label>
				<input type="text" name="num" id="num" value="${dto.num }" disabled="disabled"/>
			</div>
			<div>
				<label for="menu">가게메뉴</label>
				<input type="text" name="menu" id="menu" value="${dto.menu }"/>
			</div>
			<div>
				<label for="loc">가게위치</label>
				<input type="text" name="loc" id="loc" value="${dto.loc }"/>
			</div>
			<button type="submit">수정 확인</button>
			<button type="reset">수정 취소</button>
		</form>
	</div>
</body>
</html>