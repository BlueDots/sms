package jxau.sms.qing.login.service;

import static org.junit.Assert.*;
import jxau.sms.globalService.GlobalServiceInterface;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginServiceTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService loginService = (LoginService) context.getBean("loginService");
		loginService.selectStudent("20111112", "mm");
		loginService.selectTeacher("0000", "mm"); 
	}

}
