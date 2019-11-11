package com.cap.delivery.model;

import org.springframework.stereotype.Component;

@Component
public class SearchDto {

	private String waybillNum;
	private String clickPage;

	public String getWaybillNum() {
		return waybillNum;
	}

	public void setWaybillNum(String waybillNum) {
		this.waybillNum = waybillNum;
	}

	public String getClickPage() {
		return clickPage;
	}

	public void setClickPage(String clickPage) {
		this.clickPage = clickPage;
	}

	@Override
	public String toString() {
		return "SearchDto [waybillNum=" + waybillNum + ", clickPage=" + clickPage + "]";
	}
}
