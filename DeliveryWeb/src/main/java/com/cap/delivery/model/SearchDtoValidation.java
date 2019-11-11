package com.cap.delivery.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



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
		String type = searchDto.getType();
		if(type.equals("waybillNum")) {
			String waybillNum = searchDto.getWaybillNum();
		
			if(waybillNum == null || waybillNum.trim().isEmpty()) {
				errors.rejectValue("waybillNum", "home.waybillNum.required", "운송장 번호를 입력해주세요.");
			}else {
				if(searchDto.getWaybillNum().length() != 11) {
				errors.rejectValue("waybillNum", "home.waybillNum.lengthsize", new Object[]{11}, "운송장 11자를 입력해주세요.");
				}
			}
		}else if(type.equals("reservationNum")) {
			logger.info("reservation 에러 검출");
			String reservationNum = searchDto.getReservationNum();
			if(reservationNum == null || reservationNum.trim().isEmpty()) {
				errors.rejectValue("reservationNum", "home.reservationNum.required", "예약 번호를 입력해주세요.");
			}else {
				if(searchDto.getReservationNum().length() != 12) {
				errors.rejectValue("reservationNum", "home.reservationNum.lengthsize", new Object[]{12}, "예약번호 12자를 입력해주세요.");
				}
			}
		}
	}
}
