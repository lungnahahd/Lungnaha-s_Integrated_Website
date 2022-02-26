package com.Lungnaha.IntegratedWebsite.mvcUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.Lungnaha.IntegratedWebsite.UserService;

public class LogoutController implements Controller {
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) container.getBean("userService");
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MVC Ȱ�� ==> �α׾ƿ� ����");
		
		// �������� ����� ������ ���� ����
		HttpSession session = request.getSession();
		session.invalidate();
		
		// ���� ���� �� ȭ�� ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		return mav;
	}

}
