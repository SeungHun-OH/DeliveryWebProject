package com.cap.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.delivery.dao.UserDao;
import com.cap.delivery.model.SignupDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int ajaxChkId(String inputId) {
		return userDao.ajaxChkId(inputId);
	}

	@Override
	public void insertSignup(SignupDto signupDto) {
		userDao.insertSignup(signupDto);
	}

}
