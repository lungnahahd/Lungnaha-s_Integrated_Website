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
		System.out.println("MVC 활용 ==> 글 수정 구현");
		
		boardService.updateBlogBoard(vo);
		return "getBoardList.do";
		
		
		
		
		
		// @@@@@@@@@@@ XML 설정파일 적용 예시
		// 입력 정보 추출
		/*
		 * String title = request.getParameter("title"); String content =
		 * request.getParameter("content"); String seq = request.getParameter("seq");
		 */
		// DB 연동 
		/*
		 * BoardVO vo = new BoardVO(); vo.setTitle(title);
		 * vo.setSeq(Integer.parseInt(seq)); vo.setContent(content);
		 */
		
		//boardService.updateBlogBoard(vo);
		// 화면 연결
		/*
		 * ModelAndView mav = new ModelAndView(); //mav.setViewName("getBoardList.do");
		 * ==> ViewReslover 적용 전 mav.setViewName("redirect:getBoardList.do"); return
		 * mav;
		 */
	}
}
