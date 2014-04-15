package jxau.sms.anping.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxau.sms.anping.po.HosInsuranceInfo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("yiBaoAction")
@Scope("prototype")
public class YiBaoAction extends ActionSupport implements ModelDriven<HosInsuranceInfo>{

	

	public  String applyYiBao(){
		
	    System.out.println(hosInsuranceInfo.getConditon());
	    System.out.println(hosInsuranceInfo.getHosType());
	    System.out.println(hosInsuranceInfo.getHospitalAddress());
	    System.out.println(hosInsuranceInfo.getLocalCity());
	    System.out.println(hosInsuranceInfo.getCost());
	    System.out.println(hosInsuranceInfo.getHospitalDate());
	    System.out.println(hosInsuranceInfo.getLeaveDate());
		return SUCCESS;
	}
	 
	
	
	
	
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	@Override
	public HosInsuranceInfo getModel() {
		// TODO Auto-generated method stub
		return hosInsuranceInfo;
	}
   
	
	private HosInsuranceInfo hosInsuranceInfo=new HosInsuranceInfo();
	private String telephone;
	private String bankCard;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
