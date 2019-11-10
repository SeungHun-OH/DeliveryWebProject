package com.cap.delivery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JunitTest {

	private static final Logger logger = LoggerFactory.getLogger(JunitTest.class);
	
	@Test
	public void test() throws Exception {
		logger.info("junit 테스트");
	}
}
