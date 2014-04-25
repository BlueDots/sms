package jxau.sms.qing.participate.dao;

import java.util.HashMap;
import java.util.Map;

import jxau.sms.globaldao.Dao;
import jxau.sms.qing.po.Participate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("studentNo", "20111112");
		Participate p = dao.selectOne("jxau.sms.qing.participate.dao.selectParticipate",map);	
		System.out.println(p.getStudentPost());
	}

}
