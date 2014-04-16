package jxau.sms.chenjiang.stuActParticipate.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.Instanceof;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.chenjiang.po.ActInfo;
import jxau.sms.chenjiang.po.StuActParticipate;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.vo.StuActParticipateVO;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private GlobalServiceInterface globalServiceInterface =  (GlobalServiceInterface) applicationContext.getBean("stuActParticipateServiceImpl");
	
	private AbstractionService abstractionService = (AbstractionService)applicationContext.getBean("stuActParticipateServiceImpl");
	
	@Test
	public void testQuery() {
		List<StuActParticipateVO> lists = null;
	   	Map<String,Object> params = new HashMap<String, Object>();
	   	params.put("college", "软件学院");
	   	params.put("major", null);
	   	params.put("className", null);
	   	params.put("stuNoOrName", null);
	   	//params.put("sex", 1);
	   	PageVo pageVo = new PageVo();
	   	pageVo.setCurrentPage(1);
	   	lists = globalServiceInterface.searchByAccurate(params, pageVo, 1);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
	@Test 
	public void testAdd() {
/*	   	 StuActParticipate stuActParticipate = new StuActParticipate();
	   	 ActInfo actInfo = new ActInfo();
	   	 actInfo.setActNo(1);
	   	 StuBasicInfo stuBasicInfo = new StuBasicInfo();
		 stuBasicInfo.setStudentNo("20111367");
	   	 stuActParticipate.setActInfo(actInfo);
	   	 stuActParticipate.setStuBasicInfo(stuBasicInfo);
	   	 
	   	 stuActParticipate.setSessionYear(1);
	   	 stuActParticipate.setAwardTime(Date.valueOf("1111-11-11"));
	   	 stuActParticipate.setActivityRating("二等奖");*/

	   	 List<StuActParticipate> lists = new ArrayList<StuActParticipate>();

		  	 StuActParticipate s1 = new StuActParticipate();
		   	 ActInfo a1 = new ActInfo();
		   	a1.setActNo(1);
		   	 StuBasicInfo sb1 = new StuBasicInfo();
		   	sb1.setStudentNo("20111429");
			 s1.setActInfo(a1);
			 s1.setStuBasicInfo(sb1);
		   	 
			 s1.setSessionYear(2);
			 s1.setAwardTime(Date.valueOf("2211-1-13"));
			 s1.setActivityRating("二等奖");
			
		  	 StuActParticipate s2 = new StuActParticipate();
		   	 ActInfo a2 = new ActInfo();
		   	a2.setActNo(2);
		   	 StuBasicInfo sb2 = new StuBasicInfo();
		   	sb2.setStudentNo("20111429");
			 s2.setActInfo(a2);
			 s2.setStuBasicInfo(sb2);
		   	 
			 s2.setSessionYear(1);
			 s2.setAwardTime(Date.valueOf("1111-11-11"));
			 s2.setActivityRating("优胜奖");
			 
			 lists.add(s1);
			 lists.add(s2);		
	
		
		int a = globalServiceInterface.add(StuActParticipate.class, lists);
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
	public void testGetWaitForActivityName() {
		Map<String, Object> params = new HashMap<String,Object>();
		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(1);
		params.put("exameState", "院级审核中");
		params.put("level", 0);
		params.put("organize", "软件学院");
		
		List<String> lists = ((StuActParticipateServiceImpl)globalServiceInterface).getWaitForActivityName(params, pageVo);
		System.out.println(lists.size());
		System.out.println(lists);
		System.out.println(pageVo.getPageNum());
	}
	
	@Test
	public void testGetWaitingForLists() {
		List<StuActParticipateVO> lists = null;
		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(1);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("exameState", "院级审核中");
		params.put("level", 0);
		params.put("activityName", "打嘎啦大赛");
		params.put("organize", "软件学院");
		lists = abstractionService.getWaitingForLists(params, pageVo);
		System.out.println(lists.size());
		for(StuActParticipateVO s : lists) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testGetWaitingVerifyNums() {
		System.out.println(abstractionService.getWaitingVerifyNums("01", "3"));
	}
	
	@Test
	public void testVerify() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(12);
		
		abstractionService.verify(ids, "03", "4", "2", null);
		
	}
	
	@Test
	public void testDelete() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(12);
		ids.add(13);
		abstractionService.moduleStateUpdate("03", ids, 1, null, null);
		
	}
	
	
}
