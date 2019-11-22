package com.cap.delivery.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

import com.cap.delivery.model.InquiryVO;
import com.cap.delivery.model.InquiryValidation;
import com.cap.delivery.service.SupportService;

@Controller
@RequestMapping("/support")
public class SupportController {

	private static final Logger logger = LoggerFactory.getLogger(SupportController.class);
	
	@Autowired
	private InquiryValidation inquiryValidation;
	
	@Resource(name = "uploadPath")
	 private String uploadPath;
	
	@Autowired
	private SupportService supportService;
	
	@RequestMapping(value = "/inquiry", method = RequestMethod.GET)
	public String inquiryViewGET(Model model, HttpSession session) {
		logger.info("고객문의 GET");
		supportService.deleteFile(session, uploadPath);
		model.addAttribute("inquiry", new InquiryVO());
		return "support/inquiryView";
	}
	
	@RequestMapping(value = "/inquiry", method = RequestMethod.POST)
	public String inquiryViewPOST(@Valid @ModelAttribute("inquiry") InquiryVO inquiryVO, BindingResult result ,Model model, HttpSession session) {
		logger.info("고객문의 POST");
		inquiryValidation.validate(inquiryVO, result);
		if(result.hasErrors()) {
			logger.info("에러검출");
			supportService.deleteFile(session, uploadPath);
			return "support/inquiryView";
		}
		
		supportService.insertInquiry(inquiryVO);
		return "support/inquiryView";
	}
}