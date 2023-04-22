<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT's KB - login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/footer.css">
<style type="text/css">
   #login{
     padding: 20px 0;
   }
   #login h1{
     padding: 5px;
     text-align: center;
   }
   
   #login form{
  
     width: 100%;
     height: 200px;
     border: 1px solid gray;
     padding: 40px;
   }
   
   #login .form-item{
      margin-bottom: 10px;
   }
   
   #login .form-item label{
   display:inline-block;
     width: 100px;
     font-size: 18px;
   }
   
   #login .form-item input{
   display:inline-block;
     width: 200px;
     font-size: 18px;
   }
   
   #login button{
      float: right;
      width: 80px;
       font-size: 18px;
       padding: 5px;
   }
   
</style>
 <script type="text/javascript">

 $(function(){	 
	 //banner가져오기 
	 getBanner("${pageContext.request.contextPath}");
  	 
	 $("#btnLogin").click(function(e){
		e.preventDefault();
		 
		let email = $("#email") ;
		let pw = $("#password");
 		 
		if(email.val()==""){
			alert("이메일을 입력해주세요.");
			email.focus();		   
			return false;
		}
		
		if(pw.val()==""){
			alert("비밀번호를 입력해주세요.");
			pw.focus();		   
			return false;
		}

	/*로그인*/    		
  		$.ajax({    			
      		//url:"login",
      		url : "${pageContext.request.contextPath}/login",	//현재 경로
      		type : "post",
      		dataType : "json", //응답결과
      		//data : "email=email&pw=pw"	//쿼리스트링
      		//post일 때 request의 body에 숨어서 값이 전달됨
      		//get 방식일 때 : url주소로 전달
      		data:{email:email.val(), pass:pw.val()},
      		success: function(data){	//data(key) = jsonArr
      			console.log(data);
      			if(data.result=="success"){//로그인 성공          			
          			location.href="${pageContext.request.contextPath}/index.jsp";
      			}else{//로그인 실패
      				alert("정보를 다시 확인해주세요.")
      				$("input").val("");
      				$("#email").focus();
      			}       				
      		},
      		error : function(jqXHR){
      			alert("문제 발생 : " + jqXHR.status)
      		}        	      		
      	});//ajax End
   		
  	 });//click End
   });
 
</script>
</head>
<body>
<div id="container">

	<jsp:include page="navbar.jsp"/>
    
    <div id="banner">지금 당신의 행복! IT's KB Life!</div>

	<div id="login">
		<h1>Login</h1>
		<form action="" method="post">
			<div class="form-item">
				<label for="id">이메일</label> 
				<input type="text" id="email" name="email">
			</div>
			<div class="form-item">
				<label for="password">비밀번호</label> 
				<input type="password" id="password" name="password">
			</div>
			<hr>
			<button id="btnLogin">로그인</button>
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
