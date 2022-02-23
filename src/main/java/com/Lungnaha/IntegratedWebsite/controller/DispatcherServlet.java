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
	
	// 기존에 JSP의 자바 코드로 구현되던 내용이 Controller에 온전히 구현!
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. 클라이언트 요청 Path 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. 클라이언트 요청 Path에 따라 적절한 분기 처리 진행
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			//1. 사용자 입력 정보 추출
		 	String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserVO user = userService.getUser(vo);
			
			//UserDAO userDAO = new UserDAO();
			//UserVO user = userDAO.getUser(vo);
			
			//System.out.println("----> " + vo.getId());
			
			//3. 페이지 전환
		 	if(user != null){
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			} 

		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
		}else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			// 검색 글의 번호를 추출
			String seq = request.getParameter("seq");
			
			// DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			//BoardDAO boardDAO = new BoardDAO();
			//BoardVO board = boardDAO.getBlogBoard(vo);
			BoardVO board = boardService.getBlogBoard(vo);
			
			// 검색 결과를 세션에 저장하고 상세 화면으로 이동
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
			
			
			
			
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
			
			// 바로 DB와 연동
			BoardVO vo = new BoardVO();
			//BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardService.getlistBlogBoard(vo);
			
			// 검색 결과를 세션에 저장하고 목록 화면으로 이동
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
		
	}
	

}
