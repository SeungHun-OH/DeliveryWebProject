package com.cap.delivery.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ReservationValidation implements Validator{
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationValidation.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return ReservationDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ReservationDto reservationDto = (ReservationDto) target;
	}
}
