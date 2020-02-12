<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>food/list.jsp</title>
<jsp:include page="../include/resource.jsp"/>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="food" name="category"/>
</jsp:include>
	<div class="container">
		<h1>맛집 리스트입니다</h1>
		<ul class="nav navbar-nav">
			<li><a href="list.do">전체</a></li>
			<li><a href="locList.do?loc=서울">서울</a></li>
			<li><a href="locList.do?loc=경기">경기</a></li>
			<li><a href="locList.do?loc=부산">부산</a></li>
			<li><a href="locList.do?loc=제주">제주</a></li>
		</ul>
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
				<c:forEach var="tmp" items="${list }">
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

	
		<div class="page-display">
		<ul class="pagination pagination-sm">
		<c:choose>
			<c:when test="${startPageNum ne 1 }">
				<li>
					<a href="list.do?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${encodedKeyword}">&laquo;</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="disabled">
					<a href="javascript:">&laquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }" step="1">
			<c:choose>
				<c:when test="${i eq pageNum }">
					<li class="active">
						<a href="list.do?pageNum=${i }&condition=${condition}&keyword=${encodedKeyword}">${i }</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="list.do?pageNum=${i }&condition=${condition}&keyword=${encodedKeyword}">${i }</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum lt totalPageCount }">
					<li>
						<a href="list.do?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${encodedKeyword}">&raquo;</a>
					</li>
				</c:when>
			<c:otherwise>
				<li class="disabled">
					<a href="javascript:">&raquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>
</div>

</body>
</html>