<%@page import="java.util.List" %>
<%@page import="com.Lungnaha.IntegratedWebsite.Impl.BoardDAO" %>
<%@page import="com.Lungnaha.IntegratedWebsite.BoardVO" %>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	//1. 사용자 입력 정보 추출
	//2. DB 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO =new BoardDAO();
	List<BoardVO> boardList = boardDAO.getlistBlogBoard(vo);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>