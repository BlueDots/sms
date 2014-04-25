package jxau.sms.qing.login.service;

import static org.junit.Assert.*;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.qing.po.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginServiceTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService loginService = (LoginService) context.getBean("loginService");
		Student studnet = (Student)loginService.selectStudent("20111112", "mm");
		System.out.println(studnet.getStudentNo()+"刘亦菲");
	    loginService.selectTeacher("0000", "mm"); 
	}

}
