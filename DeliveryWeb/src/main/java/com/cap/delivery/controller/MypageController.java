package com.cap.delivery.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.delivery.model.MyDeliveryDto;
import com.cap.delivery.model.SearchResponseListVO;
import com.cap.delivery.model.SearchResponseVO;
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
	public String searchViewGet(Model model, HttpSession session, MyDeliveryDto myDeliveryDto) {
		logger.info("마이페이지 내 운송장 GET");
		UserVO userVO = (UserVO)session.getAttribute("login");
		myDeliveryDto.setSessionInfo(userVO.getUserName(),userVO.getUserPhone()); 
		List<myDeliveryResponseList> response = mypageService.myDeliveryList(myDeliveryDto);
		model.addAttribute("myDelivery", myDeliveryDto);
		model.addAttribute("responseList", response);
		return "/mypage/myDeliveryView";
	}
	
	@RequestMapping(value = "/mydelivery", method = RequestMethod.POST)
	public String searchViewPOST(@ModelAttribute("myDelivery") MyDeliveryDto myDeliveryDto, Model model, @RequestParam(value="dateBtn") String clickBtn) {
		logger.info("마이페이지 내 운송장 POST");
		List<myDeliveryResponseList> response = mypageService.myDeliveryList(myDeliveryDto);
		model.addAttribute("responseList", response);
		model.addAttribute("activeBtn",clickBtn);
		return "/mypage/myDeliveryView";
	}
	
	@ResponseBody
	@RequestMapping(value = "/mydeliveryDetail", method = RequestMethod.POST)
	public HashMap<String, Object> ajaxMydeliveryDeliveryPOST(@RequestBody String reciveData) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject)jsonParser.parse(reciveData);
		String waybillNum = (String) jsonObj.get("waybillNum");
		SearchResponseVO response = mypageService.responseDelivery(waybillNum);
		List<SearchResponseListVO> responseList = mypageService.responseDeliveryList(waybillNum);
		
		map.put("response", response);
		map.put("responseList", responseList);
		return map;
	}
}
