package com.cap.delivery.dao;

import java.util.List;

import com.cap.delivery.model.MyDeliveryDto;
import com.cap.delivery.model.SearchResponseListVO;
import com.cap.delivery.model.SearchResponseVO;
import com.cap.delivery.model.UserInfoVO;
import com.cap.delivery.model.myDeliveryResponseList;

public interface MypageDao {
	List<myDeliveryResponseList> myDeliveryList(MyDeliveryDto myDeliveryDto);
	SearchResponseVO responseDelivery(String waybillNum);
	List<SearchResponseListVO> responseDeliveryList(String waybillNum);
	UserInfoVO getUserInfo(String userId);
	String getUserPwd(String userId);
	void modifyUserInfo(UserInfoVO userInfoVO);
}
