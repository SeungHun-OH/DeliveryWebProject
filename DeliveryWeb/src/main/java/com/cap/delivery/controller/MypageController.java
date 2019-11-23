package com.cap.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.delivery.model.MyDeliveryDto;
import com.cap.delivery.model.UserVO;
import com.cap.delivery.model.myDeliveryResponseList;
import com.cap.delivery.service.MypageService;

@RequestMapping("/mypage")
@Controller
public class MypageController {

	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageService mypageService;
	
	@RequestMapping(value = "/mydelivery", method = RequestMethod.GET)
	public String searchViewGet(Model model, HttpSession session) {
		logger.info("마이페이지 내 운송장 GET");
		UserVO userVO = (UserVO)session.getAttribute("login");
		MyDeliveryDto myDeliveryDto = new MyDeliveryDto(userVO); 
		List<myDeliveryResponseList> response = mypageService.myDeliveryList(myDeliveryDto);
		model.addAttribute("myDelivery", myDeliveryDto);
		model.addAttribute("response", response);
		for(myDeliveryResponseList i : response)
			System.out.println(i.toString());
			
		return "/mypage/myDeliveryView";
	}
	
	@RequestMapping(value = "/mydelivery", method = RequestMethod.POST)
	public String searchViewPOST(Model model) {
		return null;
	}
}
