<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1>ス〇ローにようこそ</h1>
<% if(loginUser != null) { %>
<a href="/OsushiOrder/Main">注文画面へ</a>
<% } else { %>
<p>ログインに失敗しました</p>
<a href="/OsushiOrder/index.jsp">TOPへ</a>
<% } %>
</body>
</html>