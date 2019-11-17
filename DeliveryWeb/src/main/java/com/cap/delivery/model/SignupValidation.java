package com.cap.delivery.model;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignupValidation implements Validator{

	private static final Logger logger = LoggerFactory.getLogger(SignupValidation.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return SignupDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignupDto signupDto = (SignupDto) target;
		
		if(signupDto.getUserId() == null || signupDto.getUserId().trim().isEmpty()) {
			logger.info("회원가입 아이디 미입력 에러");
			errors.rejectValue("userId", "signup.userId.required", "아이디를 입력해주세요.");
		}
		else if(!Pattern.matches("^[a-zA-Z0-9]*$", signupDto.getUserId())) {
			logger.info("회원가입 아이디 입력 에러");
			errors.rejectValue("userId", "signup.userId.pattern", "영문과 숫자만 입력할 수 있습니다.");
		}
		else if(signupDto.getUserId().length() > 20) {
			logger.info("회원가입 아이디 20자 초과 에러");
			errors.rejectValue("userId", "signup.userId.lengthsize", new Object[]{20}, "최대 20자까지 입력가능합니다.");
		}
		if(signupDto.getUserPwd() == null || signupDto.getUserPwd().trim().isEmpty()) {
			logger.info("회원가입 비밀번호 미입력 에러");
			errors.rejectValue("userPwd", "signup.userPwd.required", "비밀번호를 입력해주세요.");
		}
		if(signupDto.getUserName() == null || signupDto.getUserName().trim().isEmpty()) {
			logger.info("회원가입 이름 미입력 에러");
			errors.rejectValue("userName", "signup.userName.required", "이름을 입력해주세요.");
		}
		else if(!Pattern.matches("^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$", signupDto.getUserName())) {
			logger.info("회원가입 이름 입력 에러");
			errors.rejectValue("userName", "signup.userName.pattern", "한글만 입력해주세요.");
		}
		if((signupDto.getUserEmail1() == null || signupDto.getUserEmail1().trim().isEmpty()) || (signupDto.getUserEmail2() == null || signupDto.getUserEmail2().trim().isEmpty())) {
			logger.info("회원가입 이메일 미입력 에러");
			errors.rejectValue("userEmail2", "signup.userEmail.required", "이메일을 입력해주세요.");
		}else if((!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*$", signupDto.getUserEmail1())) || (!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", signupDto.getUserEmail2()))) {
//		}else if(!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", signupDto.getUserEmail2())) {
			logger.info("회원가입 이메일 입력 에러");
			errors.rejectValue("userEmail2", "signup.userEmail.pattern", "올바른 이메일을 입력해주세요.");
		}
	}
}
