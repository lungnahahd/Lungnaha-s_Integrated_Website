<%@page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Trasitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=EUC-KR">
<title>����Ʈ �ۼ�</title>
</head>
<body>

<center>
<h1>�� ���</h1>
<a href="logout.proc.jsp">Log-Out</a>
<hr>
<form action="insertBoard.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">����</td><td align="left">
		<input type="text" name="title"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">�ۼ���</td>
		<td align="left"><input type="text" name="writer" size="10"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">����</td><td align="left">
		<textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="�� �� ���"/></td>
	</tr>
</table>
</form>
<hr>
<a href="getBoardList.jsp">�� ��� Ȯ���ϱ�</a>
</center>

</body>
</html>