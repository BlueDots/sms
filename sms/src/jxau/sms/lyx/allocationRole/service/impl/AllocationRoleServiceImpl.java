package jxau.sms.lyx.allocationRole.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xerces.internal.impl.dv.DatatypeException;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.exception.DataExistException;
import jxau.sms.lyx.exception.InsertErrorException;
import jxau.sms.lyx.exception.NotFoundDataException;
import jxau.sms.lyx.vo.VTeacherRole;
/**
 * 
 * @author lyx
 * 2014-4-19
 * TODO:
 * 		该类用于教师分配角色模块
 */
@Service("AllocationRoleServiceImpl")
public class AllocationRoleServiceImpl implements GlobalServiceInterface {

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
	public <T> T searchByAccurate(Map<String, Object> param, int status) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询所有教师角色信息
	 */
	@SuppressWarnings("hiding")
	@Override
	public <VTeacherRole> List<VTeacherRole> searchByAccurate(Map<String, Object> param,
			PageVo pageVo, int status) {
		// TODO Auto-generated method stub
		param.put("start",pageVo.getFirstIndex());
		param.put("nums",pageVo.getSize());
		List<VTeacherRole> vTeacherRoleList = dao.select("findAllTeacherRoleInfo", param);
		
		for(int i=0;i<vTeacherRoleList.size();i++){
			 jxau.sms.lyx.vo.VTeacherRole vTeacherRole = (jxau.sms.lyx.vo.VTeacherRole) vTeacherRoleList.get(i);		 
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("teacherNo", vTeacherRole.getTeacherNo());
			 List<String> roleNameList= dao.select("findRoleNameByTeacherNo",map);
			 vTeacherRole.setRoleList(roleNameList);		 
		}
		
		for(int i=0;i<vTeacherRoleList.size();i++){
			 jxau.sms.lyx.vo.VTeacherRole vTeacherRole = (jxau.sms.lyx.vo.VTeacherRole) vTeacherRoleList.get(i);		 
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("teacherNo", vTeacherRole.getTeacherNo());
			 List<String> departmentList= dao.select("findDepartmentByTeacherNo",map);
			 vTeacherRole.setDepartmentList(departmentList);		 
		}
		
		long totalCount = dao.selectOne("findAllTeacherRoleInfoNums", null);
		pageVo.setCount(totalCount);
		
		return vTeacherRoleList;
	}

	@Override
	public <TeacherRole> int add(Class TeacherRole, Object object) {
		// TODO Auto-generated method stub
		
		if(TeacherRole instanceof Object){
			
			jxau.sms.lyx.po.TeacherRole data = (jxau.sms.lyx.po.TeacherRole) object;
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("teacherNo", data.getTeacherNo());	
			List<Integer> list = dao.select("findRoleNoByTeacherNo", map);
			
			if(list.size()>0) {
				
				for(int i=0;i<list.size();i++){
					int roleNo = list.get(i);
					
					if(roleNo==data.getRoleNo()){
						throw new DataExistException("该用户已拥有该角色权限");
					}
				}
				dao.add("addTecRole", data);
				
			}else {
				
				dao.add("addTecRole", data);
			}
			
			
			
		}
		
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
