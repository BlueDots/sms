package jxau.sms.abstration;

import java.util.List;

import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.util.chenjiang.roleVerify.RolesVerifyOperation;

public abstract class AbstractionService {
	private RolesVerifyOperation rolesVerifyOperation;
	
	/**
	 * 批量审核
	 * @param ids ：主键集合
	 * @param moduleId：模块号
	 * @param roleId:操作角色
	 * @param operationId：操作编号  "1"：审核通过；"2"：审核不通过；
	 * @param remarks:备注
	 */
	public  <T>  void  verify(List<T> ids, String moduleId,String roleId,String operationId,String remarks){
		rolesVerifyOperation.roleVerifyOperation(ids, moduleId, roleId, operationId, remarks);
	}
	
	/**
	 * 得到待审核人数
	 * @param moduleId 模块编号
	 * @param roleId 角色编号 ，该角色必须有审核的权限才能有数据返回 
	 * 	roleId 1:学生  2：班主任 3：院级工作人员 4：校级工作人员 6:活动负责人
		operationId 1:审核通过 2:审核不通过 3:录入
	 * @return -1 出错, >=0 执行成功
	 */
	public int getWaitingVerifyNums(String moduleId,String roleId) {
		return rolesVerifyOperation.getRoleWaitForVerifyNums(moduleId, roleId);
	}
	
	
	/**
	 * 
	 * 在录入时设置默认审核状态
	 * TODO
	 * 下午7:39:01
	 * @param c 是为了在做添加的时候做判断用户是不是传入了正确的对象
	 * @param lists 录入对象集合
	 * @param moduleId 模块号
	 * @param roleId 角色号
	 * @param level: 除了学生参与活动模块外其余模块都为null 
	 * 		对于学生参与活动模块的roleId=6的角色 ，level=1：录入院级活动；level=2：录入校级活动 
	 */
	
	public <T> void setExameStateOfEntering(Class<?> c,List<T> lists,String moduleId,String roleId,String level) {
		rolesVerifyOperation.setExameStateOfEntering(c, lists, moduleId, roleId ,level);
	}
}
