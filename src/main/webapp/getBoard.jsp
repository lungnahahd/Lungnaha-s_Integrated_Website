<%@page import="java.util.List" %>
<%@page import="com.Lungnaha.IntegratedWebsite.Impl.BoardDAO" %>
<%@page import="com.Lungnaha.IntegratedWebsite.BoardVO" %>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	BoardVO board = (BoardVO) session.getAttribute("board");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Trasitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=EUC-KR">
<title>글 상세</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<a href="logout_proc.jsp">Log-Out</a>
<hr>
<form action="updateBoard.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
	</tr>
	<tr>
		<td bgcolor="organe">작성자</td>
		<td align="left"><%= board.getWriter()  %></td>
	</tr>
	<tr>
		<td bgcolor="organe">등록인</td>
		<td align="left"><textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td>
	</tr>

</table>
</form>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nabs;
<a href="deleteBoard_proc.jsp">글삭제</a>&nbsp;&nbsp;&nabs;
<a href="getBoardList.jsp">글목록</a>&nbsp;&nbsp;&nabs;

</center>

</body>
</html>