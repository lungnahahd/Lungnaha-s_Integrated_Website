<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Trasitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=EUC-KR">
<title>글 목록</title>
</head>
<body>
<center>
<h1>글 목록</h1>
<h3>환영합니다...<a href="logout.do">로그아웃</a></h3>

<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
<td align="right">
	<select name="searchCondition">
	<option value="TITLE">제목
	<option value="CONTENT">내용
	</select>
	<input name="searchKeyword" type="text"/>
	<input type="submit" value="검색"/>	
</td>
</tr>
</table>
</form>

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">번호</th>
	<th bgcolor="orange" width="200">제목</th>
	<th bgcolor="orange" width="150">작성자</th>
</tr>

<c:forEach items="${boardList }" var="board">
<tr>
	<td>%{board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq }">%{board.title }</a></td>
	<td>%{board.writer }</td>
</tr>
</c:forEach>


<%-- <% for(BoardVO boad : boardList) {  %>
<tr>
	<td><%= boad.getSeq() %></td>
	<td align="left"><a href="getBoard.do?seq=<%= boad.getSeq()%>"><%= boad.getTitle()%></a></td>
	<td><%= boad.getWriter()%></td>
</tr>
<% } %> --%>

</table>
<br>
<a href="insertBoard.jsp">새글 등록</a>
</center>
</body>
</html>