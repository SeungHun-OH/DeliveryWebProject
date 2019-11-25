package com.cap.delivery.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyinquiryVO {

	private int inquiryType;
	private String title;
	private String waybillNumber;
	private Date regDate;
	private String inquiryStatus;
	private int inquiryNo;
	
	public int getInquiryType() {
		return inquiryType;
	}
	public void setInquiryType(int inquiryType) {
		this.inquiryType = inquiryType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWaybillNumber() {
		return waybillNumber;
	}
	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getInquiryStatus() {
		return inquiryStatus;
	}
	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
}
