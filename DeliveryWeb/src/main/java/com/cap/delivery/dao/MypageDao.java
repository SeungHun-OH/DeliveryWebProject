package com.cap.delivery.dao;

import java.util.List;

import com.cap.delivery.model.MyDeliveryDto;
import com.cap.delivery.model.myDeliveryResponseList;

public interface MypageDao {
	List<myDeliveryResponseList> myDeliveryList(MyDeliveryDto myDeliveryDto);
}
