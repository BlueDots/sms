package jxau.sms.anping.yibao.test;

import java.util.Date;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoInsertTest {
	ApplicationContext app = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	String namespace = "jxau.sms.anping.yibao.dao.";
	Dao dao = (Dao) app.getBean("dao");
	@Test
	public void testInsert(){
		StuBasicInfo  student  = new StuBasicInfo();
		student.setStudentNo("20111429");
		HosInsuranceInfo  hos = new HosInsuranceInfo();
		hos.setBankcardID("23123123123");
		hos.setHospitalAddress("江西农大校医院");
		hos.setHosType("居民医保");
		hos.setInsurerTime(new Date());
		hos.setLeaveDate(new Date());
		hos.setHosDate(1);
		hos.setLocalCity(1);
		hos.setConditon("被猪拱");
		hos.setCost(20.8);
		hos.setStudent(student);
		dao.add("applyYiBao", hos);
		
	}
}
