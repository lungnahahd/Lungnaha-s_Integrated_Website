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
public class LoginController { // Spring MVC ������ ������ ���� -> ���� ������ "DispatcherServlet"������ ��� �� ó���� ������ �����ϰ� ���������� ������
	
	
	//AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	//UserService userService = (UserService) container.getBean("userService");
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/login.do")
	public String login(UserVO vo,UserDAO userDAO) {
		System.out.println("Spring MVC ���� ==> �α��� ó��");
		if(userService.getUser(vo)!=null) {
			return "getBoardList.do";
		}else {
			return "login.jsp";
		}
		 
		
		// @@@@@@@@@@@ XML �������� ���� ����
		// ����� �Է� ���� ����
		/*
		 * String id = request.getParameter("id"); String password =
		 * request.getParameter("password");
		 */
		// DB ���� ó��
		/*
		 * UserVO vo = new UserVO(); vo.setId(id); vo.setPassword(password);
		 * 
		 * UserVO user = new UserVO(); user = userService.getUser(vo);
		 */
		// ��� ���� ������ ������ ȭ�鿡 ����
		/*
		 * ModelAndView mav = new ModelAndView(); if(user != null) {
		 * //mav.setViewName("getBoardList.do"); ==> ViewReslover ���� ��
		 * mav.setViewName("redirect:getBoardList.do"); }else {
		 * //mav.setViewName("login.jsp"); ==> ViewReslover ���� ��
		 * mav.setViewName("redirect:login.jsp"); } return mav;
		 */
		
	}
	
}
