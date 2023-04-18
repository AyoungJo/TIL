<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IT's KB</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="shortcut icon" href="#">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/navbar.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<style type="text/css">
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

	document.querySelectorAll(".main-item-btn").forEach(function(btn, index) {
		btn.onclick = function(){
			let id = btn.closest(".main-item").getAttribute('data-main-item-id');
			alert(id);
			console.log(id);
		}
	});
</script>
</head>
<body>
	<div id="container">

		<nav id="navbar">
			<!-- 5개의 메뉴생성 -->
			<ul>
				<li class="nav-item logo"><a href="index.html"><img
						src="images/logo.jpg" alt="로고입니다."></a></li>
				<li class="nav-item"><a href="personal.html">개인</a></li>
				<li class="nav-item"><a href="busines.html">기업</a></li>
				<li class="nav-item"><a href="login.html">로그인</a></li>
				<li class="nav-item"><a href="register.html">회원가입</a></li>
			</ul>
		</nav>

		<div id="banner">지금 당신의 행복! IT's KB Life!</div>
		
		<script type="text/javascript">
			onload = function() {
				/* 1번 - 배너 변경  */
				let banner = document.querySelector("#banner");
				let bannerList = [];
				let index = 0;

				function changeBanner() {
					banner.innerHTML = bannerList[index++];

					// 리스트를 벗어나면 다시 0으로 돌아오기
					if (index === bannerList.length) {
					  index = 0;
					}

			      setTimeout(changeBanner, 5000);
			    }

				   
				$.ajax({
						url : "${pageContext.request.contextPath}/banners?key=banner",
						type : "get",
						dataType : "json",
						success : function(result) {
							bannerList = result;
							changeBanner();
						},
						error : function(err) {
							console.log(err);
						}
					});
				};
			
		</script>
		
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
				<li>서울시 선릉역 We-Work</li>
				<li>02-0000-0000</li>
			</ul>
		</footer>

	</div>

</body>
</html>
