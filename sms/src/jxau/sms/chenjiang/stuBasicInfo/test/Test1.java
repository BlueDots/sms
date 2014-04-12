package jxau.sms.chenjiang.stuBasicInfo.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.chenjiang.stuBasicInfo.po.StuBasicInfo;
import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test1 {
	
	@Test
	public void testAdd() {
   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
   	 StuBasicInfo stuBasicInfo = new StuBasicInfo();
	 stuBasicInfo.setStudentNo("20111635");
	 stuBasicInfo.setStudentName("陈江");
	 stuBasicInfo.setBirthday(Date.valueOf("1993-03-26"));
	 stuBasicInfo.setClassName("软件1107");
	 stuBasicInfo.setMajor("数字媒体");
	 stuBasicInfo.setCollege("软件学院");
	 stuBasicInfo.setSex(1);
	 stuBasicInfo.setNation("汉族");
	 stuBasicInfo.setHometown("天朝");
	 stuBasicInfo.setPolitical("群众");
	 stuBasicInfo.setIdCard("111111111111111111");  
	 dao.add("jxau.sms.stuBasicInfo.dao.add", stuBasicInfo);
	 System.out.println(stuBasicInfo.getStudentNo());
	}
	
	@Test
	public void testBatchAdd() {
	   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	 
	   	 List<StuBasicInfo> lists = new ArrayList<StuBasicInfo>();
	   	   	 StuBasicInfo s1 = new StuBasicInfo();
	   		 s1.setStudentNo("20111636");
	   		 s1.setStudentName("易伟");
	   		 s1.setBirthday(Date.valueOf("1993-03-26"));
	   		 s1.setClassName("软件1107");
	   		 s1.setMajor("数字媒体");
	   		 s1.setCollege("软件学院");
	   		 s1.setSex(1);
	   		 s1.setNation("汉族");
	   		 s1.setHometown("天朝");
	   		 s1.setPolitical("群众");
	   		 s1.setIdCard("111111111111111111");   
	   		 
	   	   	 StuBasicInfo s2 = new StuBasicInfo();
	   		 s2.setStudentNo("20111367");
	   		 s2.setStudentName("李轶翔");
	   		 s2.setBirthday(Date.valueOf("1993-05-24"));
	   		 s2.setClassName("软件1101");
	   		 s2.setMajor("软件开发");
	   		 s2.setCollege("软件学院");
	   		 s2.setSex(1);
	   		 s2.setNation("汉族");
	   		 s2.setHometown("天朝");
	   		 s2.setPolitical("群众");
	   		 s2.setIdCard("111111111111111111");  
	   		 
	   	   	 StuBasicInfo s3 = new StuBasicInfo();
	   		 s3.setStudentNo("20111826");
	   		 s3.setStudentName("赖辉强");
	   		 s3.setBirthday(Date.valueOf("1992-07-22"));
	   		 s3.setClassName("软件1111");
	   		 s3.setMajor("软件+英语");
	   		 s3.setCollege("软件学院");
	   		 s3.setSex(1);
	   		 s3.setNation("汉族");
	   		 s3.setHometown("天朝");
	   		 s3.setPolitical("群众");
	   		 s3.setIdCard("111111111111111111");  
	   		 
	   	   	 StuBasicInfo s4 = new StuBasicInfo();
	   		 s4.setStudentNo("20111429");
	   		 s4.setStudentName("嘎啦");
	   		 s4.setBirthday(Date.valueOf("1992-07-22"));
	   		 s4.setClassName("软件1111");
	   		 s4.setMajor("软件开发");
	   		 s4.setCollege("软件学院");
	   		 s4.setSex(1);
	   		 s4.setNation("汉族");
	   		 s4.setHometown("天朝");
	   		 s4.setPolitical("群众");
	   		 s4.setIdCard("111111111111111111"); 
	   		 
	   		 lists.add(s1);
	   		lists.add(s2);
	   		lists.add(s3);
	   		lists.add(s4);
	   		dao.batchAdd("jxau.sms.stuBasicInfo.dao.batchAdd", lists);
	   		
	   		System.out.println(lists.size());
	   		 
	   	 
	}
	
	@Test
	public void testUpdate() {
		 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
   	   	 StuBasicInfo s4 = new StuBasicInfo();
   		 s4.setStudentNo("20111429");
   		 s4.setStudentName("嘎啦");
   		 s4.setBirthday(Date.valueOf("1992-07-22"));
   		 s4.setClassName("软件1102");
   		 s4.setMajor("软件开发");
   		 s4.setCollege("软件学院");
   		 s4.setSex(1);
   		 s4.setNation("汉族");
   		 s4.setHometown("天朝");
   		 s4.setPolitical("群众");
   		 s4.setIdCard("111111111111111111"); 
   		 dao.update("jxau.sms.stuBasicInfo.dao.update", s4);
	}
	
	@Test
	public void testBatchUpdate() {
	   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	 
	   	 List<StuBasicInfo> lists = new ArrayList<StuBasicInfo>();
	   	 StuBasicInfo s1 = new StuBasicInfo();
	     s1.setStudentNo("20111636");
	     s1.setIdCard("222222222222222222");   
	   		 
	   	 StuBasicInfo s2 = new StuBasicInfo();
	     s2.setStudentNo("20111367");
	     s2.setIdCard("222222222222222222");  
	   		 
	   	 StuBasicInfo s3 = new StuBasicInfo();
	   	 s3.setStudentNo("20111826");
	   		 s3.setIdCard("222222222222222222");  
	   		 
	   	   	 StuBasicInfo s4 = new StuBasicInfo();
	   		 s4.setStudentNo("20111429");
	   		 s4.setIdCard("222222222222222222"); 
	   		 
	   		lists.add(s1);
	   		lists.add(s2);
	   		lists.add(s3);
	   		lists.add(s4);
	   		dao.batchUpdate("jxau.sms.stuBasicInfo.dao.batchUpdate", lists);
	   		
	   		System.out.println(lists.size());
	}
	
	@Test
	public void testQuery() {
		ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	List<StuBasicInfo> lists = null;
	   	Map<String,Object> params = new HashMap<String, Object>();
	   	params.put("college", "软件学院");
	   	params.put("major", null);
	   	params.put("className", null);
	   	params.put("stuNoOrName", null);
	   	lists = dao.select("jxau.sms.stuBasicInfo.dao.query", params);
	   	
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
   	    System.out.println(params);
	   	lists = dao.select("jxau.sms.stuBasicInfo.dao.advancedQuery", params);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
}
