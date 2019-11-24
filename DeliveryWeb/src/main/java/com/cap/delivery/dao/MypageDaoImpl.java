package com.cap.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cap.delivery.model.MyDeliveryDto;
import com.cap.delivery.model.SearchResponseListVO;
import com.cap.delivery.model.SearchResponseVO;
import com.cap.delivery.model.myDeliveryResponseList;

@Repository
public class MypageDaoImpl implements MypageDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<myDeliveryResponseList> myDeliveryList(MyDeliveryDto myDeliveryDto) {
		return sqlSession.selectList("mypageMapper.myDeliveryList", myDeliveryDto);
	}

	@Override
	public SearchResponseVO responseDelivery(String waybillNum) {
		return sqlSession.selectOne("mypageMapper.responseDelivery", waybillNum);
	}

	@Override
	public List<SearchResponseListVO> responseDeliveryList(String waybillNum) {
		return sqlSession.selectList("mypageMapper.responseDeliveryList", waybillNum);
	}

}
