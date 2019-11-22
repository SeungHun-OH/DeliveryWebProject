package com.cap.delivery.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.delivery.model.NoticeVO;
import com.cap.delivery.model.SearchDto;
import com.cap.delivery.service.NoticeService;

@RequestMapping("/")
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexMainGET(Model model) {
		logger.info("메인페이지입니다.");
		model.addAttribute("searchDto", new SearchDto());
		List<NoticeVO> noticeList = noticeService.mainList();
		model.addAttribute("noticeList", noticeList);
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
