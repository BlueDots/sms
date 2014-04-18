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
import jxau.sms.chenjiang.vo.ActInfoVO;
import jxau.sms.chenjiang.vo.StuActParticipateVO;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.lyx.po.TecBasicInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestServiceActInfo {
	private ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private GlobalServiceInterface globalServiceInterface =  (GlobalServiceInterface) applicationContext.getBean("activityManageServiceImpl");
	
	private AbstractionService abstractionService = (AbstractionService)applicationContext.getBean("activityManageServiceImpl");
	
	@Test
	public void testQuery() {
		List<ActInfoVO> lists = null;
	   	Map<String,Object> params = new HashMap<String, Object>();
	   	params.put("organize", "软件学院");
	   	params.put("actNoOrName", null);
	   	params.put("activityLevel", "校级");
	   	params.put("vo", 0);
	   	PageVo pageVo = new PageVo();
	   	pageVo.setCurrentPage(1);
	   	lists = globalServiceInterface.searchByAccurate(params, pageVo, 1);
	   	
	   	System.out.println(lists.size());
	   	for(int i=0;i<lists.size();i++)
	   		System.out.println(lists.get(i));
	}
	
	@Test 
	public void testAdd() {
/*	   	 ActInfo aInfo1 = new ActInfo();
	   	 aInfo1.setActivityName("社团评比");
	   	 aInfo1.setActivityType("学术科技类");
	   	 aInfo1.setActivityLevel("校级");
	   	 aInfo1.setSponsor("江西农业大学");
	   	 aInfo1.setOrganize("软件学院");
	   	 TecBasicInfo teacher = new TecBasicInfo();
	   	 teacher.setTeacherNo("4611");
	   	 aInfo1.setTecBasicInfo(teacher);
	   	 aInfo1.setStudentName("嘎啦");  */
		
	   	 List<ActInfo> lists = new ArrayList<ActInfo>();
	   	 ActInfo a1 = new ActInfo();
	   	a1.setActivityName("12121212");
	   	a1.setActivityType("实践创新类");
	   	a1.setActivityLevel("院级");
	   	a1.setSponsor("软件学院");
	   	a1.setOrganize("软件学院");
	   	 TecBasicInfo t1 = new TecBasicInfo();
	   	 t1.setTeacherNo("4610");
	   	a1.setTecBasicInfo(t1);
	   	
	   	 ActInfo a2 = new ActInfo();
	   	a2.setActivityName("b231231x");
	   	a2.setActivityType("实践创新类");
	   	a2.setActivityLevel("院级");
	   	a2.setSponsor("软件学院");
	   	a2.setOrganize("软件学院");
	   	 TecBasicInfo t2 = new TecBasicInfo();
	   	 t2.setTeacherNo("4611");
	   	a2.setTecBasicInfo(t2);
	   	
	   	lists.add(a1);
	   	lists.add(a2);		
		
		int a = globalServiceInterface.add(ActInfo.class, lists);
		System.out.println(a);
	}
	
	@Test 
	public void testUpdate() {
	   	 List<ActInfo> lists = new ArrayList<ActInfo>();
	   	 ActInfo a1 = new ActInfo();
	   	 a1.setActNo(4);
	   	a1.setActivityName("啊啊啊");
	   	a1.setActivityType("实践创新类");
	   	a1.setActivityLevel("院级");
	   	a1.setSponsor("jxau");
	   	a1.setOrganize("软件学院");
	   	 TecBasicInfo t1 = new TecBasicInfo();
	   	 t1.setTeacherNo("4610");
	   	a1.setTecBasicInfo(t1);
	   	
	   	 ActInfo a2 = new ActInfo();
		 a2.setActNo(5);
	   	a2.setActivityName("噜噜噜");
	   	a2.setActivityType("实践创新类");
	   	a2.setActivityLevel("校级");
	   	a2.setSponsor("jxau");
	   	a2.setOrganize("软件学院");
	   	 TecBasicInfo t2 = new TecBasicInfo();
	   	 t2.setTeacherNo("4610");
	   	a2.setTecBasicInfo(t2);
	   	
	   	lists.add(a1);
	   	lists.add(a2);
		
		int a =( (ActivityManageServiceImpl)globalServiceInterface).update(ActInfo.class, lists);
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
		ids.add(4);
		ids.add(5);
		ids.add(6);
		abstractionService.moduleStateUpdate("04", ids, 0, null, null);
		
	}
	
	
}
