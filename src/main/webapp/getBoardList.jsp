<%@page import="java.util.List" %>
<%@page import="com.Lungnaha.IntegratedWebsite.Impl.BoardDAO" %>
<%@page import="com.Lungnaha.IntegratedWebsite.BoardVO" %>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	/* //1. ����� �Է� ���� ����
	//2. DB ���� ó��
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO =new BoardDAO(); */
	List<BoardVO> boardList =(List) session.getAttribute("boardList");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Trasitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=EUC-KR">
<title>�� ���</title>
</head>
<body>
<center>
<h1>�� ���</h1>
<h3>ȯ���մϴ�...<a href="logout_proc.jsp">�α׾ƿ�</a></h3>

<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
<td align="right">
	<select name="searchCondition">
	<option value="TITLE">����
	<option value="CONTENT">����
	</select>
	<input name="searchKeyword" type="text"/>
	<input type="submit" value="�˻�"/>	
</td>
</tr>
</table>
</form>

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">��ȣ</th>
	<th bgcolor="orange" width="200">����</th>
	<th bgcolor="orange" width="150">�ۼ���</th>
</tr>

<% for(BoardVO boad : boardList) {  %>
<tr>
	<td><%= boad.getSeq() %></td>
	<td align="left"><a href="getBoard.do?seq=<%= boad.getSeq() %>"><%= boad.getTitle() %></a></td>
	<td><%= boad.getWriter() %></td>
</tr>
<% } %>

</table>
<br>
<a href="insertBoard.jsp">���� ���</a>
</center>
</body>
</html>