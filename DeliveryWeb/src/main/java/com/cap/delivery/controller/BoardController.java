package com.cap.delivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.delivery.model.SearchDto;
import com.cap.delivery.model.SearchDtoValidation;
import com.cap.delivery.model.SearchResponseListVO;
import com.cap.delivery.model.SearchResponseVO;
import com.cap.delivery.service.BoardService;


@RequestMapping("/board")
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private SearchDtoValidation searchDtoValidation;
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(searchDtoValidation);
//	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchViewGet(Model model) {
		logger.info("운송장 조회 GET");
		model.addAttribute("searchDto", new SearchDto());
		return "/board/searchView";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchViewPOST(@Valid @ModelAttribute("searchDto") SearchDto searchDto, BindingResult result, Model model) {
		logger.info("운송장 조회 POST");
		searchDtoValidation.validate(searchDto, result);
		if(searchDto.getWaybillNum() != null) {
			if (result.hasErrors()) {
				// form에 에러가 있으면
				logger.info("에러검출");
				logger.info("컨트롤러 reservation: "+ searchDto.getReservationNum());
//				FieldError fieldError = result.getFieldError();
//				logger.info("에러이름: "+result.getFieldError());
//				flash.addFlashAttribute("errors",result);
				if(searchDto.getClickPage().equals("index")) 
					return "/home/index";
				return "/board/searchView";
			}
		}
		//에러가 없으면
		SearchResponseVO responseVO = boardService.lookupResult(searchDto);
		List<SearchResponseListVO> responseListVO = boardService.lookupListResult(searchDto);
		
		model.addAttribute("waybillNum", searchDto.getWaybillNum());
		model.addAttribute("response", responseVO);
		model.addAttribute("responseList", responseListVO);
		return "/board/searchView";
	}
}