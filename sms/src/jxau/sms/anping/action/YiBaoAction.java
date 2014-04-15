package jxau.sms.anping.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jxau.sms.anping.po.HosInsuranceInfo;
import jxau.sms.anping.service.YiBaoService;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.qing.po.Student;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("yiBaoAction")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED)
public class YiBaoAction extends ActionSupport implements ModelDriven<HosInsuranceInfo>{

	
    
	public  String applyYiBao(){
		
	    this.print();
	    StuBasicInfo  student = new StuBasicInfo();
	    student.setStudentNo("20111429");
	    
	    student.setTelephone("18272737");
	    hosInsuranceInfo.setStudent(student);
	    try {
			this.yiBaoService.add(HosInsuranceInfo.class, hosInsuranceInfo);
		} catch (Exception e) {
			 e.printStackTrace();
			 return ERROR;
		}
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
   
	
	private HosInsuranceInfo hosInsuranceInfo=new HosInsuranceInfo();
	private String telephone;
	private YiBaoService yiBaoService;
	private static final long serialVersionUID = 1L;
}
