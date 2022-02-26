package com.Lungnaha.IntegratedWebsite.mvcBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.Lungnaha.IntegratedWebsite.BoardService;
import com.Lungnaha.IntegratedWebsite.BoardVO;

public class UpdateBoardController implements Controller {
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@Override
	public ModelAndView handleRequest (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MVC Ȱ�� ==> �� ���� ����");
		
		// �Է� ���� ����
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		// DB ���� 
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setSeq(Integer.parseInt(seq));
		vo.setContent(content);
		
		boardService.updateBlogBoard(vo);
		// ȭ�� ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
	}
}
