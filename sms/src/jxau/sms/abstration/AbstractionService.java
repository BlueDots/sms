package jxau.sms.abstration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jxau.sms.thomas.util.InputHandler;
import jxau.sms.thomas.util.OutputHandler;
import jxau.sms.util.chenjiang.moduleStateUpdate.ModuleStateOperation;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.util.chenjiang.roleVerify.RolesVerifyOperation;

@Transactional(propagation=Propagation.REQUIRED)
public abstract class AbstractionService {
	private RolesVerifyOperation rolesVerifyOperation;
	private ModuleStateOperation moduleStateOperation;
	private InputHandler inputHandler;
	private OutputHandler outputHandler;
	
	@Resource(name="rolesVerifyOperation")
	public void setRolesVerifyOperation(RolesVerifyOperation rolesVerifyOperation) {
		this.rolesVerifyOperation = rolesVerifyOperation;
	}
	@Resource(name="moduleStateOperation")
	public void setModuleStateOperation(ModuleStateOperation moduleStateOperation) {
		this.moduleStateOperation = moduleStateOperation;
	}
	
	/**
	 * 得到待审核的信息列表（一般是以组的形式拿出来的，ps:以班级，活动名称，年级。。）
	 * 江
	 * TODO
	 *　　　　　　　  需要传入的参数格式为 HashMap<String,Object>
	 *                            <exameState,'院级审核中' or '校级审核中'>
	 *                            <条件1,'xxx'>
	 *                            <条件2,'xxx'>
	 *                           	...
	 *                        例如:
	 *                        	 <exameState,'院级审核中'>
	 *                            <className,'软件1107'>
	 *                              
	 * 下午10:54:02
	 * @param params
	 * @return
	 */
	public abstract <T>  List<T> getWaitingForLists(Map<String, Object> params,PageVo pageVo);
	
	/**
	 * 批量审核
	 * @param ids ：主键集合
	 * @param moduleId：模块号
	 *            详见jxau/sms/chenjiangConfig/roleVerify.xml
	 * @param roleId:操作角色
	 *  		roleId 1:学生  2：班主任 3：院级工作人员 4：校级工作人员 6:活动负责人
	 * @param operationId：操作编号  "1"：审核通过；"2"：审核不通过；
	 * @param remarks:备注  (可以为null)
	 * 					
	 */
	public  <T>  void  verify(List<T> ids, String moduleId,String roleId,String operationId,Object remarks){
		rolesVerifyOperation.roleVerifyOperation(ids, moduleId, roleId, operationId, remarks);
	}
	
	/**
	 * 得到待审核人数
	 * @param moduleId 模块编号  
	 * 						详见jxau/sms/chenjiangConfig/roleVerify.xml
	 * @param roleId 角色编号 ，该角色必须有审核的权限才能有数据返回 
	 * 	roleId 1:学生  2：班主任 3：院级工作人员 4：校级工作人员 6:活动负责人
	 * @return -1 出错, >=0 执行成功
	 */
	public int getWaitingVerifyNums(String moduleId,String roleId) {
		return rolesVerifyOperation.getRoleWaitForVerifyNums(moduleId, roleId);
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
	 * @param remarks 备注 (没有备注可以为null)
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
	 * @param remarks 备注 (若无备注 ,为null)
	 * @param subId  子表的编号 如活动类别表的subId为：actCategory ，详见jxau/sms/chenjiangConfig/moduleState.xml
	 */
	public <T> void subTableStateUpdate(List<T>  ids,Object subState,String remarks,String subId) {
		moduleStateOperation.subTableStateUpdate(ids, subState, remarks, subId);
	}
	
<<<<<<< HEAD
	public <T> List<T> inputExcel(String abstractId,List<T> attributes,String filePath) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		InputHandler input = new InputHandler(abstractId);
		return input.setAttributes(attributes, filePath);
	}
	public int exportExcel(String filePath,String abstractId,Map params) throws IOException {
		OutputHandler output = new OutputHandler(abstractId);
		output.exportExcel(filePath,params);
		return 0;
	}
	public <T> int exportExcel(String filePath,String abstractId,List<T> attributes) throws IOException {
		OutputHandler output = new OutputHandler(abstractId);
		output.exportExcel(filePath, attributes);
		return 0;
	}
=======
	
	//角色录入抽象类，（自动根据角色来注入审核状态）
	//实现该方法，在录入所需数据（dao.add）前调用setExameStateOfEntering方法来为记录注入审核状态
	/**
	 * 
	 * 江
	 * TODO
	 * 下午8:10:38
	 * @param c
	 * @param c 是为了在做添加的时候做判断用户是不是传入了正确的对象
	 * @param entryObject 录入对象集合,可以是单个对象也可以是集合
	 * 			
	 * @param moduleId 模块号
	 * @param roleId 角色号
	 * @param level 只有模块03 才填0或1，其他模块通通为null
	 * @return 录入数据个数
	 */
	public abstract <T> int roleEntry(Class<?> c,Object entryObject,String moduleId,String roleId,String level);
	
	//角色录入具体实现类，（自动根据角色来注入审核状态）
	/**
	 * 
	 * 江
	 * TODO
	 * 下午8:10:38
	 * @param c
	 * @param c 是为了在做添加的时候做判断用户是不是传入了正确的对象
	 * @param entryObject 录入对象集合,可以是单个对象也可以是集合
	 * 			
	 * @param moduleId 模块号
	 * @param roleId 角色号
	 * @param level 只有模块03 才填0或1，其他模块通通为null
	 * 
	 */
	public <T> void setExameStateOfEntering(Class<?> c,Object entryObject,String moduleId,String roleId,String level) {
		rolesVerifyOperation.setExameStateOfEntering(c, entryObject, moduleId, roleId, level);
		
	}
	
>>>>>>> f31ed4e78f664d4a15cae297d7490fe2b7be40d3
}
