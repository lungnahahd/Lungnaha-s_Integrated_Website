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

@Controller
public class GetBoardController {
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, ModelAndView mav) {
		System.out.println("MVC Ȱ�� ==> �� �� ��ȸ ����");
		
		mav.addObject("board",boardService.getBlogBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
		
		
		
		// @@@@@@@@@@@ XML �������� ���� ����
		// �˻� �Խñ� ��� ��ȣ ��ȸ
		//String seq = request.getParameter("seq");
		// DB ���� ó��
		//BoardVO vo = new BoardVO();
		//vo.setSeq(Integer.parseInt(seq));
		//BoardVO board = boardService.getBlogBoard(vo);
		// ����� �´� ȭ�� ���
		//ModelAndView mav = new ModelAndView();
		//mav.addObject("board", board);
		//mav.setViewName("getBoard.jsp"); ==> ViewResolver ���� ��
		//mav.setViewName("getBoard");
		//return mav;
	}
}
