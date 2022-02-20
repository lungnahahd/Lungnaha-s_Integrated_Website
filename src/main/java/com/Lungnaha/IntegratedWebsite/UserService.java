package com.Lungnaha.IntegratedWebsite;

public interface UserService {

	// 로그인 기능
	UserVO getUser(String id);

	// 회원 가입 기능
	void signUp(UserVO vo);

}