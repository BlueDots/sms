package jxau.sms.anping.service.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.yibao.service.impl.YiBaoServiceImpl;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.qing.po.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YiBaoTest {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	GlobalServiceInterface yiBaoService = (GlobalServiceInterface) context.getBean("yiBaoService");
	
	@Test
	public void testDateTime(){
		
		Date  date  = new Date(2014,2,13);
		Date date2 = new Date(2014,2,15);
		
		System.out.println();
	}
	
	@Test
	public void testYiBaoAddMethod(){
		
		HosInsuranceInfo hos = new HosInsuranceInfo();
		StuBasicInfo student  = new StuBasicInfo();
		student.setStudentNo("20111429");
		hos.setStudent(student);
		hos.setBankcardID("2123123");
		hos.setHosType("居民医保");
		hos.setHospitalAddress("江西");
		hos.setLeaveDate(new Date(2014,1,1));
		hos.setHospitalDate(new Date(2013,9,10));
		hos.setConditon("被猪咬");
		hos.setCost(100);
		
		yiBaoService.add(HosInsuranceInfo.class, hos);
	}
	
	@Test
	public void testYiBao(){
		 YiBaoServiceImpl  yibao =  (YiBaoServiceImpl) context.getBean("yiBaoService");
		 Map<String,Object>  data  = new HashMap<String,Object>();
		 data.put("hosNo",111);
		 data.put("2sdasdasd","123213");
		// System.out.println(yibao.checkParamterTypeIsError(data));
	}
	
	
	@Test
	public void testYiBaoSelect(){
		
		PageVo  page = new PageVo();
		page.setCurrentPage(0);
		Map<String,Object> param  = new HashMap<String,Object>(10);
		param.put("college","12312");
		yiBaoService.searchByAccurate(param, page, 0);
		System.out.println(page.getCurrentPage());
		System.out.println(page.getFirstIndex());
		System.out.println(page.getPageNum());
		System.out.println(page.getSize());
	}
}
