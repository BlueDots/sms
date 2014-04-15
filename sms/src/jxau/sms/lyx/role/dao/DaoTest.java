package jxau.sms.lyx.role.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.RoleInfo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dao dao = (Dao)context.getBean("dao");
		List<RoleInfo> list = new ArrayList<RoleInfo>();
		
		list = dao.select("findAllRoleInfo", null);
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getRoleName());
		}
	}

}