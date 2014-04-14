package jxau.sms.anping.dao.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.globaldao.Dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YIbaoDaoInsertTest {
	ApplicationContext app = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	String namespace = "jxau.sms.anping.yibao.dao.";
	Dao dao = (Dao) app.getBean("dao");
	
	
	

	@Test
	public void testUpdateCompanyByBatch(){
		HosInsuranceInfo info  = new HosInsuranceInfo();
		info.setComplete(1);
		info.setInsurerTime(new Date());
		info.setNotinsurerReason("没有人来领啊");
		info.setCompanyRemark("这个钱用来充公");
		info.setHosNo(10);
		HosInsuranceInfo info2  = new HosInsuranceInfo();
		info2.setComplete(1);
		info2.setInsurerTime(new Date());
		info2.setNotinsurerReason("没有人来领啊");
		info2.setCompanyRemark("这个钱用来充公");
		info2.setHosNo(11);
		HosInsuranceInfo info3  = new HosInsuranceInfo();
		info3.setComplete(1);
		info3.setInsurerTime(new Date());
		info3.setNotinsurerReason("没有人来领啊");
		info3.setCompanyRemark("这个钱用来充公");
		info3.setHosNo(12);
		
		List<HosInsuranceInfo> aas= new ArrayList<HosInsuranceInfo>(); 
		aas.add(info3);
		aas.add(info2);
		aas.add(info);
	   
		 dao.batchUpdate(namespace+"modifyCompany", aas);
		
	 }
	
	
	@Test
	public void testUpdateCompany(){
		HosInsuranceInfo info  = new HosInsuranceInfo();
		info.setComplete(1);
	 
		info.setNotinsurerReason("没有人来领啊");
		info.setCompanyRemark("这个钱用来充公");
		info.setHosNo(10);
		dao.update(namespace+"modifyCompany", info);
		
	}
	
	
	@Test
	public void testUpdatejuming(){
		HosInsuranceInfo info  = new HosInsuranceInfo();
		 info.setReimbursementAmount(19.01);
		 info.setBill(1);
		 info.setJumingRemark("aaaa");
		 info.setHosNo(7);
		dao.update(namespace+"modifyReimburseStudent", info);
		
	}
	
	
	@Test
	public void testUpdateYiBao(){
		HosInsuranceInfo info  = new HosInsuranceInfo();
		info.setSubmitTime(new Date());
		info.setRefuseReason("感冒你也敢发");
		info.setResultDeal("不处理");
		info.setAccept(0);
		info.setHosNo(7);
		dao.update(namespace+"modifyAcceptOrNotResult", info);
			
	}
	
	@Test
	public void testUpdate(){
		HosInsuranceInfo info  = new HosInsuranceInfo();
		info.setHosNo(5);
		info.setHosState("校级审核通过");
		dao.update(namespace+"modifyYiBaoStatus", info);
	}
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
