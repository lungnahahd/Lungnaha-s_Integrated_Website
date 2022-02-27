package com.Lungnaha.IntegratedWebsite.mvcUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.Lungnaha.IntegratedWebsite.UserService;
import com.Lungnaha.IntegratedWebsite.UserVO;

public class LoginController implements Controller { // Spring MVC 구조로 개발을 수정 -> 기존 구조는 "DispatcherServlet"에서만 모든 걸 처리에 구조가 복잡하고 유지보수에 부적합
	
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) container.getBean("userService");
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Spring MVC 구조 ==> 로그인 처리");
		// 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserVO user = new UserVO();
		user = userService.getUser(vo);
		// 결과 값을 가지고 적절한 화면에 맵핑
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			//mav.setViewName("getBoardList.do"); ==> ViewReslover 적용 전
			mav.setViewName("redirect:getBoardList.do");
		}else {
			//mav.setViewName("login.jsp");  ==> ViewReslover 적용 전
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
		
	}
	
}
