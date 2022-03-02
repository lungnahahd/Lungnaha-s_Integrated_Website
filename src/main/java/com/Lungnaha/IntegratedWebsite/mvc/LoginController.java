package com.Lungnaha.IntegratedWebsite.mvc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Lungnaha.IntegratedWebsite.UserService;
import com.Lungnaha.IntegratedWebsite.UserVO;
import com.Lungnaha.IntegratedWebsite.Impl.UserDAO;

@Controller
public class LoginController { // Spring MVC 구조로 개발을 수정 -> 기존 구조는 "DispatcherServlet"에서만 모든 걸 처리에 구조가 복잡하고 유지보수에 부적합
	
	
	//AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	//UserService userService = (UserService) container.getBean("userService");
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/login.do")
	public String login(UserVO vo,UserDAO userDAO) {
		System.out.println("Spring MVC 구조 ==> 로그인 처리");
		if(userService.getUser(vo)!=null) {
			return "getBoardList.do";
		}else {
			return "login.jsp";
		}
		 
		
		// @@@@@@@@@@@ XML 설정파일 적용 예시
		// 사용자 입력 정보 추출
		/*
		 * String id = request.getParameter("id"); String password =
		 * request.getParameter("password");
		 */
		// DB 연동 처리
		/*
		 * UserVO vo = new UserVO(); vo.setId(id); vo.setPassword(password);
		 * 
		 * UserVO user = new UserVO(); user = userService.getUser(vo);
		 */
		// 결과 값을 가지고 적절한 화면에 맵핑
		/*
		 * ModelAndView mav = new ModelAndView(); if(user != null) {
		 * //mav.setViewName("getBoardList.do"); ==> ViewReslover 적용 전
		 * mav.setViewName("redirect:getBoardList.do"); }else {
		 * //mav.setViewName("login.jsp"); ==> ViewReslover 적용 전
		 * mav.setViewName("redirect:login.jsp"); } return mav;
		 */
		
	}
	
}
