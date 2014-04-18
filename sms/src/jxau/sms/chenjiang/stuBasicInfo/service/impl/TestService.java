package jxau.sms.chenjiang.stuBasicInfo.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.Instanceof;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private GlobalServiceInterface globalServiceInterface =  (GlobalServiceInterface) applicationContext.getBean("stuBasicInfoServiceImpl");
	
	private AbstractionService abstractionService = (AbstractionService)applicationContext.getBean("stuBasicInfoServiceImpl");
	
	@Test
	public void testQuery() {
	   	List<StuBasicInfo> lists = null;
	   	Map<String,Object> params = new HashMap<String, Object>();
	   	params.put("college", "软件学院");
	   	params.put("major", null);
	   	params.put("className", null);
	   	params.put("stuNoOrName", null);
	   	params.put("sex", 1);
	   	PageVo pageVo = new PageVo();
	   	pageVo.setCurrentPage(1);
	   	lists = globalServiceInterface.searchByAccurate(params, pageVo, 1);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
	@Test 
	public void testAdd() {
/*		 StuBasicInfo stuBasicInfo = new StuBasicInfo();
		 stuBasicInfo.setStudentNo("20111738");
		 stuBasicInfo.setStudentName("李四");
		 stuBasicInfo.setBirthday(Date.valueOf("1991-02-24"));
		 stuBasicInfo.setClassName("软件1108");
		 stuBasicInfo.setMajor("数字媒体");
		 stuBasicInfo.setCollege("软件学院");
		 stuBasicInfo.setSex(1);
		 stuBasicInfo.setNation("汉族");
		 stuBasicInfo.setHometown("天朝");
		 stuBasicInfo.setPolitical("群众");
		 stuBasicInfo.setIdCard("111112211111111111");  */
	   	 List<StuBasicInfo> lists = new ArrayList<StuBasicInfo>();
   	   	 StuBasicInfo s1 = new StuBasicInfo();
   		 s1.setStudentNo("20111556");
   		 s1.setStudentName("aaa1");
   		 s1.setBirthday(Date.valueOf("1993-03-26"));
   		 s1.setClassName("软件1105");
   		 s1.setMajor("计算机网络");
   		 s1.setCollege("软件学院");
   		 s1.setSex(1);
   		 s1.setNation("汉族");
   		 s1.setHometown("天朝");
   		 s1.setPolitical("群众");
   		 s1.setIdCard("111111111111111111");   
   		 
   	   	 StuBasicInfo s2 = new StuBasicInfo();
   		 s2.setStudentNo("20111557");
   		 s2.setStudentName("aaa2");
   		 s2.setBirthday(Date.valueOf("1993-05-24"));
   		 s2.setClassName("软件1105");
   		 s2.setMajor("计算机网络");
   		 s2.setCollege("软件学院");
   		 s2.setSex(1);
   		 s2.setNation("汉族");
   		 s2.setHometown("天朝");
   		 s2.setPolitical("群众");
   		 s2.setIdCard("111111111111111111");  
   		 
   	   	 StuBasicInfo s3 = new StuBasicInfo();
   		 s3.setStudentNo("20111558");
   		 s3.setStudentName("ssss");
   		 s3.setBirthday(Date.valueOf("1992-04-22"));
   		 s3.setClassName("软件1105");
   		 s3.setMajor("计算机网络");
   		 s3.setCollege("软件学院");
   		 s3.setSex(1);
   		 s3.setNation("汉族");
   		 s3.setHometown("天朝");
   		 s3.setPolitical("群众");
   		 s3.setIdCard("111111111111111111");  
   		 
   	   	 StuBasicInfo s4 = new StuBasicInfo();
   		 s4.setStudentNo("20111559");
   		 s4.setStudentName("嘎啦aa");
   		 s4.setBirthday(Date.valueOf("1992-04-01"));
   		 s4.setClassName("软件1105");
   		 s4.setMajor("计算机网络");
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
		
		int a = globalServiceInterface.add(StuBasicInfo.class, lists);
		System.out.println(a);
	}
	
	@Test 
	public void testUpdate() {
/*		 StuBasicInfo stuBasicInfo = new StuBasicInfo();
		 stuBasicInfo.setStudentNo("20111738");
		 stuBasicInfo.setStudentName("李八");
		 stuBasicInfo.setBirthday(Date.valueOf("1992-06-24"));
		 stuBasicInfo.setClassName("软件1108");
		 stuBasicInfo.setMajor("数字媒体");
		 stuBasicInfo.setCollege("软件学院");
		 stuBasicInfo.setSex(1);
		 stuBasicInfo.setNation("汉族");
		 stuBasicInfo.setHometown("天朝");
		 stuBasicInfo.setPolitical("共青团员");
		 stuBasicInfo.setIdCard("111112211111111111");  */
	   	 List<StuBasicInfo> lists = new ArrayList<StuBasicInfo>();
   	   	 StuBasicInfo s1 = new StuBasicInfo();
   		 s1.setStudentNo("20111556");
   		 s1.setStudentName("aaa1");
   		 s1.setBirthday(Date.valueOf("1993-03-26"));
   		 s1.setClassName("软件1105");
   		 s1.setMajor("计算机网络");
   		 s1.setCollege("软件学院");
   		 s1.setSex(1);
   		 s1.setNation("汉族");
   		 s1.setHometown("天朝");
   		 s1.setPolitical("群众");
   		 s1.setIdCard("333333333333333333");   
   		 
   	   	 StuBasicInfo s2 = new StuBasicInfo();
   		 s2.setStudentNo("20111557");
   		 s2.setStudentName("aaa2");
   		 s2.setBirthday(Date.valueOf("1993-05-24"));
   		 s2.setClassName("软件1105");
   		 s2.setMajor("计算机网络");
   		 s2.setCollege("软件学院");
   		 s2.setSex(1);
   		 s2.setNation("汉族");
   		 s2.setHometown("天朝");
   		 s2.setPolitical("群众");
   		 s2.setIdCard("333333333333333333");  
   		 
   	   	 StuBasicInfo s3 = new StuBasicInfo();
   		 s3.setStudentNo("20111558");
   		 s3.setStudentName("ssss");
   		 s3.setBirthday(Date.valueOf("1992-04-22"));
   		 s3.setClassName("软件1105");
   		 s3.setMajor("计算机网络");
   		 s3.setCollege("软件学院");
   		 s3.setSex(1);
   		 s3.setNation("汉族");
   		 s3.setHometown("天朝");
   		 s3.setPolitical("群众");
   		 s3.setIdCard("333333333333333333");  
   		 
   	   	 StuBasicInfo s4 = new StuBasicInfo();
   		 s4.setStudentNo("20111559");
   		 s4.setStudentName("嘎啦aa");
   		 s4.setBirthday(Date.valueOf("1992-04-01"));
   		 s4.setClassName("软件1105");
   		 s4.setMajor("计算机网络");
   		 s4.setCollege("软件学院");
   		 s4.setSex(1);
   		 s4.setNation("汉族");
   		 s4.setHometown("天朝");
   		 s4.setPolitical("群众");
   		 s4.setIdCard("333333333333333333"); 
   		 
   		 lists.add(s1);
   		lists.add(s2);
   		lists.add(s3);
   		lists.add(s4);
		
		int a =( (StuBasicInfoServiceImpl)globalServiceInterface).update(StuBasicInfo.class, lists);
		System.out.println(a);
	}
	
	
	@Test
	public void testGetWaitForClassName() {
		Map<String, Object> params = new HashMap<String,Object>();
		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(1);
		params.put("exameState", "院级审核中");
		
		List<String> lists = ((StuBasicInfoServiceImpl)globalServiceInterface).getWaitForClassName(params,pageVo);
		System.out.println(lists);
		System.out.println(pageVo.getPageNum());
	}
	
	@Test
	public void testGetWaitingForLists() {
		List<StuBasicInfoVO> lists = null;
		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(1);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("exameState", "院级审核中");
		params.put("className", "软件1107");
		lists = abstractionService.getWaitingForLists(params, pageVo);
		System.out.println(lists.size());
		for(StuBasicInfoVO s : lists) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testGetWaitingVerifyNums() {
		System.out.println(abstractionService.getWaitingVerifyNums("01", "3"));
	}
	
	@Test
	public void testVerify() {
		List<String> ids = new ArrayList<String>();
		ids.add("20111367");
		ids.add("20111429");
		ids.add("20111635");
		
		abstractionService.verify(ids, "01", "3", "1", null);
		
	}
	
	@Test
	public void testDelete() {
		List<String> ids = new ArrayList<String>();
		ids.add("20111367");
		ids.add("20111429");
		ids.add("20111635");
		abstractionService.moduleStateUpdate("01", ids, 0, null, null);
		
	}
	
	
}
