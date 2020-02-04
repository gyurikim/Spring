<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/info.jsp</title>	<!-- private 하위의 요청은 LoginFilter로 거르기. 로그인 안한 상태에서 url로 info.jsp 경로를 입력했을 때 로그인을 우선할 수 있도록-->
<jsp:include page="../include/resource.jsp"></jsp:include>
<style>
	/* 프로필 이미지가 가로 세로 50px 인 원형으로 표시될 수 있도록*/
	#profileLink img{
		width: 50px;
		height: 50px;
		border-radius: 50%;	
	}
	#profileForm{
		display: none;
	}
</style>
</head>
<body>
<jsp:include page="../include/navbar.jsp"></jsp:include>
<div class="container">
	<h1>개인정보 페이지</h1>
	<table class="table table-bordered">
		<tr>
			<th>아이디</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>프로필 이미지</th>
			<td>
				<a href="javascript:" id="profileLink">
					<c:choose>
						<c:when test="${empty dto.profile }"> <!-- 프로필 이미지가 등록이 되어있지 않은경우 -->
							<img src="${pageContext.request.contextPath }/resources/images/default_user.jpeg" alt="" />
						</c:when>
						<c:otherwise>
							<img src="${pageContext.request.contextPath }${dto.profile}" alt="" />	<!-- 경로를 출력. upload폴더에 저장을 해두고. /upload/14245152xx.jpg -->
						</c:otherwise>
					</c:choose>
				</a>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><a href="pwd_updateform.do">수정하기</a></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${dto.email }</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${dto.regdate }></td>
		</tr>
	</table>
	<a class="btn btn-primary btn-sm" href="updateform.do">개인 정보 수정하기</a>
	<a class="btn btn-danger btn-sm" href="javascript:deleteConfirm();">회원 탈퇴</a>
</div>
<form action="profile_upload.do" method="post" enctype="multipart/form-data" id="profileForm">
	<label for="profile">프로필 이미지 선택</label>
	<input type="file" name="profileImage" id="profileImage" accept=".jpg, .jpeg, .png, .JPG, .JPEG" />	<%-- 확장자를 정해준 것만 보이도록 한다. --%>
</form>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.min.js"></script>	<%-- 제이쿼리 플러그인을 사용하지 않고서는 이미지 변경을 페이지 교체없이 사용할 수 없다--%>
<script>
	//프러필 이미지를 클릭하면
	$("#profileLink").click(function(){
		//강제로 <input type="file"/>을 클릭해서 파일 선택창을 띄우고
		$("#profileImage").click();		//profileLink를 눌렀을때 profileImage가 클릭되도록 하고 profileForm은 숨겨준다.
	});
	//<input type="file"/>에 파일이 선택되면
	$("#profileImage").on("change",function(){
		//폼을 강제 제출하고 = <button type="submit">수정확인</button>  의 역할을 함
		$("#profileForm").submit();
	});
	
	//jquery form플러그인의 동작을 이용해서 폼이 ajax 로  제출되도록한다
	//페이지 전환없이 프로필이미지를 전환하기 위해서 ajax를 사용허ㅏ는것이다. > submit과 제출을 페이지 전환없이 이뤄낸다
	$("#profileForm").ajaxForm(function(responseData){
		//responseData는 plain object이다.
		//{savedPath:"/upload/저장된 이미지파일의 이름"}
		//savedPath라는 방에 저장된 이미지의 경로가 들어잇다
		console.log(responseData)
		var src="${pageContext.request.contextPath}"+responseData.savedPath;
		//img의 src속성에 반영함으로써 이미지가 업데이트 되도록한다.
		$("#profileLink img").attr("src", src);
	});
	
	function deleteConfirm(){
		var isDelete=confirm("${id} 님 탈퇴 하시겠습니까?");
		if(isDelete){
			location.href="delete.do";
		}
	}
</script>
</body>
</html>