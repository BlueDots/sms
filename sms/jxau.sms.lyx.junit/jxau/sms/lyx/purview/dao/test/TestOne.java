package jxau.sms.lyx.purview.dao.test;

import java.util.ArrayList;
import java.util.List;

import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.po.PurviewInfo;
import jxau.sms.lyx.purview.service.impl.SystemPurviewServiceImpl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOne {

	/**
	 * 
	 * lyx
	 * TODO
	 * 上午10:15:43
	 * 		测试读取所有系统权限	
	 */
	@Test
	public void test() {
		
		System.out.println(new SystemPurviewServiceImpl().searchListByAccurate(null, 0));
	}

}
