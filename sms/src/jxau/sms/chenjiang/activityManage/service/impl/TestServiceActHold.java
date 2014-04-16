package jxau.sms.chenjiang.activityManage.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.Instanceof;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.chenjiang.po.ActHold;
import jxau.sms.chenjiang.po.ActInfo;
import jxau.sms.chenjiang.po.StuActParticipate;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.chenjiang.vo.ActHoldVO;
import jxau.sms.chenjiang.vo.ActInfoVO;
import jxau.sms.chenjiang.vo.StuActParticipateVO;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.lyx.po.TecBasicInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestServiceActHold {
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private GlobalServiceInterface globalServiceInterface =  (GlobalServiceInterface) applicationContext.getBean("activityManageServiceImpl");
	
	private AbstractionService abstractionService = (AbstractionService)applicationContext.getBean("activityManageServiceImpl");
	
	@Test
	public void testQuery() {
		List<ActHoldVO> lists = null;
	   	Map<String,Object> params = new HashMap<String, Object>();
	   	params.put("actNo", 1);
	   	params.put("vo", 1);
	   	PageVo pageVo = new PageVo();
	   	pageVo.setCurrentPage(1);
	   	lists = globalServiceInterface.searchByAccurate(params, pageVo, 1);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
	@Test 
	public void testAdd() {
	   	 ActHold actHold = new ActHold();
	   	 ActInfo actInfo = new ActInfo();
	   	 actInfo.setActNo(3);
	   	 actHold.setActInfo(actInfo);
	   	 actHold.setSessionYear(1);
	   	 actHold.setStartTime(Date.valueOf("2004-11-11"));
	   	 actHold.setEndTime(Date.valueOf("2004-11-11"));
	   	 actHold.setHoldPlace("圆形报告厅");
		
	   	 List<ActHold> lists = new ArrayList<ActHold>();
	   	 ActHold a1 = new ActHold();
	   	 ActInfo actInfo1 = new ActInfo();
	   	 actInfo1.setActNo(3);
	   	a1.setActInfo(actInfo1);
	   	a1.setSessionYear(3);
	   	a1.setStartTime(Date.valueOf("2004-11-11"));
	   	a1.setEndTime(Date.valueOf("2004-11-11"));
	   	a1.setHoldPlace("圆形报告厅");
	   	
	   	 ActHold a2 = new ActHold();
	   	 ActInfo actInfo2 = new ActInfo();
	   	 actInfo2.setActNo(3);
	   	a2.setActInfo(actInfo2);
	   	a2.setSessionYear(4);
	   	a2.setStartTime(Date.valueOf("2004-11-11"));
	   	a2.setEndTime(Date.valueOf("2004-11-11"));
	   	a2.setHoldPlace("圆形报告厅");
	   	
	   	lists.add(a1);
	   	lists.add(a2);		
		
		int a = globalServiceInterface.add(ActHold.class, lists);
		System.out.println(a);
	}
	
	@Test 
	public void testUpdate() {
	   	 List<ActHold> lists = new ArrayList<ActHold>();
	   	 ActHold a1 = new ActHold();
	   	 a1.setId(9);
	   	 ActInfo actInfo1 = new ActInfo();
	   	 actInfo1.setActNo(3);
	   	a1.setActInfo(actInfo1);
	   	a1.setSessionYear(3);
	   	a1.setStartTime(Date.valueOf("2014-11-11"));
	   	a1.setEndTime(Date.valueOf("2014-11-11"));
	   	a1.setHoldPlace("圆形报告厅asas");
	   	
	   	 ActHold a2 = new ActHold();
	   	 a2.setId(10);
	   	 ActInfo actInfo2 = new ActInfo();
	   	 actInfo2.setActNo(3);
	   	a2.setActInfo(actInfo2);
	   	a2.setSessionYear(4);
	   	a2.setStartTime(Date.valueOf("2001-11-11"));
	   	a2.setEndTime(Date.valueOf("2011-01-11"));
	   	a2.setHoldPlace("圆形报告厅");
	   	
	   	lists.add(a1);
	   	lists.add(a2);		
		
		int a =( (ActivityManageServiceImpl)globalServiceInterface).update(ActHold.class, lists);
		System.out.println(a);
	}
	
	
	
	@Test
	public void testGetWaitingForLists() {
		List<ActInfoVO> lists = null;
		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(1);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("exameState", "校级审核中");
		lists = abstractionService.getWaitingForLists(params, pageVo);
		System.out.println(lists.size());
		for(ActInfoVO s : lists) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testGetWaitingVerifyNums() {
		System.out.println(abstractionService.getWaitingVerifyNums("04", "4"));
	}
	
	@Test
	public void testVerify() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		
		abstractionService.verify(ids, "04", "4", "1", null);
		
	}
	
	@Test
	public void testDelete() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(8);

		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ids", ids);
		
		int a = globalServiceInterface.delete(ActHold.class, param);
		System.out.println(a);
	}
	
	
}
