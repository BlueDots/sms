package jxau.sms.chenjiang.stuBasicInfo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.anping.exception.ParameterNotMatchException;
import jxau.sms.chenjiang.vo.StuBasicInfoVO;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.util.chenjiang.exception.NullPonterException;
import jxau.sms.util.chenjiang.exception.TypeNotMatchException;

@Service("stuBasicInfoServiceImpl")
public class StuBasicInfoServiceImpl extends AbstractionService implements GlobalServiceInterface{

	private String namespace ="jxau.sms.stuBasicInfo.dao.";
	
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
	@SuppressWarnings({"unchecked" })
	@Override
	public <StuBasicInfoVo> List<StuBasicInfoVo> searchByAccurate(Map<String, Object> param,
			PageVo pageVo, int status) {
		List<StuBasicInfoVO> lists = null;
    	List<String> queryCondition  = new ArrayList<String>(4);
    	queryCondition.add("college");
    	queryCondition.add("major");
    	queryCondition.add("className");
    	queryCondition.add("stuNoOrName");
		if(param == null) {//表示查询无限制
			param = new HashMap<String, Object>();
			for(int i=0;i<queryCondition.size();i++) {
				param.put(queryCondition.get(i), null);
			}
		}
		else {
			//如果是有的话，开始扫描条件是否符合规范
			Set<String> keys = param.keySet();
	    	for(String key :keys){
	    		 if(!queryCondition.contains(key)){
	    			 throw new ParameterNotMatchException("查询条件有误!");
	    		 }
	    	}
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
		return (List<StuBasicInfoVo>) lists;
	}

	@Override
	public <StuBasicInfo> int add(Class T, Object object) {
		int flag = 0;
		if(object == null) 
			throw new NullPonterException("传入对象不能为null");
		if(object.getClass() == T) {
			
			jxau.sms.chenjiang.po.StuBasicInfo s = (jxau.sms.chenjiang.po.StuBasicInfo)object;
			if(s.getStudentNo() == null || s.getStudentName() == null 
					|| s.getCollege() == null || s.getClassName() == null || s.getMajor()==null
					|| s.getIdCard() == null || s.getBirthday() == null) {
				throw new ParameterNotMatchException("添加的学生基本信息部分不能为空，请认真重新填写！");
			}
			dao.add(namespace+"add", object);
			flag = 1;
		}
		else if(object instanceof List<?>)  {
			List<StuBasicInfo> lists = (List<StuBasicInfo>)object;
			if(lists.get(0).getClass() != T)
				throw new TypeNotMatchException("类型不一致");
			
			for(int i=0;i<lists.size();i++) {
				jxau.sms.chenjiang.po.StuBasicInfo s = (jxau.sms.chenjiang.po.StuBasicInfo) lists.get(i);
				if(s.getStudentNo() == null || s.getStudentName() == null 
						|| s.getCollege() == null || s.getClassName() == null || s.getMajor()==null
						|| s.getIdCard() == null || s.getBirthday() == null) {
					throw new ParameterNotMatchException("添加的学生基本信息部分不能为空，请认真重新填写！");
				}
			}
			
			dao.add(namespace+"batchAdd", lists);
			flag = lists.size();
		}
		else throw new TypeNotMatchException("类型不一致");
		return flag;
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
	
	
	/**
	 * 得到待审核班级
	 * 江
	 * TODO
	 * 下午11:13:52
	 * params 
	 * @return
	 */
	public List<String> getWaitForClassName(Map<String, Object> params) {
		List<String> lists = null;
		lists = dao.select(namespace+"verifyQueryOfClass", params);
		return lists;
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
	 *                             <pageVo,pv> 分页对象
	 *                        例如:
	 *                        	 <exameState,'院级审核中'>
	 *                            <className,'软件1107'>
	 *                             <pageVo,pv> 
	 *                              
	 * 下午10:54:02
	 * @param  pageVo 分页信息
	 * @return
	 */
	@Override
	public <T> List<T> getWaitingForLists(Map<String, Object> params,
			PageVo pageVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
