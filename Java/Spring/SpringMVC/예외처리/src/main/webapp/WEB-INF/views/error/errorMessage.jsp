<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 메세지 : ${errmsg} / ${errClass}</h3>
<a href="${pageContext.request.contextPath}/ex04_exception.html">폼으로 이동하기</a>
</body>
</html>
