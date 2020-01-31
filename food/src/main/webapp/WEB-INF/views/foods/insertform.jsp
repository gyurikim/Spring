<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
</head>
<body>
	<div class="container">
		<form action="insert.do" method="post">
			<div>
				<label for="menu">베스트 메뉴</label>
				<input type="text" id="menu" name="menu" />
			</div>
			<div>
				<label for="loc">맛집 위치</label>
				<input type="text" id="loc" name="loc" />
			</div>
			<button type="submit"> 리스트 추가</button>
			<button type="reset"> 취소</button>
		</form>
	</div>
</body>
</html>