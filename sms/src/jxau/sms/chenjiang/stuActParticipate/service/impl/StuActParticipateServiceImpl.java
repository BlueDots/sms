package jxau.sms.chenjiang.stuActParticipate.service.impl;

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
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.util.chenjiang.exception.NullPonterException;
import jxau.sms.util.chenjiang.exception.ParamWrongException;
import jxau.sms.util.chenjiang.exception.TypeNotMatchException;

@Transactional(propagation=Propagation.REQUIRED)
@Service("stuActParticipateServiceImpl")
public class StuActParticipateServiceImpl  extends AbstractionService implements GlobalServiceInterface {

	private String namespace ="jxau.sms.chenjiang.stuActParticipate.dao.";
	
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
	 * @param pageVo  分页封装类　,在该方法中需要调用pageVo.setCount,而在action中需要调用setCurrentPage方法，默认一页显示10条
	 * @param status  级别 0,代表只能开到state为0的数据，级别1，可以开到所有状态的数据
	 * @return    返回的是一个List<xxx> 并且PageVo分页信息也得到了变化
	 */
	@Transactional(readOnly=true)
	@SuppressWarnings({"unchecked" })
	@Override
	public <StuActParticipateVO> List<StuActParticipateVO> searchByAccurate(Map<String, Object> param,
			PageVo pageVo, int status) {
		List<StuActParticipateVO> lists = null;
		//查询条件
    	List<String> queryCondition  = new ArrayList<String>();
    	//一般查询条件
    	queryCondition.add("college");
    	queryCondition.add("major");
    	queryCondition.add("className");
    	queryCondition.add("stuNoOrName");
    	//高级查询条件
    	queryCondition.add("exameState");
    	queryCondition.add("major");
    	queryCondition.add("exameState");
    	queryCondition.add("activityName");
    	queryCondition.add("activityLevel");
    	queryCondition.add("activityType");
    	queryCondition.add("studentPost");
    	queryCondition.add("sex");
    	queryCondition.add("workingTime");
    	queryCondition.add("sessionYear");
    	queryCondition.add("awardTime");
    	queryCondition.add("stuActState");
    	queryCondition.add("order");
		if(param == null) {//表示查询无限制
			param = new HashMap<String, Object>();
			for(int i=0;i<queryCondition.size();i++) {
				param.put(queryCondition.get(i), null);
			}
		}
		else {
			//如果是有的话，开始扫描条件是否符合规范
	    	//查询条件检验
	    	if(!checkParams(queryCondition, param,1))
	    		 throw new ParameterNotMatchException("查询条件输入有误!");
		}
		param.put("start", pageVo.getFirstIndex());
    	param.put("nums",   pageVo.getSize());
    	if(status == 0) 
    		param.put("status", 0);
    	else 
    		param.put("status", null);
    	//得到查询结果
		lists = dao.select(namespace+"query", param);
		long totalCount = dao.selectOne(namespace+"queryNums", param);
		pageVo.setCount(totalCount);
		return (List<StuActParticipateVO>) lists;
	}

	@Override
	public <StuActParticipate> int add(Class T, Object object) {
		
		if(jxau.sms.chenjiang.po.StuActParticipate.class != T )
			throw new ParamWrongException("传入的参数T 必须是 StuActParticipate.class");
		
		int flag = 0;
		if(object == null) 
			throw new NullPonterException("传入对象不能为null");
		if(object.getClass() == T) {
			
			jxau.sms.chenjiang.po.StuActParticipate s = (jxau.sms.chenjiang.po.StuActParticipate) object;
			if(s.getActInfo() == null ||s.getActInfo().getActNo()==0||s.getStuBasicInfo() == null
					|| s.getStuBasicInfo().getStudentNo() == null|| s.getStuBasicInfo().getStudentNo().equals("") 
					|| s.getAwardTime() == null || s.getActivityRating()==null)  {
				throw new ParameterNotMatchException("添加的学生参与活动信息部分不能为空，请认真重新填写！");
			}
			dao.add(namespace+"add", object);
			flag = 1;
		}
		else if(object instanceof List<?>)  {
			List<StuActParticipate> lists = (List<StuActParticipate>)object;
			if(lists.get(0).getClass() != T)
				throw new TypeNotMatchException("类型不一致");
			
			for(int i=0;i<lists.size();i++) {
				jxau.sms.chenjiang.po.StuActParticipate s = (jxau.sms.chenjiang.po.StuActParticipate) lists.get(i);
				if(s.getActInfo() == null ||s.getActInfo().getActNo()==0||s.getStuBasicInfo() == null
						|| s.getStuBasicInfo().getStudentNo() == null|| s.getStuBasicInfo().getStudentNo().equals("") 
						|| s.getAwardTime() == null || s.getActivityRating()==null) {
					throw new ParameterNotMatchException("添加的学生参与活动信息部分不能为空，请认真重新填写！");
				}
			}
			
			dao.add(namespace+"batchAdd", lists);
			flag = lists.size();
		}
		else throw new TypeNotMatchException("类型不一致");
		return flag;
	}

	public <StuActParticipate> int update(Class T, Object object) {
		if(jxau.sms.chenjiang.po.StuActParticipate.class != T )
			throw new ParamWrongException("传入的参数T 必须是 StuActParticipate.class");
		int flag = 0;
		if(object == null) 
			throw new NullPonterException("传入对象不能为null");
		if(object.getClass() == T) {
			
			jxau.sms.chenjiang.po.StuActParticipate s = (jxau.sms.chenjiang.po.StuActParticipate)object;
			if(s.getId() == 0) {
				throw new ParameterNotMatchException("更新的学生参与活动信息的id不能为空或0，请认真重新填写！");
			}
			dao.update(namespace+"update", object);
			flag = 1;
		}
		else if(object instanceof List<?>)  {
			List<jxau.sms.chenjiang.po.StuActParticipate> lists = (List<jxau.sms.chenjiang.po.StuActParticipate>)object;
			if(lists.get(0).getClass() != T)
				throw new TypeNotMatchException("类型不一致");
			
			for(int i=0;i<lists.size();i++) {
				jxau.sms.chenjiang.po.StuActParticipate s = (jxau.sms.chenjiang.po.StuActParticipate) lists.get(i);
				if(s.getId() == 0) {
					throw new ParameterNotMatchException("更新的学生参与活动信息的id不能为空或0，请认真重新填写！");
				}
			}
			
			dao.batchUpdate(namespace+"update", lists);
			flag = lists.size();
		}
		else throw new TypeNotMatchException("类型不一致");
		return flag;		
	}

	@Override
	public <T> int delete(Class T, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/**
	 * 得到待审核活动举办信息
	 * 江
	 * TODO
	 * 下午11:13:52
	 * params 院级工作人员查询 必须有<exameState,"xxx"
	 * 							level,0
	 * 				          organize   ,"xx"	>
	 * 		  校级工作人员必须有<exameState,"xxx"
	 * 						level,1>
	 * level: 0:院级查询
	 * 		  1：校级查询
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<ActHold> getWaitForActHold(Map<String, Object> params,PageVo pageVo) {
		
		if(params == null)
			throw new NullPonterException("params不能为null");
			
		System.out.println(params.get("level"));
		if(params.get("level") == null || ((Integer)params.get("level") !=0 && (Integer)params.get("level") !=1))
			throw new ParamWrongException("输入参数params 必须有key:level 且value只能为0或1");
    	int level = (Integer)params.get("level");
    	//查询条件
		List<String> queryCondition  = new ArrayList<String>();   	
		queryCondition.add("exameState");
    	if(level == 0) {
    		queryCondition.add("organize");
    	}
		
    	if(!this.checkParams(queryCondition, params, 0))
    		 throw new ParameterNotMatchException("查询条件输入有误!");
		
		params.put("start", pageVo.getFirstIndex());
    	params.put("nums",   pageVo.getSize());
		
		List<ActHold> lists = null;
		lists = dao.select(namespace+"verifyQueryOfActivity", params);
		long count = dao.selectOne(namespace+"verifyQueryOfActivityNums", params);
		pageVo.setCount(count);
		return lists;
	}

	
	/**
	 * 得到待审核的信息列表（一般是以组的形式拿出来的，ps:以班级，活动名称，年级。。）
	 * 江
 	 *	params 院级工作人员查询 必须有<exameState,"xxx"
 	 *							activityName,"xxx"
	 * 							level,0
	 * 				          organize   ,"xx"	>
	 * 		  校级工作人员必须有<exameState,"xxx"
	 * 						activityName,"xxx"
	 * 						level,1>
	 * level: 0:院级查询
	 * 		  1：校级查询               
	 *                              
	 * 下午10:54:02
	 * @param  pageVo 分页信息
	 * @return
	 */
	@Transactional(readOnly=true)
	@SuppressWarnings("hiding")
	@Override
	public <StuActParticipateVO> List<StuActParticipateVO> getWaitingForLists(Map<String, Object> params,
			PageVo pageVo) {
	   	if(params == null) 
    		throw new NullPonterException("参数不能为null");
	   	
	   	if(params.get("level") == null || ((Integer)params.get("level") !=0 && (Integer)params.get("level") !=1))
			throw new ParamWrongException("输入参数params 必须有key:level 且value只能为0或1");
    	int level = (Integer)params.get("level");
    	//查询条件
		List<String> queryCondition  = new ArrayList<String>();   	
		queryCondition.add("exameState");
		queryCondition.add("actNo");
    	if(level == 0) {
    		queryCondition.add("organize");
    	}
    	
 
    	//查询条件检验
    	if(!checkParams(queryCondition, params,0))
    		 throw new ParameterNotMatchException("查询条件输入有误!");
    	
		params.put("start", pageVo.getFirstIndex());
    	params.put("nums",   pageVo.getSize());
    	
    	List<StuActParticipateVO> lists = null;
    	lists = dao.select(namespace+"verifyQuery", params);
    	long count = dao.selectOne(namespace+"verifyQueryNums", params); 	
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
