package com.Lungnaha.IntegratedWebsite.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Lungnaha.IntegratedWebsite.UserService;
import com.Lungnaha.IntegratedWebsite.UserVO;
import com.Lungnaha.IntegratedWebsite.Impl.UserDAO;

@Controller
public class InfoController {

	@RequestMapping("/search.do")
	public String login(HttpServletRequest request) {
		System.out.println("Spring MVC 구조 ==> 크롤링 테스트");
		System.out.println(request.getParameter("want"));
		return ".jsp";
		 
	}
}
