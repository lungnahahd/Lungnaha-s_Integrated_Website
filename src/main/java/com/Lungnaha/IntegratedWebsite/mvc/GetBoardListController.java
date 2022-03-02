package com.Lungnaha.IntegratedWebsite.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Lungnaha.IntegratedWebsite.BoardService;
import com.Lungnaha.IntegratedWebsite.BoardVO;

@Controller
public class GetBoardListController  {
	
	 // 검색 조건 목록 설정
	 
	 @ModelAttribute("conditionMap") // RequestMapping 보다 먼저 정보를 담을 수 있는 어노테이션 ==>즉 사전 작업 
	 public Map<String, String> searchConditionMap(){ Map<String, String>
	 			conditionMap = new HashMap<String, String>(); conditionMap.put("제목","TITLE"); 
	 conditionMap.put("내용", "CONTENT"); return conditionMap; }
	 


	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); 
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView handleRequest(@RequestParam(value="searchCondition",defaultValue = "TITLE", required = false) String condition, 
								@RequestParam(value="searchKeyword", defaultValue = "", required = false) String keyword,BoardVO vo, ModelAndView mav) {
		System.out.println("Spring MVC ==> 글 목록 검색 처리");
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : "+ keyword);
		mav.addObject("boardList", boardService.getlistBlogBoard(vo));
		mav.setViewName("getBoardList.jsp");
		return mav;
		
		
		
		
		// @@@@@@@@@@@ XML 설정파일 적용 예시
		//DB 연동 처리
		//BoardVO vo = new BoardVO();
		//BoardDAO boardDAO = new BoardDAO();
		//List<BoardVO> boardlist = boardDAO.getlistBlogBoard(vo);
		//List<BoardVO> boardList = boardService.getlistBlogBoard(vo);
		
		// 검색 결과와 맵핑해서 이를 화면에 출력
		//ModelAndView mav = new ModelAndView();
		//mav.addObject("boardList", boardList);
		//mav.setViewName("getBoardList.jsp"); ==> ViewResolver 적용 전
		/*
		 * mav.setViewName("getBoardList"); return mav;
		 */
	}
}
