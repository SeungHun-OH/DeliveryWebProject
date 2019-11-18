package com.cap.delivery.service;

import com.cap.delivery.model.SignupDto;

public interface UserService {
	int ajaxChkId(String inputId);
	void insertSignup(SignupDto signupDto);
}
