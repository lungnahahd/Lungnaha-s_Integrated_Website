package com.Lungnaha.IntegratedWebsite.mvcBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Lungnaha.IntegratedWebsite.BoardService;
import com.Lungnaha.IntegratedWebsite.BoardVO;

@Controller
public class GetBoardListController  {
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView handleRequest(BoardVO vo, ModelAndView mav) {
		System.out.println("Spring MVC ==> �� ��� �˻� ó��");
		
		mav.addObject("boardList", boardService.getlistBlogBoard(vo));
		mav.setViewName("getBoardList.jsp");
		return mav;
		
		
		
		
		// @@@@@@@@@@@ XML �������� ���� ����
		//DB ���� ó��
		//BoardVO vo = new BoardVO();
		//BoardDAO boardDAO = new BoardDAO();
		//List<BoardVO> boardlist = boardDAO.getlistBlogBoard(vo);
		//List<BoardVO> boardList = boardService.getlistBlogBoard(vo);
		
		// �˻� ����� �����ؼ� �̸� ȭ�鿡 ���
		//ModelAndView mav = new ModelAndView();
		//mav.addObject("boardList", boardList);
		//mav.setViewName("getBoardList.jsp"); ==> ViewResolver ���� ��
		/*
		 * mav.setViewName("getBoardList"); return mav;
		 */
	}
}
