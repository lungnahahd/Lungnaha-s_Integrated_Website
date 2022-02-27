package com.Lungnaha.IntegratedWebsite.mvcBoard;

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
public class UpdateBoardController  {
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		System.out.println("MVC Ȱ�� ==> �� ���� ����");
		
		boardService.updateBlogBoard(vo);
		return "getBoardList.do";
		
		
		
		
		
		// @@@@@@@@@@@ XML �������� ���� ����
		// �Է� ���� ����
		/*
		 * String title = request.getParameter("title"); String content =
		 * request.getParameter("content"); String seq = request.getParameter("seq");
		 */
		// DB ���� 
		/*
		 * BoardVO vo = new BoardVO(); vo.setTitle(title);
		 * vo.setSeq(Integer.parseInt(seq)); vo.setContent(content);
		 */
		
		//boardService.updateBlogBoard(vo);
		// ȭ�� ����
		/*
		 * ModelAndView mav = new ModelAndView(); //mav.setViewName("getBoardList.do");
		 * ==> ViewReslover ���� �� mav.setViewName("redirect:getBoardList.do"); return
		 * mav;
		 */
	}
}
