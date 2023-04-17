<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="java.util.Map" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get result</title>
</head>
<body>
<%
	Map<String, String> map = (Map<String, String>) request.getAttribute("map");
%>
<h1>Get Result</h1>
<h1>pageNo : <%= map.get("pageNo")  %></h1>
<h1>searchWord : <%= map.get("searchWord") %></h1>
<h1>job : <%= map.get("job") %></h1>
</body>
</html>
