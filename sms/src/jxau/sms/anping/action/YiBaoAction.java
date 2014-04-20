package jxau.sms.anping.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jxau.sms.abstration.AbstractionService;
import jxau.sms.anping.exception.AccessOrUpdateErrorException;
import jxau.sms.anping.exception.ParameterNotMatchException;
import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.service.YiBaoService;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.commom.vo.PageVo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("yiBaoAction")
@Scope("prototype")
public class YiBaoAction extends ActionSupport implements
		ModelDriven<HosInsuranceInfo> {

	/**
	 * 录入医保结果
	 * anping
	 * TODO
	 * 下午1:20:10
	 * @return
	 */
	public String updateHoss(){
		return null;
	}
	
	/**
	 * 审核医保
	 * anping
	 * TODO接收的参数有如下的isYesOrNot，是过还是不过
	 * hosNo 
	 * stateRemark+hosNo
	 * 下午9:00:00
	 * @return
	 */
	public String checkHosByTeacher(){
		
	    String[] isYesOrNo = (String[])parameters.get("isYesOrNot");
	   
	    System.out.println(isYesOrNo);
	    Set<String> keys  = parameters.keySet();
	  //拿到所有装有hosNo  的key 
	   
	    List<String>  ids = new ArrayList(6);
	    List<String>  params = new ArrayList(6);
	    for(String key:keys){ 
	    	if(key.indexOf("hosNo")==0){
	    		String[] hosNos  =(String[]) parameters.get(key); 
	    		String[] stateRemark = (String[])parameters.get("stateRemark"+hosNos[0]);
	    		ids.add(hosNos[0]);
	    		params.add(stateRemark[0]);
	    	}
	    }
	    
	    
	    
	    AbstractionService  service = (AbstractionService)yiBaoService;
	    
	    service.verify(ids, "11", "4", isYesOrNo[0].equals("1")?"1":"2", params);
	     
	   
	    
	    
		return "check";
	}
	
	
	
	/**
	 * 校级工作人员查询出所有的学生医保信息
	 * anping
	 * TODO
	 * 上午9:06:42
	 * @return
	 */
	public String getAllHosByTeacher(){
		String result="teacherShowHoss";
		PageVo  pageVo  = new PageVo();
		String[] currentPages = (String[]) parameters.get("currentPage");
		String[] hostates = (String[]) parameters.get("hosState");
 
		Map<String,Object> params = null;
		if(hostates!=null&&hostates[0]!=null){
			String hostate = null;
			try {
				hostate=URLDecoder.decode(URLDecoder.decode(hostates[0], "utf-8"),"utf-8");
				 if(hostate.equals("校级审核中")){
					result = "apply";
				}
			} catch (UnsupportedEncodingException e) {
				 e.printStackTrace();
			}
			params= new HashMap<String,Object>();
			params.put("hosState", hostate);
		}
		pageVo.setCurrentPage(currentPages==null?0:Integer.parseInt(currentPages[0]));
		pageVo.setSize(6);
		List<HosInsuranceInfo> hoss=null;
		try {
			hoss = yiBaoService.searchByAccurate(params, pageVo, -1);
			//将数据发给前台去
			
			request.put("pageVo",pageVo);
			request.put("hoss", hoss);
			
		} catch (Exception e) {
			e.printStackTrace();
			result=ERROR;
		}
		
		
		return result;
	}
	
	
	/**
	 * 学生修改自己的医保信息 anping TODO 下午11:39:39
	 * 
	 * @return
	 */
	public String modifyStu() {
		this.print();
		String result = "applyYiBaoAndModify";
		String[] types = (String[]) parameters.get("type");
	 
		if (types != null && types[0].equals("show")
				&& hosInsuranceInfo.getHosNo() > 0) {
			Map<String, Object> param = new HashMap<String, Object>(1);
			param.put("hosNo", hosInsuranceInfo.getHosNo());
			HosInsuranceInfo hos = yiBaoService.searchByAccurate(param, -1);
			request.put("hos", hos);
			result = "modify";
		} else {
			StuBasicInfo student = (StuBasicInfo) session.get("student");
			hosInsuranceInfo.setStudent(student);

			try {
				this.yiBaoService.updateYiBaoByStudent(student,
						hosInsuranceInfo);
			} catch (ParameterNotMatchException e) {
				e.printStackTrace();
				result = ERROR;
			}catch(AccessOrUpdateErrorException e){
				e.printStackTrace();
				result = ERROR;
			}
		}

		return result;
	}

	/**
	 * 学生自己查看医保，取出所有的信息，不管是审核通过的还是审核不通过的 anping TODO 下午3:11:49
	 * 
	 * @return
	 */
	public String showYiBaoForStudent() {
		StuBasicInfo student = (StuBasicInfo) session.get("student");
		Map<String, Object> param = new HashMap<String, Object>(1);
		param.put("studentNo", student.getStudentNo());
		List<HosInsuranceInfo> hoss = yiBaoService.searchListByAccurate(param,
				-1);
		request.put("hoss", hoss);
		return SUCCESS;
	}

	/**
	 * 申请医保 anping TODO 下午3:10:58
	 * 
	 * @return
	 */
	public String applyYiBao() {

		String result = "applyYiBaoAndModify";
		this.print();
		StuBasicInfo student = (StuBasicInfo) session.get("student");
		hosInsuranceInfo.setStudent(student);
		try {
			this.yiBaoService.add(HosInsuranceInfo.class, hosInsuranceInfo);
		} catch (ParameterNotMatchException e) {
			e.printStackTrace();
			result = ERROR;
		}
		return result;
	}

	private void print() {
		System.out.println(hosInsuranceInfo.getConditon());
		System.out.println(hosInsuranceInfo.getHosType());
		System.out.println(hosInsuranceInfo.getHospitalAddress());
		System.out.println(hosInsuranceInfo.getLocalCity());
		System.out.println(hosInsuranceInfo.getCost());
		System.out.println(hosInsuranceInfo.getHospitalDate());
		System.out.println(hosInsuranceInfo.getLeaveDate());
		System.out.println(telephone + "-----电话号码----");
		System.out.println(hosInsuranceInfo.getHosNo() + "-----------no");

	}

	@Resource(name = "yiBaoService")
	public void setYiBaoService(YiBaoService yiBaoService) {
		this.yiBaoService = yiBaoService;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public HosInsuranceInfo getModel() {
		return hosInsuranceInfo;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}
	
	
	
 

	 




 
	private String ErrorMsg;
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
	// 获取strtus2的request
	@SuppressWarnings("unchecked")
	private Map<String, Object> request = (Map<String, Object>) ActionContext
			.getContext().get("request");
	// 获取strtus2 的参数
	private Map<String, Object> parameters = ActionContext.getContext()
			.getParameters();
	private HosInsuranceInfo hosInsuranceInfo = new HosInsuranceInfo();
	private String telephone;
	private YiBaoService yiBaoService;
	
	private static final long serialVersionUID = 1L;
}
