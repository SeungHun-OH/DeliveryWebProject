package com.cap.delivery.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cap.delivery.model.SearchDto;
import com.cap.delivery.model.SearchResponseListVO;
import com.cap.delivery.model.SearchResponseVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public SearchResponseVO lookupResult(SearchDto searchDto) {
		return sqlSession.selectOne("boardMapper.lookupResult", searchDto);
	}

	@Override
	public List<SearchResponseListVO> lookupListResult(SearchDto searchDto) {
		return sqlSession.selectList("boardMapper.lookupListResult", searchDto);
	}

}
