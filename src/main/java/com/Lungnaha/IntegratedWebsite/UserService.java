package com.Lungnaha.IntegratedWebsite;

public interface UserService {

	// �α��� ���
	UserVO getUser(String id);

	// ȸ�� ���� ���
	void signUp(UserVO vo);

}