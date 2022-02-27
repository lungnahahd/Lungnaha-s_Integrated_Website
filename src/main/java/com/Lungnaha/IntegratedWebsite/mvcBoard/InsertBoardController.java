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
public class InsertBoardController{
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("MVC 활용 ==> 글 등록 구현");
		
		boardService.insertBlogBoard(vo);
		return "getBoardList.do";
		
		
		
		// @@@@@@@@@@@@@@@ 아래는 XML 설정 파일을 이용한 동작 구현 예시
		// 입력 정보 추룰
		/*
		 * String title = request.getParameter("title"); String writer =
		 * request.getParameter("writer"); String content =
		 * request.getParameter("content");
		 */		// DB 연동 처리
		/*
		 * BoardVO vo = new BoardVO(); vo.setTitle(title); vo.setWriter(writer);
		 * vo.setContent(content);
		 * 
		 * boardService.insertBlogBoard(vo);
		 */
		// 화면 연결
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("getBoardList.do");  ==> ViewReslover 적용 전
		//mav.setViewName("redirect:getBoardList.do");
		//return mav;
		
	}	
}
