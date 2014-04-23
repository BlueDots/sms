package jxau.sms.lyx.tecBasicInfo.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.TecBasicInfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {

	@Test
	public void test() {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionTecBasicInfoServiceImpl sessionTeacher = (SessionTecBasicInfoServiceImpl)context.getBean("SessionTecBasicInfoServiceImpl");
	
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherNo", "1234");
		
		TecBasicInfo teacher = sessionTeacher.searchByAccurate(map, 0);
	}

}
