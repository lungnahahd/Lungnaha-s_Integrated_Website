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
public class DeleteBoardController {
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo){
		System.out.println("MVC 활용 ==> 글 삭제 구현");
		
		boardService.deleteBlogBoard(vo);
		return("getBoardList.do");
		
		
		
		
		
		// @@@@@@@@@@@ XML 설정파일 적용 예시
		// 정보 추출
		//String seq = request.getParameter("seq");
		// DB 연동
		/*
		 * BoardVO vo = new BoardVO(); vo.setSeq(Integer.parseInt(seq));
		 * 
		 * boardService.deleteBlogBoard(vo);
		 */
		// 화면 연결
		/*
		 * ModelAndView mav = new ModelAndView(); //mav.setViewName("getBoardList.do");
		 * ==> ViewReslover 적용 전 mav.setViewName("redirect:getBoardList.do"); return
		 * mav;
		 */
		
	}

}
