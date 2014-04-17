package jxau.sms.anping.yibao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jxau.sms.anping.exception.AccessOrUpdateErrorException;
import jxau.sms.anping.exception.ParameterNotMatchException;
import jxau.sms.anping.exception.ParamterTypeErrorException;
import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.service.YiBaoService;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.commom.vo.PageVo;

import jxau.sms.globaldao.Dao;
import jxau.sms.qing.po.Student;
import jxau.sms.qing.po.Teacher;

/**
 * 医保的业务逻辑类
 * 
 * @author anping 2014-4-14 TODO
 */
@Service("yiBaoService")
@Transactional(propagation=Propagation.REQUIRED)
public class YiBaoServiceImpl implements YiBaoService {

	@Resource(name = "dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	/**
	 * 学生查询自己的医保申请情况的时候不使用分页 那么就需要学生传入studentNo以及 状态
	 */
	@Transactional(readOnly=true)
	@Override
	public <T> List<T> searchListByAccurate(Map<String, Object> param,
			int status) {
		// 核对参数是否合法
		if (param == null) {
			throw new ParameterNotMatchException("需要提供学号来查询");
		} else {
			if (!param.containsKey("studentNo")) {
				throw new ParameterNotMatchException("需要提供学号来查询");
			}

			Set<String> keys = param.keySet();
			for (String key : keys) {
				if (!key.equals("studentNo") && !key.equals("hosState")) {
					throw new ParameterNotMatchException(key + "查询条件不支持");
				}
			}

		}

		// 核对参数类型是否合法
		if (!this.checkParamterTypeIsError(param)) {
			throw new ParamterTypeErrorException(this.paramterTypeError);
		}

		return dao.select(namespace + "findYiBaoByStudentNo", param);
	}

	/**
	 * 这个用于id 的查询
	 */
	@Transactional(readOnly=true)
	@Override
	public <T> T searchByAccurate(Map<String, Object> param, int status) {
		if (param == null) {
			throw new ParameterNotMatchException("需要提供编号来查询");
		} else {
			if (!param.containsKey("hosNo")) {
				throw new ParameterNotMatchException("需要提供编号来查询");
			}

			Set<String> keys = param.keySet();
			for (String key : keys) {
				if (!key.equals("hosNo") && !key.equals("hosState")) {
					throw new ParameterNotMatchException(key + "查询条件不支持");
				}
			}

		}

		// 核对参数类型是否合法
		if (!this.checkParamterTypeIsError(param)) {
			throw new ParamterTypeErrorException(this.paramterTypeError);
		}
		return dao.selectOne(namespace + "findYiBaoById", param);
	}

	/**
	 * 传入各种条件，然后我做判断并且取到相应的数据 这里涉及的查询有　　校级工作人员通过各种条件去查询信息 　　　　　　　　　 需要传入的参数格式为
	 * HashMap<String,Object> <college,'江西农大'> <className,'1102'>
	 * <studentName,'熊安平'> <fristIndex,0> <max,100>
	 */
	@SuppressWarnings("hiding")
	@Override
	@Transactional(readOnly=true)
	public <HosInsuranceInfo> List<HosInsuranceInfo> searchByAccurate(
			Map<String, Object> param, PageVo pageVo, int status) {
		if (param == null) {
			// 如果条件为空的话，我以分页的形式查询出数据
			param = new HashMap<String, Object>(2);
		} else {
			// 如果是有的话，开始扫描条件是否符合规范
			List<String> queryCondition = new ArrayList<String>(4);
			queryCondition.add("hosState");
			queryCondition.add("college");
			queryCondition.add("className");
			queryCondition.add("studentName");
			queryCondition.add("studentNo");
			Set<String> keys = param.keySet();

			for (String key : keys) {
				if (!queryCondition.contains(key)) {
					throw new ParameterNotMatchException(key + "你需要查询的条件不支持");
				}
			}
		}
		// 核对参数类型是否合法
		if (!this.checkParamterTypeIsError(param)) {
			throw new ParamterTypeErrorException(this.paramterTypeError);
		}
		param.put("firstIndex", pageVo.getFirstIndex());
		param.put("size", pageVo.getSize());
		List<HosInsuranceInfo> hoss = dao.select(namespace
				+ "findYiBaoByCondition", param);
		long totalCount = dao.selectOne(namespace + "findYiBaoByConditionNum",
				param);
		pageVo.setCount(totalCount);
		return hoss;
	}

	/**
	 * 添加医保，主要使用在申请医保,在这里需要判断数据是否已经为空和时间差
	 */
	@SuppressWarnings("hiding")
	@Override
	public <HosInsuranceInfo> int add(Class HosInsuranceInfo, Object object) {
		if (HosInsuranceInfo instanceof Object) {

			jxau.sms.anping.po.HosInsuranceInfo data = (jxau.sms.anping.po.HosInsuranceInfo) object;
             //判断是否有数据为null,有null则报错
			if (data.getBankcardID() == null || data.getHosType() == null
					|| data.getHospitalAddress() == null
					|| data.getHospitalDate() == null
					|| data.getLeaveDate() == null
					|| data.getConditon() == null || data.getCost() == 0
					||data.getStudent()==null 
					||data.getStudent().getTelephone()==null
					) {
               throw   new ParameterNotMatchException("添加的医保信息部分不能为空，请认真重新填写！");
			}
         
			//判断添加的数据是否合法，如入院时间不应该大于出院时间
			
			if(data.getHospitalDate().after(data.getLeaveDate())){
				 throw   new ParameterNotMatchException("添加的医保信息入院时间不能比出院时间和晚！");
			}
		 
			if(data.getLeaveDate().after(new Date())){
				throw new ParameterNotMatchException("出院时间大于今天？");
			}
			data.setHosDate((int)(data.getLeaveDate().getTime()-data.getHospitalDate().getTime())/(24*60*60*1000));
			dao.add(namespace + "applyYiBao", object);
		}
		return 0;
	}

	/**
	 * 　需要在权限模块中拦截这个请求，因为需要知道这个老师有没有这个权利
	 * 录入是否受理结果传入<"modifyAcceptOrNotResult",HosInsuranceInfo>
	 * 录入以报销名单<"modifyReimburseStudent",HosInsuranceInfo>
	 * 　录入商业保险　　　　　　modifyCompany
	 */
	@Override
	public int updateYiBaoByThreeWay(
			Map<String, List<jxau.sms.anping.po.HosInsuranceInfo>> params) {
		if (params.containsKey("modifyAcceptOrNotResult")) {
			dao.batchUpdate(namespace + "modifyAcceptOrNotResult",
					params.get("modifyAcceptOrNotResult"));
		}

		else if (params.containsKey("modifyReimburseStudent")) {
			dao.batchUpdate(namespace + "modifyReimburseStudent",
					params.get("modifyAcceptOrNotResult"));

		} else if (params.containsKey("modifyCompany")) {
			dao.batchUpdate(namespace + "modifyCompany",
					params.get("modifyAcceptOrNotResult"));
		}

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

	private boolean checkParamterTypeIsError(Map<String, Object> param) {
		boolean result = true;
		Set<String> keys = param.keySet();
		for (String key : keys) {
			Object data = param.get(key);
			if (key.equals("hosNo")) {
				if (!(data instanceof Integer)) {
					result = false;
				}
			} else {
				if (!(data instanceof String)) {
					result = false;
				}
			}
		}
		return result;

	}
	

	
	/**
	 * 需要判断这个学生修改的医保是不是修改了自己的
	 */
	@Override
	public int updateYiBaoByStudent(StuBasicInfo student,
			jxau.sms.anping.po.HosInsuranceInfo data) {
		Map<String,Object>  params = new HashMap<String,Object>(1);
		params.put("hosNo", student.getStudentNo());
	    HosInsuranceInfo  info  = dao.selectOne("findYiBaoById", params);
		
	    if(!info.getStudent().getStudentNo().equals(student.getStudentNo())){
	    	throw new AccessOrUpdateErrorException("你没有权限修改");
	    }
	    
	    //检测是不是已经状态变成已审核
        if(info.getHosState().equals("通过")){
        	throw new AccessOrUpdateErrorException("已通过，不能修改！");
	    }
	    //检测合法性
	    if (data.getBankcardID() == null || data.getHosType() == null
				|| data.getHospitalAddress() == null
				|| data.getHospitalDate() == null
				|| data.getLeaveDate() == null
				|| data.getConditon() == null || data.getCost() == 0
				
				) {
           throw   new ParameterNotMatchException("添加的医保信息部分不能为空，请认真重新填写！");
		}
     
		//判断添加的数据是否合法，如入院时间不应该大于出院时间
		
		if(data.getHospitalDate().after(data.getLeaveDate())){
			 throw   new ParameterNotMatchException("添加的医保信息入院时间不能比出院时间和晚！");
		}
	 
		if(data.getLeaveDate().after(new Date())){
			throw new ParameterNotMatchException("出院时间大于今天？");
		}
		data.setHosDate((int)(data.getLeaveDate().getTime()-data.getHospitalDate().getTime())/(24*60*60*1000));
	    
		dao.update(namespace+"modifYiBaoByStudent", data);
	    return 0;
	}
	
	

	private String namespace = "jxau.sms.anping.yibao.dao.";
	private String paramterTypeError = "参数类型不正确，正确如：hosNo->int;(studentNo,studentName,hosState,college,className)->String;";
	private Dao dao;
	

}
