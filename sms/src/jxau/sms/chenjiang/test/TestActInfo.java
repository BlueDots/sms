package jxau.sms.chenjiang.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.chenjiang.po.ActInfo;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.TecBasicInfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestActInfo {
	
	@Test
	public void testAdd() {
   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
   	 ActInfo aInfo1 = new ActInfo();
   	 aInfo1.setActivityName("网页设计大赛");
   	 aInfo1.setActivityType("学术科技类");
   	 aInfo1.setActivityLevel("院级");
   	 aInfo1.setSponsor("软件学院");
   	 aInfo1.setOrganize("软件学院");
   	 TecBasicInfo teacher = new TecBasicInfo();
   	 teacher.setTeacherNo("4611");
   	 aInfo1.setTecBasicInfo(teacher);
   	 aInfo1.setStudentName("嘎啦");  
	 dao.add("jxau.sms.chenjiang.activityManage.ActInfo.dao.add", aInfo1);
	 System.out.println(aInfo1.getActNo());
	}
	
	@Test
	public void testBatchAdd() {
	   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	 List<ActInfo> lists = new ArrayList<ActInfo>();
	   	 ActInfo a1 = new ActInfo();
	   	a1.setActivityName("aaa");
	   	a1.setActivityType("实践创新类");
	   	a1.setActivityLevel("院级");
	   	a1.setSponsor("软件学院");
	   	a1.setOrganize("软件学院");
	   	 TecBasicInfo t1 = new TecBasicInfo();
	   	 t1.setTeacherNo("4611");
	   	a1.setTecBasicInfo(t1);
	   	
	   	 ActInfo a2 = new ActInfo();
	   	a2.setActivityName("bbb");
	   	a2.setActivityType("实践创新类");
	   	a2.setActivityLevel("院级");
	   	a2.setSponsor("软件学院");
	   	a2.setOrganize("软件学院");
	   	 TecBasicInfo t2 = new TecBasicInfo();
	   	 t2.setTeacherNo("4611");
	   	a2.setTecBasicInfo(t2);
	   	
	   	lists.add(a1);
	   	lists.add(a2);
	   	

	   		dao.batchAdd("jxau.sms.chenjiang.activityManage.ActInfo.dao.batchAdd", lists);
	   		
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
