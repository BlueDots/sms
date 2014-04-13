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
import jxau.sms.chenjiang.vo.ActInfoVO;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.TeacherInfo.po.TecBasicInfo;

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
	   	 ActInfo aInfo1 = new ActInfo();
	   	 aInfo1.setActNo(5);
	   	 aInfo1.setActivityName("网页设ass计大赛");
	   	 aInfo1.setActivityType("学术科ass技类");
	   	 aInfo1.setActivityLevel("院as级");
	   	 aInfo1.setSponsor("软件asas学院");
	   	 aInfo1.setOrganize("a件asas学院");
	   	 TecBasicInfo teacher = new TecBasicInfo();
	   	 teacher.setTeacherNo("4611");
	   	 aInfo1.setTecBasicInfo(teacher);
	   	 aInfo1.setStudentName("aasasas");  
		 dao.update("jxau.sms.chenjiang.activityManage.ActInfo.dao.update", aInfo1);
		 System.out.println(aInfo1.getActNo());
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
	   	
	   	dao.batchUpdate("jxau.sms.chenjiang.activityManage.ActInfo.dao.update", lists);
	   
	   System.out.println(lists.size());
	}
	
	@Test
	public void testQuery() {
		ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
	   	Dao  dao  = (Dao) applicationContext.getBean("dao");
	   	List<ActInfoVO> lists = null;
	   	Map<String,Object> params = new HashMap<String, Object>();
	   	params.put("organize", "软件学院");
	   	params.put("actNoOrName", null);
	   	params.put("start", 0);
	   	params.put("nums", 5);
	   	lists = dao.select("jxau.sms.chenjiang.activityManage.ActInfo.dao.query", params);
	   	
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
	   	params.put("activityLevel", "院级");
	   	params.put("sponsor", "软件学院");
	   	
	   	for (String key : params.keySet()) {
	   	   order.add(key);
	   	  }
	   	
	   	
   	    params.put("order", order);
	   	params.put("start", 0);
	   	params.put("nums", 5);
	   	lists = dao.select("jxau.sms.chenjiang.activityManage.ActInfo.dao.advancedQuery", params);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
}
