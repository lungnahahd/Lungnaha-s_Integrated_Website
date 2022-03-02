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
	
	 // �˻� ���� ��� ����
	 
	 @ModelAttribute("conditionMap") // RequestMapping ���� ���� ������ ���� �� �ִ� ������̼� ==>�� ���� �۾� 
	 public Map<String, String> searchConditionMap(){ Map<String, String>
	 			conditionMap = new HashMap<String, String>(); conditionMap.put("����","TITLE"); 
	 conditionMap.put("����", "CONTENT"); return conditionMap; }
	 


	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); 
	BoardService boardService = (BoardService) container.getBean("boardService");
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView handleRequest(@RequestParam(value="searchCondition",defaultValue = "TITLE", required = false) String condition, 
								@RequestParam(value="searchKeyword", defaultValue = "", required = false) String keyword,BoardVO vo, ModelAndView mav) {
		System.out.println("Spring MVC ==> �� ��� �˻� ó��");
		System.out.println("�˻� ���� : " + condition);
		System.out.println("�˻� �ܾ� : "+ keyword);
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
