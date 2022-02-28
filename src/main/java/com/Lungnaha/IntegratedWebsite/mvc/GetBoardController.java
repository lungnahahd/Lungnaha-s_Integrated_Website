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
		System.out.println("MVC 활용 ==> 글 상세 조회 구현");
		
		mav.addObject("board",boardService.getBlogBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
		
		
		
		// @@@@@@@@@@@ XML 설정파일 적용 예시
		// 검색 게시글 등록 번호 조회
		//String seq = request.getParameter("seq");
		// DB 연동 처리
		//BoardVO vo = new BoardVO();
		//vo.setSeq(Integer.parseInt(seq));
		//BoardVO board = boardService.getBlogBoard(vo);
		// 결과에 맞는 화면 출력
		//ModelAndView mav = new ModelAndView();
		//mav.addObject("board", board);
		//mav.setViewName("getBoard.jsp"); ==> ViewResolver 적용 전
		//mav.setViewName("getBoard");
		//return mav;
	}
}
