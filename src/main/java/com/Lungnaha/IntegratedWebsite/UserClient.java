package com.Lungnaha.IntegratedWebsite;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("Lungnaha");
		vo.setPassword("khd10810");
//		vo.setName("렁나하");
//		vo.setRole("관리자");
//		회원 가입 기능 테스트
//		userService.signUp(vo);
		System.out.println("----> " + vo.toString());
		
		UserVO user = userService.getUser(vo.getId());
		if (user != null) {
			System.out.println(user.getName() + " 님 환영합니다.");
			System.out.println(user.getRole() + " 등급입니다.");
		}
		
		container.close();
		
	}

}
