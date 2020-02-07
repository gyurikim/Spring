<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/detail.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
<style>
	/* 글 내용을 출력할 div 에 적용할 css */
	.contents, table{
		width: 100%;
		border: 1px dotted #cecece;
		box-shadow: 3px 3px 5px 6px #ccc;
	}
	
	
</style>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="cafe" name="category"/>
</jsp:include>
<div class="container">
	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath }/cafe/list.do">목록</a></li>
		<li>글 상세 보기</li>
	</ol>
	

	<h3>카페 글 상세 보기</h3>
	<c:choose>
		<c:when test="${not empty keyword }">
			<p>검색어 <strong>${keyword }</strong> 로 검색된 <strong>${totalRow }</strong>개의 글이 있습니다</p>
		</c:when>
		<c:otherwise>
			<p><strong>${totalRow }</strong>개의 글이 있습니다</p>
		</c:otherwise>
	</c:choose>
	
	<table class="table table-bordered">
		<colgroup>
			<col class="col-xs-3"/>
			<col class="col-xs-9"/>
		</colgroup>
		<tr>
			<th>이전글</th>
			<td><c:if test="${dto.prevNum ne 0 }">
					<a href="detail.do?num=${dto.prevNum }&condition=${condition}&keyword=${encodedKeyword}">${dto.title }</a>
				</c:if>
				<c:if test="${dto.prevNum eq 0 }">
					<p style="margin-bottom: 0;">이전글이 존재하지 않습니다</p>	
				</c:if>	
			</td>
		</tr>
		<tr>
			<th>다음글</th>
			<td><c:if test="${dto.nextNum ne 0 }">
					<a href="detail.do?num=${dto.nextNum }&condition=${condition}&keyword=${encodedKeyword}">${dto.title }</a>
				</c:if>
				<c:if test="${dto.nextNum eq 0 }">
					<p style="margin-bottom: 0;">다음글이 존재하지 않습니다</p>	
				</c:if>	
			</td>
		</tr>
	</table>
	
	<table class="table table-bordered table-condensed">
		<colgroup>
			<col class="col-xs-3"/>
			<col class="col-xs-9"/>
		</colgroup>
		<tr>
			<th>글번호</th>
			<td>${dto.num }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${dto.regdate }</td>
		</tr>
	</table>
	<div class="contents">
		<textarea class="form-control" name="content" id="content" cols="30" rows="10" disabled="disabled">${dto.content }</textarea>
	</div>
	
	<button class="btn btn-default"><a href="list.do">목록 보기</a></button>
	
	<%-- 
		글 작성자와 로그인 된 아이디가 같을때만 기능을 제공해 준다. 
		즉, 본인이 작성한 글만 수정할수 있도록 하기 위해
	--%>

		<c:if test="${dto.writer eq sessionScope.id }">
			<button class="btn btn-warning"><a href="updateform.do?num=${dto.num }">수정</a></button>
			<button class="btn btn-danger"><a href="javascript:deleteConfirm()">삭제</a></button>
		</c:if>
		
		
		<form action="commupdate.do" methode="post">
			<div class="form-group">
			<input type="hidden" name="num" value="${dto.num}" />
				<p>관리자 구리구리의 댓글</p>
				<c:choose>
					<c:when test="${sessionScope.id eq 'gura' }">
						<textarea class="form-control" name="comm" id="comm" cols="20" rows="5" style="width: 90%; float: left;">${dto.comm }</textarea>
						<button class="btn" type="submit" style="width: 10%; height: 115px;">등록</button>
					</c:when>
					<c:otherwise>
						<textarea class="form-control" name="comm" id="comm" cols="20" rows="5" style="width: 90%; float: left;" disabled>${dto.comm }</textarea>
						<button class="btn" type="submit" style="width: 10%; height: 115px;" disabled>등록</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form>	

</div>
<script>
	function deleteConfirm(){
		var isDelete=confirm("글을 삭제 하시 겠습니까?");
		if(isDelete){
			location.href="delete.do?num= ${dto.num}";
		}
	}
</script>
</body>
</html>





