package com.Lungnaha.IntegratedWebsite.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Lungnaha.IntegratedWebsite.BoardService;
import com.Lungnaha.IntegratedWebsite.BoardVO;
import com.Lungnaha.IntegratedWebsite.Impl.BoardDAO;

@Controller
public class InsertBoardController {/*
									 * AbstractApplicationContext container = new
									 * GenericXmlApplicationContext("applicationContext.xml"); BoardService
									 * boardService = (BoardService) container.getBean("boardService");
									 */
	
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); 
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("MVC Ȱ�� ==> �� ��� ����");
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBlogBoard(vo);
		//boardService.insertBlogBoard(vo);
		return "redirect:getBoardList.jsp";
		
		
		
		// @@@@@@@@@@@@@@@ �Ʒ��� XML ���� ������ �̿��� ���� ���� ����
		// �Է� ���� �߷�
		/*
		 * String title = request.getParameter("title"); String writer =
		 * request.getParameter("writer"); String content =
		 * request.getParameter("content");
		 */		// DB ���� ó��
		/*
		 * BoardVO vo = new BoardVO(); vo.setTitle(title); vo.setWriter(writer);
		 * vo.setContent(content);
		 * 
		 * boardService.insertBlogBoard(vo);
		 */
		// ȭ�� ����
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("getBoardList.do");  ==> ViewReslover ���� ��
		//mav.setViewName("redirect:getBoardList.do");
		//return mav;
		
	}	
}