<%@page import="web.dao.MemberDAOImpl"%>
<%@page import="web.dao.MemberDAO"%>
<%@page import="web.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>DBCP TEST</h1>

<%
	MemberDAO dao = new MemberDAOImpl();
	List<Member> list = dao.selectAll();
%>

결과 : <%= list %>
</body>
</html>
