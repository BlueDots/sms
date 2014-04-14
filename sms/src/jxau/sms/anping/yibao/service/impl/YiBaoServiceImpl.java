package jxau.sms.anping.yibao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import jxau.sms.anping.exception.ParameterNotMatchException;
import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;

/**
 * 医保的业务逻辑类
 * 
 * @author anping 2014-4-14 TODO
 */
public class YiBaoServiceImpl implements GlobalServiceInterface {
 
	private String namespace ="jxau.sms.anping.yibao.dao";
	private Dao dao ;
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	/**
	 * 学生查询自己的医保申请情况的时候不使用分页
	 */
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
	 * 传入各种条件，然后我做判断并且取到相应的数据
	 * 这里涉及的查询有　　校级工作人员通过各种条件去查询信息
	 * 　　　　　　　　　  需要传入的参数格式为 HashMap<String,Object>
	 *                            <college,'江西农大'>
	 *                            <className,'1102'>
	 *                            <studentName,'熊安平'>
	 *                            <fristIndex,0>
	 *                             <max,100>  
	 */
	@SuppressWarnings("hiding")
	@Override
	public <HosInsuranceInfo> List<HosInsuranceInfo> searchByAccurate(Map<String, Object> param,PageVo pageVo, int status) {
	    if(param==null){
	    	//如果条件为空的话，我以分页的形式查询出数据
	    	param= new HashMap<String,Object>(2);
	    }else{
	    	//如果是有的话，开始扫描条件是否符合规范
	    	List<String> queryCondition  = new ArrayList<String>(4);
	    	queryCondition.add("hosState");
	    	queryCondition.add("college");
	    	queryCondition.add("className");
	    	queryCondition.add("studentName");
	    	queryCondition.add("studentNo");
	    	Set<String> keys = param.keySet();
	    	
	    	for(String key :keys){
	    		 if(!queryCondition.contains(key)){
	    			 throw new ParameterNotMatchException("你需要查询的条件包含不支持条件");
	    		 }
	    	}
	    }
		param.put("firstIndex", pageVo.getFirstIndex());
    	param.put("size",   pageVo.getSize());
	    List<HosInsuranceInfo>  hoss =  dao.select(namespace+"findYiBaoByCondition",param);
		long  totalCount   = dao.selectOne(namespace+"findYiBaoByConditionNum", param);
        pageVo.setCount(totalCount);
		return hoss;
	}

	@Override
	public <T> int add(Class T, Object object) {
	 	return 0;
	}

	@Override
	public <T> int update(Class T, Map<String, Object> param) {
		 return 0;
	}

	@Override
	public <T> int delete(Class T, Map<String, Object> param) {
		return 0;
	}
	
 

}
