package jxau.sms.anping.yibao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.globaldao.Dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
	
	ApplicationContext  app = new ClassPathXmlApplicationContext("applicationContext.xml");
	String namespace = "jxau.sms.anping.yibao.dao.";
	@Test
	public void selectYibaoTest(){
	      Dao  dao =   (Dao) app.getBean("dao");
	      Map<String,Object> params = new HashMap<String,Object>(1);
	      params.put("studentNo","20111429");
	      List<HosInsuranceInfo> hoss =  dao.select(namespace+"findYiBaoById", params);
		  System.out.println(hoss.size());
	      for(HosInsuranceInfo hos:hoss){
	    	  System.out.println(hos.getHosNo());
	    	  System.out.println(hos.getHosType());
			  System.out.println(hos.getStudent().getStudentNo());
			 System.out.println(hos.getApplyTime()); 
			 System.out.println(hos.getAccept());
			 System.out.println(hos.getStudent().getStudentName());
			 System.out.println(hos.getStudent().getSex());
		  }
	}
	
	public static void main(String[] args) {
		new DaoTest().selectYibaoTest();
	}
}
