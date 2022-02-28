package com.Lungnaha.IntegratedWebsite.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Lungnaha.IntegratedWebsite.UserService;

@Controller
public class LogoutController{
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) container.getBean("userService");
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		System.out.println("MVC 활용 ==> 로그아웃 구현");
		
		session.invalidate();
		return "login.jsp";
		
		// @@@@@@@@@@@ XML 설정파일 적용 예시
		// 브라우저와 연결된 세션을 강제 종료
		/*
		 * HttpSession session = request.getSession(); session.invalidate();
		 */
		
		// 세션 종료 후 화면 연결
		/*
		 * ModelAndView mav = new ModelAndView(); //mav.setViewName("login.jsp"); ==>
		 * ViewReslover 적용 전 mav.setViewName("redirect:login.jsp"); return mav;
		 */
	}

}
