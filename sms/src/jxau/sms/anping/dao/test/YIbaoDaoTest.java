package jxau.sms.anping.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YIbaoDaoTest {

	ApplicationContext app = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	String namespace = "jxau.sms.anping.yibao.dao.";
	Dao dao = (Dao) app.getBean("dao");
	
	@Test
	public void selectYibaoTest() {
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("studentNo", "20111429");
		//params.put("hosState", "11");
		params.put("firstIndex", 0);
		params.put("size",1);
		List<HosInsuranceInfo> hoss = dao.select(namespace + "findYiBaoByStudentNo",
				params);
		System.out.println(hoss.size());
		for (HosInsuranceInfo hos : hoss) {
			System.out.println(hos.getHosNo());
			System.out.println(hos.getHosType());
			System.out.println(hos.getStudent().getStudentNo());
			System.out.println(hos.getApplyTime());
			System.out.println(hos.getAccept());
			System.out.println(hos.getStudent().getStudentName());
			System.out.println(hos.getStudent().getSex());
		}
		
		long  nums  = dao.selectOne(namespace+"findYiBaoByStudentNum", params);
		System.out.println(nums);
	}
	
	@Test
	public void selectYiBaoById(){
		Map<String,Object> params = new HashMap<String,Object>(3);
		params.put("hosNo",1);
		HosInsuranceInfo hos = dao.selectOne(namespace + "findYiBaoById",
				params);
		System.out.println(hos.getHosNo());
		System.out.println(hos.getHosType());
		System.out.println(hos.getStudent().getStudentNo());
		System.out.println(hos.getApplyTime());
		System.out.println(hos.getAccept());
		System.out.println(hos.getStudent().getStudentName());
		System.out.println(hos.getStudent().getSex());
	}
	/**
	 * 条件查询
	 * anping
	 * TODO
	 * 上午10:58:23
	 */
	@Test
	public void testSelectByCondition(){
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("college", "软件学院");
		//params.put("hosState", "11");
		params.put("className", "1102");
		params.put("studentName", "熊安平"); 
		List<HosInsuranceInfo> hoss = dao.select(namespace + "findYiBaoByCondition",
				params);
		System.out.println(hoss.size());
		for (HosInsuranceInfo hos : hoss) {
			System.out.println(hos.getHosNo());
			System.out.println(hos.getHosType());
			System.out.println(hos.getStudent().getStudentNo());
			System.out.println(hos.getApplyTime());
			System.out.println(hos.getAccept());
			System.out.println(hos.getStudent().getStudentName());
			System.out.println(hos.getStudent().getSex());
		}
	
	   System.out.println(dao.selectOne(namespace+"findYiBaoByConditionNum", params));
	}
	

	 
}
