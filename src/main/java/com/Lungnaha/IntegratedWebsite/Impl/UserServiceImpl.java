package com.Lungnaha.IntegratedWebsite.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lungnaha.IntegratedWebsite.UserService;
import com.Lungnaha.IntegratedWebsite.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserVO getUser(String id) {
		return userDAO.getUser(id);
	}

	@Override
	public void signUp(UserVO vo) {
		userDAO.signUp(vo);
	}

}
