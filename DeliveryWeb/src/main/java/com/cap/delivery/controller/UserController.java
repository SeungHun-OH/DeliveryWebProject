package com.cap.delivery.controller;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cap.delivery.model.LoginDto;
import com.cap.delivery.model.LoginValidation;
import com.cap.delivery.model.SignupDto;
import com.cap.delivery.model.SignupValidation;
import com.cap.delivery.model.UserVO;
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
	public String loginViewPost(@Valid @ModelAttribute("loginDto") LoginDto loginDto, BindingResult result ,Model model, RedirectAttributes redirect) {
		logger.info("로그인 POST");
		loginValidation.validate(loginDto, result);
		if (result.hasErrors()) {
			logger.info("로그인 에러 검출");
			return "/user/loginView"; 
		}
		
		String dbPwd = userService.login(loginDto.getUserId());
		if(dbPwd == null || !BCrypt.checkpw(loginDto.getUserPwd(), dbPwd)) {
			logger.info("로그인 실패");
			model.addAttribute("loginDto", new LoginDto());
			return "/user/loginView";
		}
		
		UserVO userVO = userService.sessionRegister(loginDto);
		logger.info("로그인 성공");
		
//		if(userVO == null) {
//			logger.info("로그인 실패");
//			return "redirect: /user/login";
//		} 
		redirect.addFlashAttribute("userVO", userVO);
		return "redirect: /user/loginSuccess";
	}
	
	@RequestMapping(value = "/loginSuccess")
	public void loginViewPost(@ModelAttribute("userVO") UserVO userVO) {
		logger.info("여기옴");
		System.out.println(userVO.toString());
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
		logger.info("값 들어온거: "+signupDto.toString());
		signupValidation.validate(signupDto, result);
		if (result.hasErrors()) {
			logger.info("회원가입 에러 검출");
			model.addAttribute("reloadForm",signupDto);
			return "/user/signupView"; 
		}
		logger.info("toString:"+signupDto.toString());
		
		String hashPw = BCrypt.hashpw(signupDto.getUserPwd(), BCrypt.gensalt());
		signupDto.setUserPwd(hashPw);
		
		userService.insertSignup(signupDto);
		return "redirect: /";
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
