package com.cap.delivery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cap.delivery.commons.paging.Criteria;
import com.cap.delivery.commons.paging.PageMaker;
import com.cap.delivery.service.NoticeService;



@RequestMapping("/notice")
@Controller
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String noticeListViewGet(@RequestParam(required = false, defaultValue = "1") int page, Model model, Criteria criteria) {
		logger.info("공지사항 GET");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(noticeService.noticeListCount());
		
		model.addAttribute("noticeList", noticeService.noticeCriteria(criteria));
		model.addAttribute("page", page);
		model.addAttribute("pageMaker", pageMaker);
		return "/notice/listView";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(@RequestParam("noticeNo") int noticeNo, @ModelAttribute("criteria") Criteria criteria, Model model) throws Exception {
		logger.info("게시글 GET");
		System.out.println(criteria.toString());
		model.addAttribute("notice", noticeService.noticeRead(noticeNo));
		return "/notice/readView";
	}
}
