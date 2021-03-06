package jxau.sms.lyx.role.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.exception.DataExistException;
import jxau.sms.lyx.exception.InsertErrorException;
import jxau.sms.lyx.exception.NotFoundDataException;
import jxau.sms.lyx.exception.NotUserRoleException;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.purview.service.impl.PurviewListPackage;
import jxau.sms.lyx.purview.service.impl.RoleHandlePurview;

/**
 * 
 * @author lyx
 * 2014-4-15
 * TODO:
 * 		处理角色的service
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl implements GlobalServiceInterface{

	private Dao dao;
	private PurviewListPackage purviewListPackage;
	
	@Resource(name="PurviewListPackage")
	public void setPurviewListPackage(PurviewListPackage purviewListPackage) {
		this.purviewListPackage = purviewListPackage;
	}

	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	
	public long checkUserRole(Map<String, Object> param){
		
		int count = dao.selectOne("checkLoginRole", param);
		
		if(count == 0){
			throw new NotUserRoleException("找不到用户对应的角色");
		}
		
		return count;
	}

	@Override
	public <T> T searchByAccurate(Map<String, Object> param, int status) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public <RoleInfo> List<RoleInfo> searchByAccurate(Map<String, Object> param,
			PageVo pageVo, int status) {
		// TODO Auto-generated method stub
		param = new HashMap<String, Object>();
		param.put("start",pageVo.getFirstIndex());
		param.put("nums",pageVo.getSize());
		
		List<RoleInfo> list = dao.select("findAllRoleInfo", param);
		long totalCount = dao.selectOne("findAllRoleInfoNums", param);
		pageVo.setCount(totalCount);
		
		return list;
	}

	//添加一条角色信息记录
	@Override
	public <RoleInfo> int add(Class RoleInfo, Object object) {
		// TODO Auto-generated method stub
		if(RoleInfo instanceof Object){
			
			jxau.sms.lyx.po.RoleInfo data = (jxau.sms.lyx.po.RoleInfo) object;
			
			if(data.getRoleName()==null) {
				 throw  new  InsertErrorException("角色姓名不能为空");
			}else {
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("roleName",data.getRoleName());
				
				try{					
					searchListByAccurate(map,0);
					throw  new  DataExistException("角色姓名已存在，插入失败");
				}catch (NotFoundDataException e) {
					// TODO: handle exception
					dao.add("saveRole", object);
				}			
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

	@Override
	public <RoleInfo> List<RoleInfo> searchListByAccurate(Map<String, Object> param,
			int status) {
		// TODO Auto-generated method stub
		List<RoleInfo> list =  dao.select("findRoleByCondition", param);
		System.out.println(list.size());
		if(list.size()==0){
			throw new NotFoundDataException("没有符合条件的结果");
		}
		return list;
	}

	/**
	 * 添加角色以及角色权限信息
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertRoleInfoPurview(String roleName,String roleDescription,String param){
		
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleName(roleName);
		roleInfo.setCreateTime(new Date());
		roleInfo.setRoleDescription(roleDescription);
		
		add(RoleInfo.class, roleInfo);
		String number = getDataNum()+1+"";
		purviewListPackage.containerTransform(number, param);
	}
	
	/**
	 * 查询数据库中记录数
	 * 
	 */
	public long getDataNum(){
		
		long totalCount = dao.selectOne("findAllRoleInfoNums", null);
		return totalCount;
	}
	
}
