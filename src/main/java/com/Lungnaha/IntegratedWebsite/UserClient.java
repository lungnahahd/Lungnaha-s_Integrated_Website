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
//		vo.setName("������");
//		vo.setRole("������");
//		ȸ�� ���� ��� �׽�Ʈ
//		userService.signUp(vo);
		System.out.println("----> " + vo.toString());
		
		UserVO user = userService.getUser(vo.getId());
		if (user != null) {
			System.out.println(user.getName() + " �� ȯ���մϴ�.");
			System.out.println(user.getRole() + " ����Դϴ�.");
		}
		
		container.close();
		
	}

}
