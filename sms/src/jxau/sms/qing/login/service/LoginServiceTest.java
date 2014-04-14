package jxau.sms.qing.login.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginServiceTest {

	@Test
	public void test() {
		new LoginService().selectStudent("20111112", "mm");
		//new LoginService().selectTeacher("0000", "ll");
	}

}
