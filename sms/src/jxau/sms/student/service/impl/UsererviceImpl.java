package jxau.sms.student.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

 
import jxau.sms.globaldao.Dao;
import jxau.sms.student.service.UserService;

 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
@Transactional(propagation=Propagation.REQUIRED)
@Service("userSerivce")
public class UsererviceImpl  implements UserService  {

	 private Dao dao;
    @Resource(name="dao")
    public void setDao(Dao dao) {
		this.dao = dao;
	}

 
	@Override
	public void findUser() {
           System.out.println("成功进入service------------------");	 
	}


	@Override
	public <T> T searchByAccurate(Map<String, Object> param, int status) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> T searchByAccurate(Map<String, Object> param, int currentPage,
			int pageSize, int status) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> int add(Class T, Object object) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <T> int update(Class T, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <T> int delete(Class T, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}
 
	

}
