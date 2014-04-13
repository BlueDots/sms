package jxau.sms.chenjiang.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.chenjiang.po.ActHold;
import jxau.sms.chenjiang.po.ActInfo;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.vo.ActInfoVO;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.TecBasicInfo;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestActHold {
	
	@Test
	public void testAdd() {
   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
   	 ActHold actHold = new ActHold();
   	 ActInfo actInfo = new ActInfo();
   	 actInfo.setActNo(1);
   	 actHold.setActInfo(actInfo);
   	 actHold.setSessionYear(3);
   	 actHold.setStartTime(Date.valueOf("2004-11-11"));
   	 actHold.setEndTime(Date.valueOf("2004-11-11"));
   	 actHold.setHoldPlace("科技楼");
	 dao.add("jxau.sms.chenjiang.activityManage.ActHold.dao.add", actHold);
	 System.out.println(actHold.getId());
	}
	
	
	@Test
	public void testUpdate() {
	   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	 ActHold actHold = new ActHold();
	   	 actHold.setId(3);
	   	 ActInfo actInfo = new ActInfo();
	   	 actInfo.setActNo(1);
	   	 actHold.setActInfo(actInfo);
	   	 actHold.setSessionYear(3);
	   	 actHold.setStartTime(Date.valueOf("2002-11-11"));
	   	 actHold.setEndTime(Date.valueOf("2002-11-11"));
	   	 actHold.setHoldPlace("asasas");
		 dao.update("jxau.sms.chenjiang.activityManage.ActHold.dao.update", actHold);
		 System.out.println(actHold.getId());
	}
	
	@Test
	public void testBatchUpdate() {
	   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	 List<ActInfo> lists = new ArrayList<ActInfo>();
	   	 ActInfo a1 = new ActInfo();
	   	 a1.setActNo(4);
	   	a1.setActivityName("asasd");
	   	a1.setActivityType("实践创新类");
	   	a1.setActivityLevel("院级");
	   	a1.setSponsor("jxau");
	   	a1.setOrganize("软件学院");
	   	 TecBasicInfo t1 = new TecBasicInfo();
	   	 t1.setTeacherNo("4610");
	   	a1.setTecBasicInfo(t1);
	   	
	   	 ActInfo a2 = new ActInfo();
		 a2.setActNo(5);
	   	a2.setActivityName("r444");
	   	a2.setActivityType("实践创新类");
	   	a2.setActivityLevel("院级");
	   	a2.setSponsor("jxau");
	   	a2.setOrganize("软件学院");
	   	 TecBasicInfo t2 = new TecBasicInfo();
	   	 t2.setTeacherNo("4610");
	   	a2.setTecBasicInfo(t2);
	   	
	   	lists.add(a1);
	   	lists.add(a2);
	   	
	   	dao.batchUpdate("jxau.sms.chenjiang.activityManage.ActHold.dao.update", lists);
	   
	   System.out.println(lists.size());
	}
	
	@Test
	public void testQuery() {
		ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	List<ActInfoVO> lists = null;
	   	Map<String,Object> params = new HashMap<String, Object>();
	   	params.put("actNo", 1);
	   	params.put("start", 0);
	   	params.put("nums", 5);
	   	lists = dao.select("jxau.sms.chenjiang.activityManage.ActHold.dao.query", params);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
	@Test
	public void testDelete() {
	   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	 ActHold actHold = new ActHold();
	   	 actHold.setId(4);
		 dao.delete("jxau.sms.chenjiang.activityManage.ActHold.dao.delete", actHold);
		 System.out.println(actHold.getId());
	}
	
	
}
