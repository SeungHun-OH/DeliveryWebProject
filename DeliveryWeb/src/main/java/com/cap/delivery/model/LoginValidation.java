package com.cap.delivery.model;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginValidation implements Validator{

	private static final Logger logger = LoggerFactory.getLogger(LoginValidation.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginDto loginDto = (LoginDto) target;
		
		if(loginDto.getUserId() == null || loginDto.getUserId().trim().isEmpty()) {
			logger.info("로그인 아이디 미입력 에러");
			errors.rejectValue("userId", "login.userId.required", "아이디를 입력해주세요.");
		}
		else if(loginDto.getUserId() == null || loginDto.getUserId().length() > 20) {
			logger.info("로그인 아이디 20자 초과 에러");
			errors.rejectValue("userId", "login.userId.lengthsize", new Object[]{20}, "최대 20자까지만 입력가능합니다.");
		}
		else if(Pattern.matches("^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$", loginDto.getUserId())) {
			logger.info("로그인 아이디 한글 입력 에러");
			errors.rejectValue("userId", "login.userId.pattern", "한글은 입력할 수 없습니다.");
		}
	}
}
