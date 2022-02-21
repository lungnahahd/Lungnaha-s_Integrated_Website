package com.Lungnaha.IntegratedWebsite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.Lungnaha.IntegratedWebsite.UserService;
import com.Lungnaha.IntegratedWebsite.UserVO;
import com.Lungnaha.IntegratedWebsite.Impl.UserDAO;


public class DispatcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) container.getBean("userService");

   
//    public DispatcherServlet() {
//        super();
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	// ������ JSP�� �ڹ� �ڵ�� �����Ǵ� ������ Controller�� ������ ����!
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. Ŭ���̾�Ʈ ��û Path ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. Ŭ���̾�Ʈ ��û Path�� ���� ������ �б� ó�� ����
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");
			//1. ����� �Է� ���� ����
		 	String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB ���� ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserVO user = userService.getUser(vo);
			
			//UserDAO userDAO = new UserDAO();
			//UserVO user = userDAO.getUser(vo);
			
			//System.out.println("----> " + vo.getId());
			
			//3. ������ ��ȯ
		 	if(user != null){
				response.sendRedirect("getBoardList.jsp");
			}else{
				response.sendRedirect("login.jsp");
			} 

		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
		}else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
		}else if(path.equals("/getList")) {
			System.out.println("�� ��� �˻� ó��");
		}
		
	}
	

}
