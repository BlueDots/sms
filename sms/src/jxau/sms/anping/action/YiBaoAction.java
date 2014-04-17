package jxau.sms.anping.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.service.YiBaoService;
import jxau.sms.chenjiang.po.StuBasicInfo;
 

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("yiBaoAction")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED)
public class YiBaoAction extends ActionSupport implements ModelDriven<HosInsuranceInfo>{

	
    
	/**
	 * 学生自己查看医保，取出所有的信息，不管是审核通过的还是审核不通过的
	 * anping
	 * TODO
	 * 下午3:11:49
	 * @return
	 */
	public String showYiBaoForStudent(){
		StuBasicInfo  student = (StuBasicInfo) session.get("student");
		
		Map<String,Object>  param  = new HashMap<String,Object>(1);
		param.put("studentNo",student.getStudentNo());
		List<HosInsuranceInfo>  hoss =   yiBaoService.searchListByAccurate(param, -1);
		request.put("hoss",hoss);
		return SUCCESS;
	}
	
	
	/**
	 * 申请医保
	 * anping
	 * TODO
	 * 下午3:10:58
	 * @return
	 */
	public  String applyYiBao(){
		
	    this.print();
	    StuBasicInfo  student = (StuBasicInfo)session.get("student");
	    hosInsuranceInfo.setStudent(student);
	    try {
			this.yiBaoService.add(HosInsuranceInfo.class, hosInsuranceInfo);
		} catch (Exception e) {
			 e.printStackTrace();
			 return ERROR;
		}
		return SUCCESS;
	}
	 
	
	public String testSession(){
		Map<String,Object> session  =  ActionContext.getContext().getSession();
		StuBasicInfo   info  =  (StuBasicInfo) session.get("student");
		System.out.println(info.getStudentNo()); 
		return SUCCESS;
	}
	private void print(){
		System.out.println(hosInsuranceInfo.getConditon());
	    System.out.println(hosInsuranceInfo.getHosType());
	    System.out.println(hosInsuranceInfo.getHospitalAddress());
	    System.out.println(hosInsuranceInfo.getLocalCity());
	    System.out.println(hosInsuranceInfo.getCost());
	    System.out.println(hosInsuranceInfo.getHospitalDate());
	    System.out.println(hosInsuranceInfo.getLeaveDate());
	    System.out.println(telephone+"-----电话号码----");
	     
	}
	
	
	
	
	
	@Resource(name="yiBaoService")
	public void setYiBaoService(YiBaoService yiBaoService) {
		this.yiBaoService = yiBaoService;
	}

    public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
 

	@Override
	public HosInsuranceInfo getModel() {
		// TODO Auto-generated method stub
		return hosInsuranceInfo;
	}
	
	
    public String getErrorMsg() {
		return ErrorMsg;
	}


	private String ErrorMsg;
	private Map<String,Object>  session  = ActionContext.getContext().getSession();
	private Map<String,Object>  request  =(Map<String, Object>) ActionContext.getContext().get("request");
	private HosInsuranceInfo  hosInsuranceInfo=new HosInsuranceInfo();
	private String telephone;
	private YiBaoService yiBaoService;
	private static final long serialVersionUID = 1L;
}
