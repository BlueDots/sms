package jxau.sms.lyx.tecBasicInfo.dao;

import static org.junit.Assert.*;

import java.util.List;

import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.TecBasicInfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		List<TecBasicInfo> teacher= dao.select("findAllTecBasicInfo", null);
		
	}

}
