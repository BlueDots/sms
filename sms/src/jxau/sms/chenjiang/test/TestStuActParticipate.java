package jxau.sms.chenjiang.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.chenjiang.po.ActInfo;
import jxau.sms.chenjiang.po.StuActParticipate;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.vo.StuActParticipateVO;
import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestStuActParticipate {
	
	@Test
	public void testAdd() {
   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
   	 StuActParticipate stuActParticipate = new StuActParticipate();
   	 ActInfo actInfo = new ActInfo();
   	 actInfo.setActNo(1);
   	 StuBasicInfo stuBasicInfo = new StuBasicInfo();
	 stuBasicInfo.setStudentNo("20111635");
   	 stuActParticipate.setActInfo(actInfo);
   	 stuActParticipate.setStuBasicInfo(stuBasicInfo);
   	 
   	 stuActParticipate.setSessionYear(1);
   	 stuActParticipate.setAwardTime(Date.valueOf("1111-11-11"));
   	 stuActParticipate.setActivityRating("一等奖");
   	 
   	 
	 dao.add("jxau.sms.chenjiang.stuActParticipate.dao.add", stuActParticipate);
	 System.out.println(stuActParticipate.getId());
	}
	
	@Test
	public void testBatchAdd() {
	   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	 
	   	 List<StuActParticipate> lists = new ArrayList<StuActParticipate>();

	  	 StuActParticipate s1 = new StuActParticipate();
	   	 ActInfo a1 = new ActInfo();
	   	a1.setActNo(2);
	   	 StuBasicInfo sb1 = new StuBasicInfo();
	   	sb1.setStudentNo("20111635");
		 s1.setActInfo(a1);
		 s1.setStuBasicInfo(sb1);
	   	 
		 s1.setSessionYear(2);
		 s1.setAwardTime(Date.valueOf("2211-1-13"));
		 s1.setActivityRating("二等奖");
		
	  	 StuActParticipate s2 = new StuActParticipate();
	   	 ActInfo a2 = new ActInfo();
	   	a2.setActNo(1);
	   	 StuBasicInfo sb2 = new StuBasicInfo();
	   	sb2.setStudentNo("20111636");
		 s2.setActInfo(a2);
		 s2.setStuBasicInfo(sb2);
	   	 
		 s2.setSessionYear(1);
		 s2.setAwardTime(Date.valueOf("1111-11-11"));
		 s2.setActivityRating("二等奖");
		 
		 lists.add(s1);
		 lists.add(s2);
	   	dao.batchAdd("jxau.sms.chenjiang.stuActParticipate.dao.batchAdd", lists);
	   		
	   	System.out.println(lists.size());
	   		 
	   	 
	}
	
	@Test
	public void testUpdate() {
		 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	 StuActParticipate stuActParticipate = new StuActParticipate();
	   	 ActInfo actInfo = new ActInfo();
	   	 actInfo.setActNo(3);
	   	 stuActParticipate.setActInfo(actInfo);
	   	 
	   	 stuActParticipate.setSessionYear(1);
	   	 stuActParticipate.setAwardTime(Date.valueOf("2011-11-11"));
	   	 stuActParticipate.setActivityRating("一等奖");
	   	 stuActParticipate.setId(13);
	   	 
		 dao.update("jxau.sms.chenjiang.stuActParticipate.dao.update", stuActParticipate);
		 System.out.println(stuActParticipate.getId());
	}
	
	@Test
	public void testBatchUpdate() {
		
	}
	
	@Test
	public void testQuery() {
		ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	List<StuActParticipateVO> lists = null;
	   	Map<String,Object> params = new HashMap<String, Object>();
	   	params.put("college", "软件学院");
	   	params.put("major", null);
	   	params.put("className", null);
	   	params.put("stuNoOrName", null);
   	    params.put("start", 0);
   	    params.put("nums", 5);
	   	lists = dao.select("jxau.sms.chenjiang.stuActParticipate.dao.query", params);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
	
	
	@Test
	public void testAdvancedQuery() {
		ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	List<StuBasicInfo> lists = null;
	   	Map<String,Object> params = new LinkedHashMap<String, Object>();
	   	List<String> order = new ArrayList<String>();
	   	params.put("major", "软件开发");
	   	params.put("sex", "0");
	   	
	   	for (String key : params.keySet()) {
	   	   order.add(key);
	   	  }
	   	
	   	
   	    params.put("order", order);
   	    params.put("start", 0);
   	    params.put("nums", 5);
   	    System.out.println(params);
	   	lists = dao.select("jxau.sms.stuBasicInfo.dao.advancedQuery", params);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
}
