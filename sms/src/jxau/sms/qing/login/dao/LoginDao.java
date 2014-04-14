package jxau.sms.qing.login.dao;

import java.util.HashMap;

import org.springframework.stereotype.Component;
@Component(value="logindao")
public interface LoginDao {
	int selectStudent(HashMap<String,Object> hashmap);
	int selectTeacher(HashMap<String,Object> hashmap);
}
