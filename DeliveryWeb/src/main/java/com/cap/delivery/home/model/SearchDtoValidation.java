package com.cap.delivery.home.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cap.delivery.home.controller.HomeController;

@Component
public class SearchDtoValidation implements Validator{
	
	private static final Logger logger = LoggerFactory.getLogger(SearchDtoValidation.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return SearchDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SearchDto searchDto = (SearchDto) target;
		
		String waybillNum = searchDto.getWaybillNum();
		if(waybillNum == null || waybillNum.trim().isEmpty()) {
			errors.rejectValue("waybillNum", "home.waybillNum.required", "운송장 번호를 입력해주세요.");
		}else {
			if(searchDto.getWaybillNum().length() != 11) {
				errors.rejectValue("waybillNum", "home.waybillNum.lengthsize", new Object[]{11}, "운송장 11자를 입력해주세요.");
			}
		}
		
	}

}
