package com.Lungnaha.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//    public DispatcherServlet() {
//        super();
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. Ŭ���̾�Ʈ ��û path ������ ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. path�� ���� ������ �б� ó�� ����
		if(path.equals("/login.do")) {
			System.out.println("�α��� ��� ���� ����");
		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ��� ���� ����");
		}else if (path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ��� ���� ����");
		}else if (path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ��� ���� ����");
		}else if (path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ��� ���� ����");
		}else if (path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ��� ���� ����");
		}else if (path.equals("/getBoardList.do")) {
			System.out.println("�� ��� ��ȸ ��� ���� ����");
		}
	}
	

}