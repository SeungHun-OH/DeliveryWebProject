package com.cap.delivery.model;


import org.springframework.stereotype.Component;

@Component
public class ReservationDto {
	private String senderName;
	private String senderPhone;
	private String senderPostCode;
	private String senderAddr1;
	private String senderAddr2;
	private String senderReq;
	private String receiverName;
	private String receiverPhone;
	private String receiverPostCode;
	private String receiverAddr1;
	private String receiverAddr2;
	private String productName;
	private Integer productPrice;
	private String dateOfVisit; // 방문 희망일
	private int fareCategoryCode; // 운임 구분
	private int productWeight; // 상품 부피
	private Integer freightCost; // 운임 비용
	private int courierCode; //택배 회사 코드
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderPostCode() {
		return senderPostCode;
	}
	public void setSenderPostCode(String senderPostCode) {
		this.senderPostCode = senderPostCode;
	}
	public String getSenderAddr1() {
		return senderAddr1;
	}
	public void setSenderAddr1(String senderAddr1) {
		this.senderAddr1 = senderAddr1;
	}
	public String getSenderAddr2() {
		return senderAddr2;
	}
	public void setSenderAddr2(String senderAddr2) {
		this.senderAddr2 = senderAddr2;
	}
	public String getSenderReq() {
		return senderReq;
	}
	public void setSenderReq(String senderReq) {
		this.senderReq = senderReq;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverPostCode() {
		return receiverPostCode;
	}
	public void setReceiverPostCode(String receiverPostCode) {
		this.receiverPostCode = receiverPostCode;
	}
	public String getReceiverAddr1() {
		return receiverAddr1;
	}
	public void setReceiverAddr1(String receiverAddr1) {
		this.receiverAddr1 = receiverAddr1;
	}
	public String getReceiverAddr2() {
		return receiverAddr2;
	}
	public void setReceiverAddr2(String receiverAddr2) {
		this.receiverAddr2 = receiverAddr2;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getFareCategoryCode() {
		return fareCategoryCode;
	}
	public void setFareCategoryCode(int fareCategoryCode) {
		this.fareCategoryCode = fareCategoryCode;
	}
	public int getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}
	public int getCourierCode() {
		return courierCode;
	}
	public void setCourierCode(int courierCode) {
		this.courierCode = courierCode;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getFreightCost() {
		return freightCost;
	}
	public void setFreightCost(Integer freightCost) {
		this.freightCost = freightCost;
	}
}
