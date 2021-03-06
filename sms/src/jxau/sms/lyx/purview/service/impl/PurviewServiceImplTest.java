package jxau.sms.lyx.purview.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.lyx.po.RolePurview;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PurviewServiceImplTest {

	@Test
	public void test() {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserPurviewManagerServiceImpl rhp = (UserPurviewManagerServiceImpl)context.getBean("UserPurviewManagerServiceImpl");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherNo", "1234");
				
		rhp.searchListByAccurate(map,0);
		
	}
	
	@Test
	public void test2() {
		String number = "1234";		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		PurviewListPackage plp = (PurviewListPackage)context.getBean("PurviewListPackage");
		plp.containerTransform(number,"2,3,4,5");
		
	}

}
