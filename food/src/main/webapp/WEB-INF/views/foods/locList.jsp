<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>food/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
</head>
<body>
	<div class="container">
		<h1>맛집 리스트입니다</h1>
		<ol class="breadcrumb">
				<li><a href="#">서울</a></li>
				<li><a href="#">경기</a></li>
				<li><a href="#">부산</a></li>
				<li><a href="#">제주</a></li>
		</ol>
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>번호</th>
					<th>베스트 메뉴</th>
					<th>맛집 위치</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list2 }">
					<tr>
						<td>${tmp.num }</td>
						<td>${tmp.menu}</td>
						<td>${tmp.loc}</td>
						<td><a href="updateform.do?num=${tmp.num }">수정</a></td>
						<td><a href="delete.do?num=${tmp.num }">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="insertform.do">음식 추가하러가기</a>
	</div>
</body>
</html>
</body>
</html>