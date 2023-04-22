<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IT's KB - register</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/footer.css">
<style type="text/css">
#register {
	padding: 20px 0;
}

#register h1 {
	padding: 5px;
	text-align: center;
}

#register form {
	width: 100%;
	height: 300px;
	border: 1px solid lightgray;
	padding: 40px;
}

#register .form-item {
	margin-bottom: 10px;
}

#register .form-item label {
	display: inline-block;
	width: 150px;
	font-size: 18px;
}

#register .form-item input {
	display: inline-block;
	width: 250px;
	font-size: 18px;
}

#register button {
	float: right;
	padding: 5px;
	width: 100px;
	font-size: 18px;
	margin-top: 10px;
}
</style>
<script type="text/javascript">
$(function(){	 
	 getBanner("${pageContext.request.contextPath}");
	 
	 $("#btnRegister").click(function(e){
		e.preventDefault();
	    	
		let name = $("#name").val();
    	let email =$("#email").val();
    	let phone = $("#phone").val();
    	let password = $("#password").val();
    	let password2 = $("#password2").val();
	    	
    	console.log(name);
    	console.log(email);
    	console.log(phone);
    	console.log(password);
    	console.log(password2);
	    	
    	if(password != password2){
    		alert("비밀번호가 일치하지 않습니다.");
    		return;
    	}
	    	
    	$.ajax({
    		url:"${pageContext.request.contextPath}/user?job=register",
    		type:"post",
    		dataType:"text",
    		data :$("#registerForm").serialize() , //폼전송
    		success: function(result, status, xhr){
    			console.log(result);
    			if(result > 0){
    				alert("회원가입이 완료되었습니다.")
        			 location.href="${pageContext.request.contextPath}/index.jsp";
            		
    			}else{
        			alert("정보를 다시 입력해주세요.");        			
    			}
    			
    		},
    		error : function(jqXHR, textStatus, errorThrown){
    			alert("문제 발생 : " + jqXHR.status)
    		}    	
    		
    	});
	    	
	 });
 });

</script>

</head>
<body>
<div id="container">

	<%@ include file = "navbar.jsp" %>

	<div id="banner">지금 당신의 행복! IT's KB Life!</div>

	<div id="register">
		<h1>Register</h1>
		<form action="" method="post" id="registerForm">
			<div class="form-item">
				<label for="name">이름</label> <input type="text" id="name"
					name="name">
			</div>
			<div class="form-item">
				<label for="email">이메일</label> <input type="email" id="email"
					name="email">
			</div>
			<div class="form-item">
				<label for="phone">연락처</label> <input type="text" id="phone"
					name="phone">
			</div>
			<div class="form-item">
				<label for="password">비밀번호</label> <input type="password"
					id="password" name="password">
			</div>
			<div class="form-item">
				<label for="password2">비밀번호 확인</label> <input type="password"
					id="password2" name="password2">
			</div>
			<hr>
			<button id="btnRegister">회원 가입</button>
		</form>

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
