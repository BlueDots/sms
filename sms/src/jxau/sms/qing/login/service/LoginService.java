package jxau.sms.qing.login.service;

import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import jxau.sms.globaldao.Dao;
@Component
public class LoginService {
	Dao  dao  = (Dao) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("dao");
	public boolean whichUser(String userId,String password){
		if(userId.length()==8){
			return this.selectStudent(userId,password);
		} else if(userId.length()==4){
			return this.selectTeacher(userId, password);
		} else return false;
	}
	
	public boolean selectStudent(String studentNo,String password){
		int count;
		HashMap<String, Object> student = new HashMap<String,Object>();
		student.put("studentNo", studentNo);
		student.put("stuPassword", password);
        count = dao.selectOne("jxau.sms.qing.login.dao.LoginDao.selectStudent",student);
        if(count == 1){
        	return true;
        } else {
        	return false;
        }
	}
	
	public boolean selectTeacher(String teacherNo,String password){
		int count;
		HashMap<String, Object> student = new HashMap<String,Object>();
		student.put("teacherNo", teacherNo);
		student.put("tecPassword", password);
        count = dao.selectOne("com.sms.login.dao.LoginDao.selectTeacher",student);
        if(count == 1){
        	return true;
        } else {
        	return false;
        }
	}
}
