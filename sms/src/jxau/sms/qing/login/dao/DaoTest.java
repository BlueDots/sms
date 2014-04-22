package jxau.sms.qing.login.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherNo", "1234");
		map.put("tecPassword", "11");
		int count = dao.selectOne("selectTeacher",map);
		System.out.println(count);
	}

}
