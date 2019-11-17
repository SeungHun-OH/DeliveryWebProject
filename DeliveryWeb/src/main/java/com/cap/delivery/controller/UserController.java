package com.cap.delivery.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.delivery.model.LoginDto;
import com.cap.delivery.model.LoginValidation;
import com.cap.delivery.model.SignupDto;
import com.cap.delivery.model.SignupValidation;
import com.cap.delivery.service.UserService;


@RequestMapping("/user")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired 
	private LoginValidation loginValidation;
	
	@Autowired
	private SignupValidation signupValidation;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginViewGet(Model model) {
		logger.info("로그인 GET");
		model.addAttribute("loginDto", new LoginDto());
		return "/user/loginView";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginViewPost(@Valid @ModelAttribute("loginDto") LoginDto loginDto, BindingResult result ,Model model) {
		logger.info("로그인 POST");
		loginValidation.validate(loginDto, result);
		if (result.hasErrors()) {
			logger.info("로그인 에러 검출");
			return "/user/loginView"; 
		}
		return null;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupViewGet(Model model) {
		logger.info("회원가입 GET");
		model.addAttribute("signupDto", new SignupDto());
		return "/user/signupView";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupViewPost(@Valid @ModelAttribute("signupDto") SignupDto signupDto, BindingResult result ,Model model) {
		logger.info("회원가입 POST");
		signupValidation.validate(signupDto, result);
		if (result.hasErrors()) {
			logger.info("회원가입 에러 검출");
			return "/user/signupView"; 
		}
		return "/user/signupView";
	}
	
	
	
	//	ajax부분
	@ResponseBody
	@RequestMapping(value = "/ajaxChkId", method = RequestMethod.POST)
	public String signupChkId(@RequestParam("inputId") String inputId) {
		if(userService.ajaxChkId(inputId) == 0)
			return "YES";
		else {
			return "NO";
		}
	}
}
