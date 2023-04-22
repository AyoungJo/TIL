<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IT's KB</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<link rel="shortcut icon" href="#">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/navbar.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
sr<style type="text/css">
#main {
	display: flex;
	justify-content: center;
	margin-top: 5px;
}

#main .main-item {
	flex-grow: 1;
	margin: 5px;
}

#main .main-item img {
	width: 100%;
}

#main .main-item button {
	float: right;
	padding: 5px;
	width: 80px;
	font-size: 15px;
}
</style>
<script type="text/javascript">
$(function(){
	getBanner("${pageContext.request.contextPath}");
	
	//버튼 클릭시
	$(".main-item-btn").click(function(){
		 let idValue =  $(this).closest(".main-item").attr("data-main-item-id");
		 console.log(idValue)
	 });
});
</script>
</head>
<body>
	<div id="container">
		<!-- navbar -->
		<%-- <%@ include file = "navbar.jsp" %> --%>
		<jsp:include page="navbar.jsp"/>

		<div id="banner">지금 당신의 행복! IT's KB Life!</div>
		
		<div id="main">
			<!-- 총 3개의 서브영역 -->
			<div class="main-item" data-main-item-id="10">
				<img src="https://picsum.photos/200" alt="">
				<h2>main-item 1</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<button class="main-item-btn">button 1</button>
			</div>
			<div class="main-item" data-main-item-id="20">
				<img src="https://picsum.photos/200" alt="">
				<h2>main-item 2</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<button class="main-item-btn">button 2</button>
			</div>
			<div class="main-item" data-main-item-id="30">
				<img src="https://picsum.photos/200" alt="">
				<h2>main-item 3</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<button class="main-item-btn">button 3</button>
			</div>
		</div>

		<footer>
			<ul>
				<li>서울시 강남구 선릉역</li>
				<li>02-999-1234</li>
			</ul>
		</footer>

	</div>

</body>
</html>
