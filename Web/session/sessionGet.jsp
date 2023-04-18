<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>저장된 정보 조회하기</h3>
아이디 : <%= session.getAttribute("id") %> <br>
메세지 : <%= session.getAttribute("msg") %> <br>
주소: <%= request.getAttribute("addr") %> <br>

<hr>
<!-- <h3> ServletContext - 저장된 정보 조회하기</h3> -->
application 메세지 : <%= application.getAttribute("message") %> 
application 나이 : <%= application.getAttribute("age") %> 

</body>
</html>
