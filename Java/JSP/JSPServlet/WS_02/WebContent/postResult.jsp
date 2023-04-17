<%@page import="servlet.ParameterDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post result</title>
<style type="text/css">
table{
	border: 1px solid black;
	border-spacing: 0;
	width: 600px;
}
tr, td{
	border: 1px solid black;
}
</style>
</head>
<body>
<%
	ParameterDto pd = (ParameterDto)request.getAttribute("pd");
%>
<h1>Post Result</h1>

	<table>
		<tr>
			<td>name</td>
			<td><%=pd.getName() %></td>
		</tr>
		<tr>
			<td>email</td>
			<td><%=pd.getEmail() %></td>
		</tr>
		<tr>
			<td>gender</td>
			<td><%=pd.getGender() %></td>
		</tr>
		<tr>
			<td>hobby</td>
			<td>			
				<% 
		            String[] hobbies = pd.getHobby();
		            for (int i = 0; i < hobbies.length; i++) {
		                out.print(hobbies[i]);
		                if (i < hobbies.length - 1) {
		                    out.print(", ");
		                }
		            }
	       	 	%>			
			</td>
		</tr>
		<tr>
			<td>favorite</td>
			<td><%=pd.getFavorite() %></td>
		</tr>
		<tr>
			<td>desc</td>
			<td><%=pd.getDesc() %></td>
		</tr>
	</table>
</body>
</html>
