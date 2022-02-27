package com.Lungnaha.IntegratedWebsite.mvcBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.Lungnaha.IntegratedWebsite.BoardService;
import com.Lungnaha.IntegratedWebsite.BoardVO;
import com.Lungnaha.IntegratedWebsite.Impl.BoardDAO;


public class GetBoardListController implements Controller {
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Spring MVC ==> �� ��� �˻� ó��");
		
		//DB ���� ó��
		BoardVO vo = new BoardVO();
		//BoardDAO boardDAO = new BoardDAO();
		//List<BoardVO> boardlist = boardDAO.getlistBlogBoard(vo);
		List<BoardVO> boardList = boardService.getlistBlogBoard(vo);
		
		// �˻� ����� �����ؼ� �̸� ȭ�鿡 ���
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		//mav.setViewName("getBoardList.jsp"); ==> ViewResolver ���� ��
		mav.setViewName("getBoardList");
		return mav;
	}
}
