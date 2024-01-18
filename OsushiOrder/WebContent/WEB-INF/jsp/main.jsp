<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");

String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ス〇ロー</title>
</head>
<body>
<h1>注文画面</h1>

<% if(errorMsg != null) { %>
<h3 style="color: red;"><%= errorMsg %></h3>
<% } %>

<p>
ご注文をどうぞ
</p>

<form action="/OsushiOrder/Main" method="post">
	<SELECT name="neta">
	      <OPTION value="empty"selected>選んでください</OPTION>
	      <OPTION value="1">まぐろ</OPTION>
	      <OPTION value="2">サーモン</OPTION>
	      <OPTION value="3">えび</OPTION>
	      <OPTION value="4">玉子</OPTION>
	      <OPTION value="5">いくら</OPTION>
	</SELECT>

	<p><input type="number" name="num" min="1" max="5" value="1">
<input type="submit" value="注文する"></p>
<p><a href="/OsushiOrder/Main">取り消す</a></p>
</form>


<p><a href="/OsushiOrder/ArchiveMain">お会計</a></p>
</body>
</html>