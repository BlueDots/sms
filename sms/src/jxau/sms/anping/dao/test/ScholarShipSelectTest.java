package jxau.sms.anping.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.commom.vo.WaitCheckVo;
import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScholarShipSelectTest {
	ApplicationContext app = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	String namespace = "jxau.sms.anping.scholarship.dao.";
	Dao dao = (Dao) app.getBean("dao");
	
	
	/**
	 * 查询出某一个需要待审核的班级
	 * anping
	 * TODO
	 * 下午6:30:08
	 */
	@Test
	public void testSchloarShipSelect(){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("college", "软件学院");
	    params.put("exameState", "院级审核中");
		
		List<WaitCheckVo> waiting =  dao.select(namespace+"getWaitData", params);
	}
	@Test
	public void testCompare(){
		String a = "20111429";
		String b = "20111499";
		String c = "20111499";
		System.out.println(c.compareTo(b));
	}
	
	
	@Test
	public void testAwardRank(){
		Map<String,Object> params = new HashMap<String,Object>(3);
		
		params.put("college", "软件学院");
		params.put("className", "1102");
		params.put("term", "201402");
		dao.selectOne(namespace+"updateAwardRand", params);
	}
	@Test
	public void testGetClassMaxStudentNo(){
		Map<String,Object> params = new HashMap<String,Object>(3);
		params.put("college", "软件学院");
		params.put("className", "1102");
		params.put("term", "201401");
		dao.select(namespace+"getStudentNoInClass", params);
	}
	
	@Test
	public void testProceduce(){
		Map<String,Object> params = new HashMap<String,Object>(3);
		params.put("college", "软件学院");
		params.put("className","1102");
		params.put("term","201401");
		dao.select(namespace+"updateTotalScoreRand", params);
	}

	@Test
	public void selectSchloarShip() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("college","软件学院");
		params.put("major","软件工程");
		 
		List<ScholarShip> ships =   dao.select(namespace+"selectScholarShipByCondition",params);
		for(ScholarShip ship :ships){
		System.out.println(ship.getTerm());
		System.out.println(ship.getAwardScore());
		System.out.println(ship.getPunishScore());
		System.out.println(ship.getStudent().getStudentNo());
		System.out.println(ship.getStudent().getStudentName());
		}
	}
}
