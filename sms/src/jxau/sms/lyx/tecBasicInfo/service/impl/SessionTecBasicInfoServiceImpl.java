package jxau.sms.lyx.tecBasicInfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;

@Service("SessionTecBasicInfoServiceImpl")
public class SessionTecBasicInfoServiceImpl implements GlobalServiceInterface {

	private Dao dao;
	
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public <T> List<T> searchListByAccurate(Map<String, Object> param,
			int status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TecBasicInfo> TecBasicInfo searchByAccurate(Map<String, Object> param, int status) {
		// TODO Auto-generated method stub
		
		jxau.sms.lyx.po.TecBasicInfo teacher = new jxau.sms.lyx.po.TecBasicInfo();
		teacher = dao.selectOne("findATecBasicInfo", param);
		
		return (TecBasicInfo) teacher;
	}

	@Override
	public <T> List<T> searchByAccurate(Map<String, Object> param,
			PageVo pageVo, int status) {
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
