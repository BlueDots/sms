package jxau.sms.stuBasicInfo.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jxau.sms.stuBasicInfo.po.StuBasicInfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.dao.Dao;

public class Test1 {
	
	@Test
	public void testAdd() {
   	 ApplicationContext  applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
   	 Dao  dao  = (Dao) applicationContext.getBean("dao");
   	 StuBasicInfo stuBasicInfo = new StuBasicInfo();
	 stuBasicInfo.setStudentNo("20111635");
	 stuBasicInfo.setStudentName("陈江");
	 stuBasicInfo.setBirthday(Date.valueOf("1993-03-26"));
	 stuBasicInfo.setClassName("软件1107");
	 stuBasicInfo.setMajor("数字媒体");
	 stuBasicInfo.setCollege("软件学院");
	 stuBasicInfo.setSex(1);
	 stuBasicInfo.setNation("汉族");
	 stuBasicInfo.setHometown("天朝");
	 stuBasicInfo.setPolitical("群众");
	 stuBasicInfo.setIdCard("111111111111111111");  
	 dao.add("jxau.sms.stuBasicInfo.dao.add", stuBasicInfo);
	 System.out.println(stuBasicInfo.getStudentNo());
	}
}
