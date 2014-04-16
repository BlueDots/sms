package jxau.sms.chenjiang.activityManage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.anping.exception.ParameterNotMatchException;
import jxau.sms.chenjiang.po.ActHold;
import jxau.sms.chenjiang.po.ActInfo;
import jxau.sms.chenjiang.vo.ActHoldVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.lyx.util.JavaTest;
import jxau.sms.util.chenjiang.exception.NullPonterException;
import jxau.sms.util.chenjiang.exception.ParamWrongException;
import jxau.sms.util.chenjiang.exception.TypeNotMatchException;


@Transactional(propagation=Propagation.REQUIRED)
@Service("activityManageServiceImpl")
public class ActivityManageServiceImpl extends AbstractionService implements GlobalServiceInterface {

	private String actInfoNamespace ="jxau.sms.chenjiang.activityManage.ActInfo.dao.";
	private String actHoldNamespace ="jxau.sms.chenjiang.activityManage.ActHold.dao.";
	
	
	private Dao dao;
	
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public <T> List<T> searchListByAccurate(Map<String, Object> param,
			int status) {
		return null;
	}

	@Override
	public <T> T searchByAccurate(Map<String, Object> param, int status) {
		return null;
	}

	/**
	 * 
	 * @param param  你需要查询的条件
	 * 
	 * 必须有 <"vo",0 or 1>
	 * 0 :表示查询ActInfo的相关信息
	 * 1 :表示查询ActHold的相关信息
	 * @param pageVo  分页封装类　,在该方法中需要调用pageVo.setCount,而在action中需要调用setCurrentPage方法，默认一页显示10条
	 * @param status  级别 0,代表只能开到state为0的数据，级别1，可以开到所有状态的数据
	 * @return    返回的是一个List<xxx> 并且PageVo分页信息也得到了变化
	 */
	@Transactional(readOnly=true)
	@SuppressWarnings({"unchecked" })
	@Override
	public <T> List<T> searchByAccurate(Map<String, Object> param,
			PageVo pageVo, int status) {
		
		if(param == null)
			throw new NullPonterException("param不能为null");
			
		System.out.println(param.get("vo"));
		if(param.get("vo") == null || ((Integer)param.get("vo") !=0 && (Integer)param.get("vo") !=1))
			throw new ParamWrongException("输入参数params 必须有key:vo 且value只能为0或1");
    	int vo = (Integer)param.get("level");
    	List<T> lists = null;
    	if(vo == 0) {
			//查询条件
	    	List<String> queryCondition  = new ArrayList<String>();
	    	//一般查询条件
	    	queryCondition.add("organize");
	    	queryCondition.add("actNoOrName");
	    	
	    	//高级查询条件
	    	queryCondition.add("activityLevel");
	    	queryCondition.add("activityType");
	    	queryCondition.add("createTime");
	    	queryCondition.add("exameState");
	    	queryCondition.add("sponsor");
	    	queryCondition.add("actState");
	    	queryCondition.add("studentName");
	    	queryCondition.add("teacherName");
	    	queryCondition.add("order");
		    //查询条件检验
		    if(!checkParams(queryCondition, param,1))
		    		 throw new ParameterNotMatchException("查询条件输入有误!");
			param.put("start", pageVo.getFirstIndex());
	    	param.put("nums",   pageVo.getSize());
	    	if(status == 0) 
	    		param.put("status", 0);
	    	else 
	    		param.put("status", null);
	    	//得到查询结果
			lists = dao.select(actInfoNamespace+"query", param);
			long totalCount = dao.selectOne(actInfoNamespace+"queryNums", param);
			pageVo.setCount(totalCount);
    	}
    	else {
			//查询条件
	    	List<String> queryCondition  = new ArrayList<String>();
	    	//一般查询条件
	    	queryCondition.add("actNo");
	    	 //查询条件检验
		    if(!checkParams(queryCondition, param,1))
		    		 throw new ParameterNotMatchException("查询条件输入有误!");
			param.put("start", pageVo.getFirstIndex());
	    	param.put("nums",   pageVo.getSize());
	    	//得到查询结果
			lists = dao.select(actHoldNamespace+"query", param);
			long totalCount = dao.selectOne(actHoldNamespace+"queryNums", param);
			pageVo.setCount(totalCount);
    	}
		return  lists;
	}

	@Override
	public <T> int add(Class T, Object object) {
		if(ActInfo.class != T && ActHold.class != T)
			throw new ParamWrongException("传入的参数T 必须是 ActInfo.class 或  ActHold.class");
		int flag = 0;
		if(object == null) 
			throw new NullPonterException("传入对象不能为null");
		if(object.getClass() == T) {
			if(object.getClass() == ActInfo.class) {
				ActInfo a = (ActInfo) object;
				if(a.getActivityName() == null ||a.getActivityType() == null||a.getActivityLevel() == null
						|| a.getSponsor() == null|| a.getOrganize() == null ||a.getTecBasicInfo() == null
						|| a.getTecBasicInfo().getTeacherNo() == null)  {
					throw new ParameterNotMatchException("添加的活动信息部分不能为空，请认真重新填写！");
				}
				
			}
			else {
				ActHold a = (ActHold)object;
				if(a.getActInfo() == null || a.getActInfo().getActNo() == 0
						||a.getSessionYear() == 0 ||a.getStartTime()==null
						||a.getEndTime() == null || a.getHoldPlace() == null) 
					throw new ParameterNotMatchException("添加的活动举办信息部分不能为空，请认真重新填写！");
				dao.add(actHoldNamespace+"add", object);
			}
			flag = 1;
		}
		else if(object instanceof List<?>)  {
			List<T> lists = (List<T>)object;
			if(lists.get(0).getClass() != T)
				throw new TypeNotMatchException("类型不一致");
			if(lists.get(0).getClass() == ActInfo.class) {
				for(int i=0;i<lists.size();i++) {
					ActInfo a = (ActInfo) lists.get(i);
					if(a.getActivityName() == null ||a.getActivityType() == null||a.getActivityLevel() == null
							|| a.getSponsor() == null|| a.getOrganize() == null ||a.getTecBasicInfo() == null
							|| a.getTecBasicInfo().getTeacherNo() == null)  {
						throw new ParameterNotMatchException("添加的活动信息部分不能为空，请认真重新填写！");
					}
				}
				
				dao.add(actInfoNamespace+"batchAdd", lists);
			}
			else {
				for(int i=0;i<lists.size();i++) {
					ActHold a = (ActHold) lists.get(i);;
					if(a.getActInfo() == null || a.getActInfo().getActNo() == 0
							||a.getSessionYear() == 0 ||a.getStartTime()==null
							||a.getEndTime() == null || a.getHoldPlace() == null) 
						throw new ParameterNotMatchException("添加的活动举办信息部分不能为空，请认真重新填写！");
					}
				dao.add(actHoldNamespace+"batchAdd", lists);
			}	
			flag = lists.size();
		}
		else throw new TypeNotMatchException("类型不一致");
		return flag;
	}

	public <T> int update(Class T, Object object) {
		if(ActInfo.class != T && ActHold.class != T)
			throw new ParamWrongException("传入的参数T 必须是 ActInfo.class 或  ActHold.class");
		int flag = 0;
		if(object == null) 
			throw new NullPonterException("传入对象不能为null");
		if(object.getClass() == T) {
			if(object.getClass()==ActInfo.class) {
				ActInfo a = (ActInfo)object;
				if(a.getActNo() == 0) {
					throw new ParameterNotMatchException("更新的活动信息的actNo不能为空或0，请认真重新填写！");
				}
				dao.update(actInfoNamespace+"update", object);
			}
			else {
				ActHold a = (ActHold)object;
				if(a.getId() == 0) {
					throw new ParameterNotMatchException("更新的活动举办信息的id不能为空或0，请认真重新填写！");
				}
				dao.update(actHoldNamespace+"update", object);
			}
			flag = 1;
		}
		else if(object instanceof List<?>)  {
			List<T> lists = (List<T>)object;
			if(lists.get(0).getClass() != T)
				throw new TypeNotMatchException("类型不一致");
			if(lists.get(0).getClass() == ActInfo.class) {
				for(int i=0;i<lists.size();i++) {
					ActInfo a = (ActInfo) lists.get(i);
					if(a.getActNo() == 0) {
						throw new ParameterNotMatchException("更新的活动信息的actNo不能为空或0，请认真重新填写！");
					}
				}
				dao.batchUpdate(actInfoNamespace+"update", lists);
			}
			else {
				for(int i=0;i<lists.size();i++) {
					ActHold a = (ActHold) lists.get(i);
					if(a.getId() == 0) {
						throw new ParameterNotMatchException("更新的活动举办信息的id不能为空或0，请认真重新填写！");
					}
				}
				dao.batchUpdate(actHoldNamespace+"update", lists);
			}
			flag = lists.size();
		}
		else throw new TypeNotMatchException("类型不一致");
		return flag;		
	}

	@Override
	public <T> int delete(Class T, Map<String, Object> param) {
		if(ActHold.class != T)
			throw new ParamWrongException("传入的参数T 必须是 ActHold.class");
		return 0;
	}
	
	
	
	/**
	 * 得到待审核活动信息
	 * 江
	 * TODO
	 * 下午11:13:52
	 * params 只有校级工作人员才有审核权限
	 * 		  校级工作人员必须有<exameState,"校级审核中"
	 * 
	 *                              
	 * 下午10:54:02
	 * @param  pageVo 分页信息
	 * @return
	 */
	@Transactional(readOnly=true)
	@SuppressWarnings("hiding")
	@Override
	public <T> List<T> getWaitingForLists(Map<String, Object> params,
			PageVo pageVo) {
		if(params == null)
			throw new NullPonterException("params不能为null");
    	//查询条件
		List<String> queryCondition  = new ArrayList<String>();   	
		queryCondition.add("exameState");
		
    	if(!this.checkParams(queryCondition, params, 0))
    		 throw new ParameterNotMatchException("查询条件输入有误!");
		
		params.put("start", pageVo.getFirstIndex());
    	params.put("nums",   pageVo.getSize());
		
		List<T> lists = null;
		lists = dao.select(actInfoNamespace+"verifyQuery", params);
		long count = dao.selectOne(actInfoNamespace+"verifyQueryNums", params);
		pageVo.setCount(count);
    	
		return lists;
	}
	
	/**
	 * 
	 * 江
	 * TODO
	 * 下午3:08:15
	 * @param paramsCondition
	 * @param params
	 * @param flag 0:表示params的key 必须包含 paramsCondition的全部内容
	 * 			   1:表示params的key 只需有paramsCondition的一部分内容
	 * @return
	 */
	private boolean checkParams(List<String> paramsCondition,Map<String, Object> params,int flag) {
		Set<String> keys = params.keySet();
		if(flag == 0)
	    	for(int i=0;i<paramsCondition.size();i++){
	    		 if(!keys.contains(paramsCondition.get(i))){
	    			return false;
	    		 }
	    	}
		else if(flag == 1){
			for(String key:keys) {
				if(!paramsCondition.contains(key))
					return false;
			}
		}
		return true;
	}

	@Override
	public <T> int update(Class T, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
