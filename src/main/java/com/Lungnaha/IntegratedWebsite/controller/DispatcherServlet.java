package com.Lungnaha.IntegratedWebsite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.Lungnaha.IntegratedWebsite.BoardService;
import com.Lungnaha.IntegratedWebsite.BoardVO;
import com.Lungnaha.IntegratedWebsite.UserService;
import com.Lungnaha.IntegratedWebsite.UserVO;
import com.Lungnaha.IntegratedWebsite.Impl.BoardDAO;
import com.Lungnaha.IntegratedWebsite.Impl.UserDAO;
import com.sun.java.swing.action.AlignLeftAction;

import java.util.List;


public class DispatcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) container.getBean("userService");
	BoardService boardService = (BoardService) container.getBean("boardService");

   
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
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			} 

		}else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
			
			// �������� �����ϴ� ������ �ޱ�
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// ���� ������ Ȱ���ϱ�
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			// insert ���� ���ۿ��� ���� ���� ������ ����
			boardService.insertBlogBoard(vo); 
			
			// ��� �۾� ���� ������ ȭ���� �����ֱ����ؼ� do�� ���� ��û -> do ���� ���� �ٷ� ���� jsp ������
			response.sendRedirect("getBoardList.do");
			
			
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			boardService.updateBlogBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			
			String seq = request.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			boardService.deleteBlogBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
			
		}else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
			
			// �˻� ���� ��ȣ�� ����
			String seq = request.getParameter("seq");
			
			// DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			//BoardDAO boardDAO = new BoardDAO();
			//BoardVO board = boardDAO.getBlogBoard(vo);
			BoardVO board = boardService.getBlogBoard(vo);
			
			// �˻� ����� ���ǿ� �����ϰ� �� ȭ������ �̵�
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
			
			
			
			
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
			
			// �ٷ� DB�� ����
			BoardVO vo = new BoardVO();
			//BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardService.getlistBlogBoard(vo);
			
			// �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵�
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
		
	}
	

}
