package jxau.sms.lyx.sysPurviewConfig.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.vo.SessionPurview;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {

	@Test
	public void test() {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysPurviewConfigserviceimpl spc = (SysPurviewConfigserviceimpl)context.getBean("SysPurviewConfigserviceimpl");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherNo", "1234");
		map.put("roleName", "院级工作人员");
		
		SessionPurview sessionPurview = spc.searchByAccurate(map,0);
		
		System.out.println(sessionPurview.getRoleNo());
		System.out.println(sessionPurview.getPurviewInfo().get(1).getPurviewName());
		System.out.println(sessionPurview.getRoleName());
	}

}
