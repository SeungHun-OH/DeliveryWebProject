package com.cap.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cap.delivery.commons.paging.Criteria;
import com.cap.delivery.model.NoticeVO;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int noticeListCount() {
		return sqlSession.selectOne("noticeMapper.noticeListCount");
	}

	@Override
	public List<NoticeVO> noticeCriteria(Criteria criteria) {
		return sqlSession.selectList("noticeMapper.noticeCriteria", criteria);
	}

	@Override
	public NoticeVO noticeRead(Integer noticeNo) {
		return sqlSession.selectOne("noticeMapper.noticeRead", noticeNo);
	}

	@Override
	public void noticeModify(NoticeVO noticeVO) {
		sqlSession.update("noticeMapper.noticeModify", noticeVO);
	}
}
