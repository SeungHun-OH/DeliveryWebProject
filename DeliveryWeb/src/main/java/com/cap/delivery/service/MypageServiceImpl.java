package com.cap.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.delivery.dao.MypageDao;
import com.cap.delivery.model.MyDeliveryDto;
import com.cap.delivery.model.SearchResponseListVO;
import com.cap.delivery.model.SearchResponseVO;
import com.cap.delivery.model.myDeliveryResponseList;

@Service
public class MypageServiceImpl implements MypageService{

	@Autowired
	private MypageDao mypageDao;

	@Override
	public List<myDeliveryResponseList> myDeliveryList(MyDeliveryDto myDeliveryDto) {
		return mypageDao.myDeliveryList(myDeliveryDto);
	}

	@Override
	public SearchResponseVO responseDelivery(String waybillNum) {
		return mypageDao.responseDelivery(waybillNum);
	}

	@Override
	public List<SearchResponseListVO> responseDeliveryList(String waybillNum) {
		return mypageDao.responseDeliveryList(waybillNum);
	}
}
