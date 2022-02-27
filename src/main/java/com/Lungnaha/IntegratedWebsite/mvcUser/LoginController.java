package com.Lungnaha.IntegratedWebsite.mvcUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.Lungnaha.IntegratedWebsite.UserService;
import com.Lungnaha.IntegratedWebsite.UserVO;

public class LoginController implements Controller { // Spring MVC ������ ������ ���� -> ���� ������ "DispatcherServlet"������ ��� �� ó���� ������ �����ϰ� ���������� ������
	
	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	UserService userService = (UserService) container.getBean("userService");
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Spring MVC ���� ==> �α��� ó��");
		// ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserVO user = new UserVO();
		user = userService.getUser(vo);
		// ��� ���� ������ ������ ȭ�鿡 ����
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			//mav.setViewName("getBoardList.do"); ==> ViewReslover ���� ��
			mav.setViewName("redirect:getBoardList.do");
		}else {
			//mav.setViewName("login.jsp");  ==> ViewReslover ���� ��
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
		
	}
	
}
