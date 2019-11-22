package com.cap.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cap.delivery.model.InquiryVO;

@Repository
public class SupportDaoImpl implements SupportDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertInquiry(InquiryVO inquiryVO) {
		sqlSession.insert("supportMapper.inquiryInsert", inquiryVO);
	}
	
	

}
