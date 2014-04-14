package jxau.sms.util.chenjiang.moduleStateUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import jxau.sms.globaldao.Dao;

import org.springframework.stereotype.Component;


@Component("moduleStateOperation")
public class ModuleStateOperation {
	private Dao dao;
	

	private ModuleStateSetUp moduleStateSetUp;
	
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Resource(name="moduleStateSetUp")
	public void setModuleStateSetUp(ModuleStateSetUp moduleStateSetUp) {
		this.moduleStateSetUp = moduleStateSetUp;
	}
	
	
	/**
	 * 
	 * 江
	 * TODO
	 * 下午8:44:57
	 * @param ids id集合
	 * @param moduleState 改变的状态
	 * @param relatedStates 状态改变级联的属性字段：若没有则写null
	 * @param remarks 备注 没有备注可以为null
	 * @param moduleId 模块号
	 */
	public <T> void moduleStateUpdate(List<T>  ids,Object moduleState,Map<String, Object> relatedStates,String remarks,String moduleId) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(remarks == null) remarks="";
		//创建StateUpdate实体
		StateUpdate sUpdate = moduleStateSetUp.createStateUpdate(moduleId);
		List<ColumnValue<Object>> cvls =null;
		List<String> relatedstates = sUpdate.getRelatedStates();
		if(relatedStates !=null && relatedstates !=null) {
			cvls= new ArrayList<ColumnValue<Object>>();
			Set<String> set = relatedStates.keySet();
			for(String key:set) {
				for(int i=0;i<relatedstates.size();i++) {
					if(key.equals(relatedstates.get(i))) {
						cvls.add(new ColumnValue<>(relatedstates.get(i),relatedStates.get(key) ));
					}
				}
			}
			//System.out.println(relatedStates);
			//System.out.println(cvls);
		}
		
		//System.out.println(sUpdate);
		
		params.put("remarks", remarks);
		params.put("ids", ids);		
		params.put("moduleState", moduleState);		
		params.put("columnValue", cvls);
		params.put("sUpdate", sUpdate);
		
		//System.out.println(params);
		
		dao.update("jxau.sms.util.chenjiang.moduleStateUpdate.stateUpdate", params);
	}
	
	/**
	 * 
	 * 江
	 * TODO
	 * 上午10:15:06
	 * @param ids 主键集合
	 * @param subState 要改变的状态
	 * @param remarks 备注 若无备注 ,为null
	 * @param subId  子表的编号 如活动类别表的subId为：actCategory ，详见jxau/sms/chenjiangConfig/moduleState.xml
	 */
	public <T> void subTableStateUpdate(List<T>  ids,Object subState,String remarks,String subId) {
		Map<String, Object> params = new HashMap<String, Object>();
		if(remarks == null) remarks="";
		//创建StateUpdate实体
		StateUpdate sUpdate = moduleStateSetUp.createStateUpdate(subId);

		
		System.out.println(sUpdate);
		
		params.put("remarks", remarks);
		params.put("ids", ids);		
		params.put("moduleState", subState);		
		params.put("sUpdate", sUpdate);
		
		System.out.println(params);
		
		dao.update("jxau.sms.util.chenjiang.moduleStateUpdate.stateUpdate", params);
		
	}
	
}
