package jxau.sms.lyx.sysPurviewConfig.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.exception.NotFoundDataException;
import jxau.sms.lyx.po.PurviewInfo;
import jxau.sms.lyx.po.RoleInfo;

/**
 * 
 * @author lyx
 * 2014-4-21
 * TODO:
 * 系统权限管理
 * 功能1：
 * 		左侧菜单的读取
 * 功能2：
 * 		右侧页面根据权限显示
 * 功能3：
 * 		拦截器，拦截每一条请求
 */

@Service("SysPurviewConfigserviceimpl")
public class SysPurviewConfigserviceimpl implements GlobalServiceInterface {

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
	public <SessionPurview> SessionPurview searchByAccurate(Map<String, Object> param, int status) {
		// TODO Auto-generated method stub
		List<RoleInfo> list = dao.select("findRoleByTeacherNo",param);
		List<PurviewInfo> purviewInfo = new ArrayList<PurviewInfo>();
		jxau.sms.lyx.vo.SessionPurview sessionPurview = new jxau.sms.lyx.vo.SessionPurview();
		
		if(list.size()==0) {
			throw new NotFoundDataException("未找到该用户相应的角色信息");
		}else {
			
			int roleNo = list.get(0).getRoleNo();
			String roleName = list.get(0).getRoleName();
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("roleNo", list.get(0).getRoleNo());
			purviewInfo = dao.select("findSessionPurviewByRoleNo",map);		
			
			sessionPurview.setRoleNo(roleNo);
			sessionPurview.setRoleName(roleName);
			sessionPurview.setPurviewInfo(purviewInfo);
			
		}		
		return (SessionPurview) sessionPurview;
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
