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
<title>�� ��</title>
</head>
<body>
<center>
<h1>�� ��</h1>
<a href="logout_proc.jsp">Log-Out</a>
<hr>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value = "<%= board.getSeq() %>"/>
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">����</td>
		<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">�ۼ���</td>
		<td align="left"><%= board.getWriter() %></td>
	</tr>
	<tr>
		<td bgcolor="orange">����</td><td align="left">
		<textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="�� ����"/>
		</td>
	</tr>
	

</table>
</form>
<hr>
<a href="insertBoard.jsp">�۵��</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard_proc.jsp">�ۻ���</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.jsp">�۸��</a>

</center>

</body>
</html>