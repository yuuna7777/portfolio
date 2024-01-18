<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//セッションスコープから値を取り出す
	String name = (String)session.getAttribute("name");
	String userNum = String.valueOf(session.getAttribute("userNum"));
	String bill = String.valueOf(session.getAttribute("bill"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>取得結果</title>
</head>
<body>


	<!-- 取得した値を表示する -->
    <p>名前：<%=name %></p>
    <p>個数：<%=userNum %>皿</p>
    <p>金額：<%=bill %></p>
    <p>注文しました</p>
    <p><a href="/OsushiOrder/Main">注文に戻る</a></p>

</body>
</html>