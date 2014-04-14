package jxau.sms.abstration;

import java.util.List;
import java.util.Map;

import jxau.sms.util.chenjiang.moduleStateUpdate.ModuleStateOperation;
import jxau.sms.util.chenjiang.roleVerify.RolesVerifyOperation;

public abstract class AbstractionService {
	private RolesVerifyOperation rolesVerifyOperation;
	private ModuleStateOperation moduleStateOperation;
	
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
	
	
	/**
	 * 
	 * 江
	 * TODO
	 * 下午8:44:57
	 * @param moduleId 模块号 
	 *                 详见jxau/sms/chenjiangConfig/moduleState.xml
	 * @param ids id集合
	 * @param moduleState 改变的状态
	 * @param relatedStates 状态改变级联的属性字段：若没有则写null,
	 * 				ps只有moduleId为08的模块才不为null，其他模块都写null
	 * @param remarks 备注 没有备注可以为null
	 * 
	 */
	public <T> void moduleStateUpdate(String moduleId,List<T>  ids,Object moduleState,Map<String, Object> relatedStates,String remarks) {
		moduleStateOperation.moduleStateUpdate(ids, moduleState, relatedStates, remarks, moduleId);
	}
	
	/**
	 * 改变子表的状态
	 * 江
	 * TODO
	 * 上午10:15:06
	 * @param ids 主键集合
	 * @param subState 要改变的状态
	 * @param remarks 备注 若无备注 ,为null
	 * @param subId  子表的编号 如活动类别表的subId为：actCategory ，详见jxau/sms/chenjiangConfig/moduleState.xml
	 */
	public <T> void subTableStateUpdate(List<T>  ids,Object subState,String remarks,String subId) {
		moduleStateOperation.subTableStateUpdate(ids, subState, remarks, subId);
	}
}
