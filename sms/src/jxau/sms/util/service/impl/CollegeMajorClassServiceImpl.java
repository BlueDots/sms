package jxau.sms.util.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jxau.sms.anping.exception.ParameterNotMatchException;
import jxau.sms.anping.po.ClassInfo;
import jxau.sms.anping.po.DepInfo;
import jxau.sms.anping.po.MajorInfo;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.globalService.GlobalServiceInterface;
import jxau.sms.globaldao.Dao;
import jxau.sms.util.chenjiang.exception.NullPonterException;

@Service("collegeMajorClassServiceImpl")
public class CollegeMajorClassServiceImpl implements GlobalServiceInterface {

	private String namespace ="jxau.sms.util.dao.";
	private Dao dao;
	
	
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	
	
	/**
	 * 得到学院list
	 * 江
	 * TODO
	 * 下午12:42:58
	 * @param pageVo 分页 page为null时，默认得到第一页的数据
	 * @param status  级别 0,代表只能开到state为0的数据,即激活状态的数据,级别1，可以得到所有状态的数据
	 * @return
	 */
	public  List<DepInfo> getCollegeLists(Map<String, Object> params,int status,PageVo pageVo) {
		if(status != 0 && status != 0) 
			throw new NullPonterException("传入参数status只能为0或1");
		if(pageVo == null) {
			pageVo = new PageVo();
			pageVo.setCurrentPage(1);
		}
		if(params == null) {
			params = new HashMap<String, Object>();
		}
		params.put("start", pageVo.getFirstIndex());
		params.put("nums", pageVo.getSize());
		
		if(status == 0) {
			params.put("status", 0);
		}
		else {
			params.put("status", null);
		}
		
		List<DepInfo> lists = null;
		lists = dao.select(namespace+"queryOfCollegeLists", params);
		long count = dao.selectOne(namespace+"queryOfCollegeNums", params);
		pageVo.setCount(count);
		
		return lists;
	}
	
	/**
	 * 得到专业list
	 * 江
	 * TODO
	 * 下午12:42:58
	 * @param pageVo 分页 page为null时，默认得到第一页的数据
	 * @param status  级别 0,代表只能开到state为0的数据,即激活状态的数据,级别1，可以得到所有状态的数据
	 * @return
	 */
	public  List<MajorInfo> getMajorLists(Map<String, Object> params,int status,PageVo pageVo) {
		if(params == null)
			throw new NullPonterException("传入params不能为null");
		if(status != 0 && status != 0) 
			throw new NullPonterException("传入参数status只能为0或1");
		if(pageVo == null) {
			pageVo = new PageVo();
			pageVo.setCurrentPage(1);
		}
		
		//查询条件
    	List<String> queryCondition  = new ArrayList<String>();
    	queryCondition.add("departNo");
		
    	//查询条件检验
    	if(!checkParams(queryCondition, params,1))
    		 throw new ParameterNotMatchException("查询条件输入有误!");
		
		params.put("start", pageVo.getFirstIndex());
		params.put("nums", pageVo.getSize());
		
		if(status == 0) {
			params.put("status", 0);
		}
		else {
			params.put("status", null);
		}
		
		List<MajorInfo> lists = null;
		lists = dao.select(namespace+"queryOfMajorLists", params);
		long count = dao.selectOne(namespace+"queryOfMajorNums", params);
		pageVo.setCount(count);
		
		return lists;
	}
	
	
	/**
	 * 得到班级list
	 * 江
	 * TODO
	 * 下午12:42:58
	 * @param pageVo 分页 page为null时，默认得到第一页的数据
	 * @param status  级别 0,代表只能开到state为0的数据,即激活状态的数据,级别1，可以得到所有状态的数据
	 * @return
	 */
	public  List<ClassInfo> getClassLists(Map<String, Object> params,int status,PageVo pageVo) {
		if(params == null)
			throw new NullPonterException("传入params不能为null");
		if(status != 0 && status != 0) 
			throw new NullPonterException("传入参数status只能为0或1");
		if(pageVo == null) {
			pageVo = new PageVo();
			pageVo.setCurrentPage(1);
		}
		
		//查询条件
    	List<String> queryCondition  = new ArrayList<String>();
    	queryCondition.add("majorNo");
		
    	//查询条件检验
    	if(!checkParams(queryCondition, params,1))
    		 throw new ParameterNotMatchException("查询条件输入有误!");		
		
		params.put("start", pageVo.getFirstIndex());
		params.put("nums", pageVo.getSize());
		
		if(status == 0) {
			params.put("status", 0);
		}
		else {
			params.put("status", null);
		}
		
		List<ClassInfo> lists = null;
		lists = dao.select(namespace+"queryOfClassLists", params);
		long count = dao.selectOne(namespace+"queryOfClassNums", params);
		pageVo.setCount(count);
		
		return lists;
	}
		
	
	
	/**
	 * 
	 */
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

	@Override
	public <T> List<T> searchByAccurate(Map<String, Object> param,
			PageVo pageVo, int status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> int add(Class T, Object object) {
		// TODO Auto-generated method stub
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
	
}
