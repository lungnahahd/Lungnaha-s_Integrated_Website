<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Trasitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=EUC-KR">
<title>로그인</title>
</head>

<body>
<center>
<h1>검색어 입력</h1>
<hr>
<form action="search.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="orange">검색어</td>
	<td><input type="text" name="want" value="${want}"/></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="검색하기"/>
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>