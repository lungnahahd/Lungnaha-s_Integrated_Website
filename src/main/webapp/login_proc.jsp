<%@page import="com.Lungnaha.IntegratedWebsite.UserService"%>
<%@page import="com.Lungnaha.IntegratedWebsite.Impl.UserDAO"%>
<%@page import="com.Lungnaha.IntegratedWebsite.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%


	//1. 사용자 입력 정보 추출
 	String id = request.getParameter("id");
	String password = request.getParameter("password");
	System.out.println(id);
	System.out.println(password);
	
	//2. DB 연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	System.out.println("----> " + vo.getId());
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo.getId());
	
	//System.out.println("----> " + user.toString());
	
	//3. 페이지 전환
	if(vo != null){
		response.sendRedirect("getBoardList.jsp");
	}else{
		response.sendRedirect("login.jsp");
	} 

%>