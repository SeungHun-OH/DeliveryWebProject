package com.cap.delivery;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cap.delivery.dao.BoardDao;
import com.cap.delivery.model.SearchDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JunitTest {

	private static final Logger logger = LoggerFactory.getLogger(JunitTest.class);
	
	@Inject
	private BoardDao boardDao;
	
	@Test
	public void test() throws Exception {
		SearchDto searchDto = new SearchDto();
		searchDto.setWaybillNum("BIS02A00001538");
		boardDao.lookupResult(searchDto);
	}
}
