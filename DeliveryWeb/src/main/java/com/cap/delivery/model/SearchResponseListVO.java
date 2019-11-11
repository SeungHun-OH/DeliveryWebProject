package com.cap.delivery.model;

import org.springframework.stereotype.Component;

@Component
public class SearchResponseListVO {

	private String deliveryStep;
	private String processTime;
	private String productStatus;
	
	public String getDeliveryStep() {
		return deliveryStep;
	}
	public void setDeliveryStep(String deliveryStep) {
		this.deliveryStep = deliveryStep;
	}
	public String getProcessTime() {
		return processTime;
	}
	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	
	@Override
	public String toString() {
		return "SearchResponseListVO [deliveryStep=" + deliveryStep + ", processTime=" + processTime
				+ ", productStatus=" + productStatus + "]";
	}
}
