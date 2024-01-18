<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Mutter,java.util.List" %>
<%
List<Mutter> ArcList = (List<Mutter>) request.getAttribute("ArcList");

String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お会計</title>
</head>
<body>
<h1>お会計</h1>
<% if(errorMsg != null) { %>
<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : ArcList) { %>
	<h3><%= mutter.getBill() %>円になります</h3>
<% } %>
</body>
</html>