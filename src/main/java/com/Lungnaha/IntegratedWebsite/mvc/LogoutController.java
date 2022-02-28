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
		System.out.println("MVC Ȱ�� ==> �α׾ƿ� ����");
		
		session.invalidate();
		return "login.jsp";
		
		// @@@@@@@@@@@ XML �������� ���� ����
		// �������� ����� ������ ���� ����
		/*
		 * HttpSession session = request.getSession(); session.invalidate();
		 */
		
		// ���� ���� �� ȭ�� ����
		/*
		 * ModelAndView mav = new ModelAndView(); //mav.setViewName("login.jsp"); ==>
		 * ViewReslover ���� �� mav.setViewName("redirect:login.jsp"); return mav;
		 */
	}

}
