package com.Lungnaha.IntegratedWebsite.mvcBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.Lungnaha.IntegratedWebsite.BoardService;
import com.Lungnaha.IntegratedWebsite.BoardVO;

public class GetBoardController implements Controller{
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MVC 활용 ==> 글 상세 조회 구현");
		
		// 검색 게시글 등록 번호 조회
		String seq = request.getParameter("seq");
		// DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardVO board = boardService.getBlogBoard(vo);
		// 결과에 맞는 화면 출력
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		return mav;
	}
}
