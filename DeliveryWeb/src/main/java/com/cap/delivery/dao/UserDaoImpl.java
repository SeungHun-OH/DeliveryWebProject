package com.cap.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cap.delivery.model.SignupDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int ajaxChkId(String inputId) {
		return sqlSession.selectOne("userMapper.chkInputId", inputId);
	}

	@Override
	public void insertSignup(SignupDto signupDto) {
		sqlSession.insert("userMapper.insertSignup", signupDto);
	}

}
