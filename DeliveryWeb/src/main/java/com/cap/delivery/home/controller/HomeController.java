package com.cap.delivery.home.controller;


import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cap.delivery.home.model.SearchDto;
import com.cap.delivery.home.model.SearchDtoValidation;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private SearchDtoValidation searchDtoValidation;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(searchDtoValidation);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexMainGET(Model model) {
		logger.info("메인페이지입니다.");
		model.addAttribute("searchDto", new SearchDto());
		return "/home/index";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String indexMainPOST(@Valid @ModelAttribute("searchDto") SearchDto searchDto, BindingResult result, Model model, RedirectAttributes flash) {
		if (result.hasErrors()) {
			logger.info("home/ 에러검출");
			return "home/index";
		}
		model.addAttribute("waybillNum", searchDto.getWaybillNum());
		return "forward:board/search";
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
