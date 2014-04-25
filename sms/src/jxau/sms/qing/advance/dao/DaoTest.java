package jxau.sms.qing.advance.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.qing.po.Advance;
import jxau.sms.qing.po.Participate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		ApplicationContext context;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("studentNo", "20111112");
		

		List<Advance> list ;
		list = dao.select("jxau.sms.qing.advance.dao.selectAdvance",map);						
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getActivityName());
		}
	}

}
