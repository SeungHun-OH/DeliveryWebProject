package com.cap.delivery.service;

import java.util.List;

import com.cap.delivery.model.MyDeliveryDto;
import com.cap.delivery.model.myDeliveryResponseList;

public interface MypageService {
	List<myDeliveryResponseList> myDeliveryList(MyDeliveryDto myDeliveryDto);
}
