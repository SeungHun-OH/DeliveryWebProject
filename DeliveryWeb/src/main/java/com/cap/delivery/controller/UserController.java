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

import com.cap.delivery.model.LoginDto;
import com.cap.delivery.model.LoginValidation;


@RequestMapping("/user")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired private LoginValidation loginValidation;
	
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
}
