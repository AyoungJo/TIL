<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//session.setMaxInactiveInterval(10);//30초
%>
<h1>HttpSession 알아보기</h1>
<h3>
	session.isNew() = <%=session.isNew() %><br>
	session.getId() = <%=session.getId() %><br>
	session.getMaxInactiveInterval() = <%=session.getMaxInactiveInterval() %><br>
	session.getLastAccessedTime() = <%=session.getLastAccessedTime() %><br>
	session.getCreationTime() = <%=session.getCreationTime() %><br>
</h3>

<%
	request.setAttribute("addr", "서울");

	//세션에 정보를 저장해보자
	session.setAttribute("id", "joy");
	session.setAttribute("msg", "sessionTest");		
%>

<hr>
<h3>저장된 정보 조회하기</h3>
아이디 : <%= session.getAttribute("id") %> <br>
메세지 : <%= session.getAttribute("msg") %> <br>
주소 : <%= request.getAttribute("addr") %> <br>

<a href="sessionGet.jsp">확인</a>
</body>
</html>
