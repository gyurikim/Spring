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
	
	/* 댓글에 관련된 css */
	.comments ul{
		padding: 0;
		margin: 0;
		list-style-type: none;
	}
	.comments ul li{
		border-top: 1px solid #888; /* li 의 윗쪽 경계선 */
	}
	.comments dt{
		margin-top: 5px;
	}
	.comments dd{
		margin-left: 26px;
	}
	.comments form textarea, .comments form button{
		float: left;
	}
	.comments li{
		clear: left;
	}
	.comments form textarea{
		width: 85%;
		height: 100px;
	}
	.comments form button{
		width: 15%;
		height: 100px;
	}
	/* 댓글에 댓글을 다는 폼과 수정폼을 일단 숨긴다. */
	.comment form{
		display: none;
	}
	.comment{
		position: relative;
	}
	.comment .reply_icon{
		width: 8px;
		height: 8px;
		position: absolute;
		top: 10px;
		left: 30px;
	}
	.comments .user-img{
		width: 20px;
		height: 20px;
		border-radius: 50%;
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
		
		<div class="comments">
			<ul>
				<c:forEach items="${commentList }" var="tmp">
					<c:choose>
						<c:when test="${tmp.deleted ne 'yes' }">
							<li class="comment" id="comment${tmp.num }" <c:if test="${tmp.num ne tmp.comment_group }">style="padding-left:50px;"</c:if> >
								<c:if test="${tmp.num ne tmp.comment_group }">
									<img class="reply_icon" src="${pageContext.request.contextPath}/resources/images/re.gif"/>
								</c:if>
								<dl>
									<dt>
										<c:choose>
											<c:when test="${empty tmp.profile }">
												<img class="user-img" src="${pageContext.request.contextPath}/resources/images/default_user.jpeg"/>
											</c:when>
											<c:otherwise>
												<img class="user-img" src="${pageContext.request.contextPath}${tmp.profile}"/>
											</c:otherwise>
										</c:choose>
										
										<span>${tmp.writer }</span>
										<c:if test="${tmp.num ne tmp.comment_group }">
											to <strong>${tmp.target_id }</strong>
										</c:if>
										<span>${tmp.regdate }</span>
										<a href="javascript:" class="reply_link">답글</a> |
										<c:choose>
											<%-- 로그인된 아이디와 댓글의 작성자가 같으면 --%>
											<c:when test="${id eq tmp.writer }">
												<a href="javascript:" class="comment-update-link">수정</a>&nbsp;&nbsp;
												<a href="javascript:deleteComment(${tmp.num })">삭제</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:">신고</a>
											</c:otherwise>
										</c:choose>
									</dt>
									<dd>
										<pre>${tmp.content }</pre>
									</dd>
								</dl>
								<form class="comment-insert-form" action="comment_insert.do" method="post">
									<!-- 덧글 그룹 -->
									<input type="hidden" name="ref_group" value="${dto.num }" />
									<!-- 덧글 대상 -->
									<input type="hidden" name="target_id" value="${tmp.writer }" />
									<input type="hidden" name="comment_group" value="${tmp.comment_group }" />
									<textarea name="content"><c:if test="${empty id }">로그인이 필요합니다.</c:if></textarea>
									<button type="submit">등록</button>
								</form>	
								<!-- 로그인한 아이디와 댓글의 작성자와 같으면 수정폼 출력 -->				
								<c:if test="${id eq tmp.writer }">
									<form class="comment-update-form" action="comment_update.do">
										<input type="hidden" name="num" value="${tmp.num }" />
										<textarea name="content">${tmp.content }</textarea>
										<button type="submit">수정</button>
									</form>
								</c:if>
							</li>				
						</c:when>
						<c:otherwise>
							<li <c:if test="${tmp.num ne tmp.comment_group }">style="padding-left:50px;"</c:if> >삭제된 댓글 입니다.</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</ul>
			<div class="clearfix"></div>

			<!-- 원글에 댓글을 작성할수 있는 폼 -->
			<div class="comment_form">
				<form action="comment_insert.do" method="post">
					<!-- 댓글의 그룹번호는 원글의 번호 -->
					<input type="hidden" name="ref_group" value="${dto.num}" />
					<!-- 댓글의 대상자는 원글의 작성자 -->
					<input type="hidden" name="target_id" value="${dto.writer}" />
					<textarea name="content">
						<c:if test="${empty id }">로그인을 먼저 해주세요</c:if>
					</textarea>
					<button type="submit">등록</button>
				</form>
			</div>
		</div>
</div>
<script>
	//댓글 수정 링크를 눌렀을때 호출되는 함수 등록
	$(".comment-update-link").click(function(){
		$(this)
		.parent().parent().parent()
		.find(".comment-update-form")
		.slideToggle(200);
	});
	
	//댓글 수정 폼에 submit 이벤트가 일어났을때 호출되는 함수 등록
	$(".comment-update-form").on("submit", function(){
		// "private/comment_update.do"
		var url=$(this).attr("action");
		//폼에 작성된 내용을 query 문자열로 읽어온다.
		// num=댓글번호&content=댓글내용
		var data=$(this).serialize();
		//이벤트가 일어난 폼을 선택해서 변수에 담아 놓는다.
		var $this=$(this);
		$.ajax({
			url:url,
			method:"post",
			data:data,
			success:function(responseData){
				// responseData : {isSuccess:true}
				if(responseData.isSuccess){
					//폼을 안보이게 한다 
					$this.slideUp(200);
					//폼에 입력한 내용 읽어오기
					var content=$this.find("textarea").val();
					//pre 요소에 수정 반영하기 
					$this.parent().find("pre").text(content);
				}
			}
		});
		//폼 제출 막기 
		return false;
	});
	
	//댓글 삭제를 눌렀을때 호출되는 함수
	function deleteComment(num){
		var isDelete=confirm("확인을 누르면 댓글이 삭제 됩니다.");
		if(isDelete){
			$.ajax({
				url:"comment_delete.do",
				method:"post",
				data:{"num":num},
				success:function(responseData){
					if(responseData.isSuccess){
						var sel="#comment"+num;
						$(sel).text("삭제된 댓글 입니다.");
					}
				}
			});
		}
	}
	
	//폼에 submit 이벤트가 일어 났을때 실행할 함수 등록 
	$(".comments form").on("submit", function(){
		//로그인 여부
		var isLogin=${not empty id};
		if(isLogin==false){
			alert("로그인 페이지로 이동 합니다.");
			location.href="${pageContext.request.contextPath}/users/loginform.do?url=${pageContext.request.contextPath}/cafe/detail.do?num=${dto.num}";
			return false;//폼 전송 막기 
		}
	});
	
	//답글 달기 링크를 클릭했을때 실행할 함수 등록
	$(".comment .reply_link").click(function(){
		$(this)
		.parent().parent().parent()
		.find(".comment-insert-form")
		.slideToggle(200);
		
		// 답글 <=> 취소가 서로 토글 되도록 한다. 
		if($(this).text()=="답글"){
			$(this).text("취소");
		}else{
			$(this).text("답글");
		}
	});
	function deleteConfirm(){
		var isDelete=confirm("글을 삭제 하시 겠습니까?");
		if(isDelete){
			location.href="delete.do?num= ${dto.num}";
		}
	}
</script>
</body>
</html>




