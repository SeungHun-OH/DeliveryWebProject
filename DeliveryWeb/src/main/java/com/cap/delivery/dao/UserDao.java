package com.cap.delivery.dao;

import com.cap.delivery.model.SignupDto;

public interface UserDao {
	int ajaxChkId(String inputId);
	void insertSignup(SignupDto signupDto);
}
