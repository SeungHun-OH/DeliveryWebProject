package com.cap.delivery.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.delivery.model.SearchDto;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexMainGET(Model model) {
		logger.info("메인페이지입니다.");
		model.addAttribute("searchDto", new SearchDto());
		return "/home/index";
	}
	
	@RequestMapping("/about")
	public String aboutGET() {
		return "/home/about";
	}
	
	@RequestMapping("/contact")
	public String contactGET() {
		return "/home/contact";
	}
	
	@RequestMapping("/post")
	public String postGET() {
		return "/home/post";
	}
}
