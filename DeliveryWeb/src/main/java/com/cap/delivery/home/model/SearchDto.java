package com.cap.delivery.home.model;

import org.springframework.stereotype.Component;

@Component
public class SearchDto {

	private String waybillNum;

	public String getWaybillNum() {
		return waybillNum;
	}

	public void setWaybillNum(String waybillNum) {
		this.waybillNum = waybillNum;
	}

	@Override
	public String toString() {
		return "SearchDTO [waybillNum=" + waybillNum + "]";
	}
}
