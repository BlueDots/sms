package jxau.sms.thomas.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.thomas.po.StuAdvInfo;

import org.apache.struts2.views.xslt.ArrayAdapter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvanceInfoTest {

	
	public void testSelectDao(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao) applicationContext.getBean("dao");
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("studentNo", "20111826");
		System.out.print(dao.select("jxau.sms.advanceinfo.dao.findAdvInfo",param));
	}
	
	public void testAddDao(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao) applicationContext.getBean("dao");
//		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("studentNo", "20111826");
//		System.out.print(dao.select("jxau.sms.advanceinfo.dao.findAdvInfo",param));
		List<StuAdvInfo> stuAdvInfos = new ArrayList<StuAdvInfo>();
		/*for (int i = 0; i < 2; i++) {
			StuAdvInfo stuAdvInfo = new StuAdvInfo();
			stuAdvInfo.setStudentNo("20111826");
			stuAdvInfo.setAdvanceActivity("十佳团支书");
			stuAdvInfo.setAdvLevel("国家级");
			stuAdvInfo.setAdvTime("201302");
			//stuAdvInfo.setAwardNo(awardNo)
			stuAdvInfo.setExamState("院级已通过");
			stuAdvInfo.setRemarks("无");
			
			stuAdvInfos.add(stuAdvInfo);
		}*/
		StuAdvInfo stuAdvInfo = new StuAdvInfo();
		stuAdvInfo.setStudentNo("20111826");
		stuAdvInfo.setAdvanceActivity("十佳团支书");
		stuAdvInfo.setAdvLevel("国家级");
		stuAdvInfo.setAdvTime("201302");
		//stuAdvInfo.setAwardNo(awardNo)
		stuAdvInfo.setExamState("院级已通过");
		stuAdvInfo.setRemarks("无");
		dao.add("jxau.sms.advanceinfo.dao.bathcAddAdvInfo", stuAdvInfo);
		
	}
	
	public void testUpdateDao(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao) applicationContext.getBean("dao");
		List<StuAdvInfo> stuAdvInfos = new ArrayList<StuAdvInfo>();
		for (int i = 0; i < 2; i++) {
			StuAdvInfo stuAdvInfo = new StuAdvInfo();
			stuAdvInfo.setAwardNo(28+i);
			stuAdvInfo.setStudentNo("20111826");
			stuAdvInfo.setAdvanceActivity("优秀团干");
			stuAdvInfo.setAdvLevel("国家级");
			stuAdvInfo.setAdvTime("201302");
			stuAdvInfo.setExamState("院级已通过");
			stuAdvInfo.setRemarks("无");
			
			stuAdvInfos.add(stuAdvInfo);
		}
		
		//stuAdvInfos.add(stuAdvInfo);
		dao.batchUpdate("jxau.sms.advanceinfo.dao.updateAdvInfo", stuAdvInfos);
		
	}

	public void testDeleteDao(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao) applicationContext.getBean("dao");
		//Map<String, List<Integer>> param = new HashMap<>();
		List<Integer> awardNos = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			awardNos.add(30+i);
		}
		//param.put("awardNo", awardNos);
		//stuAdvInfos.add(stuAdvInfo);
		dao.batchDelete("jxau.sms.advanceinfo.dao.deleteAdvInfo", awardNos);
	}
	@Test
	public void testSelectService(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		GlobalServiceInterface globalServiceInterface = (GlobalServiceInterface) applicationContext.getBean("advanceServiceImple");
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("studentNo", "20111827");
		//params.put("studentName", "赖辉强");
		//params.put("examState", "校级已通过");
		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(1);
		globalServiceInterface.searchByAccurate(params, pageVo,0);
		System.out.print(pageVo.getPageNum());
	}
	
	public void testAddService(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		GlobalServiceInterface globalServiceInterface = (GlobalServiceInterface) applicationContext.getBean("advanceServiceImple");
		
		List<StuAdvInfo> stuAdvInfos = new ArrayList<StuAdvInfo>();
		for (int i = 0; i < 2; i++) {
			StuAdvInfo stuAdvInfo = new StuAdvInfo();
			stuAdvInfo.setStudentNo("20111826");
			stuAdvInfo.setAdvanceActivity("十佳团支书");
			stuAdvInfo.setAdvLevel("国家级");
			stuAdvInfo.setAdvTime("201302");
			//stuAdvInfo.setAwardNo(awardNo)
			stuAdvInfo.setExamState("院级已通过");
			//stuAdvInfo.setRemarks("无");
			
			stuAdvInfos.add(stuAdvInfo);
		}
		
		globalServiceInterface.add(StuAdvInfo.class, stuAdvInfos);
	}
	@Test
	public void testDeleteService() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		GlobalServiceInterface globalServiceInterface = (GlobalServiceInterface) applicationContext.getBean("advanceServiceImple");
		
		Map<String, Object> param = new HashMap<>();
				List<Integer> awardNos = new ArrayList<Integer>();
				for (int i = 0; i < 2; i++) {
					awardNos.add(30+i);
				}
		param.put("awardNo", awardNos);
		if (globalServiceInterface.delete(StuAdvInfo.class, param)==0) {
			System.out.print("不存在!");
		};
	}
}
