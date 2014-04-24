package jxau.sms.anping.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.service.ScholarShipService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScholarShipByAJAX extends ActionSupport{
	
	
	
	public String queryOneStudentByTermStudentNo(){
		String[] studentNos  = (String[]) paramters.get("studentNo");
		String[] terms  = (String[]) paramters.get("term");
		if(studentNos==null ||studentNos[0]==null ||terms==null ||terms[0]==null){
			message="学号不能为空";
		}else{
			try {
				scholar  = scholarShipSerivce.searchOneByTerm(studentNos[0], terms[0]);
			} catch (Exception e) {
				 e.printStackTrace();
				 message=e.getMessage();
			}
			
			
		}
		
		
		return SUCCESS;
	}
	
	/**
	 * 拿到一个人所有的信息
	 * anping
	 * TODO
	 * 下午5:27:01
	 * @return
	 */
	public String queryOneStudentSchloar(){
		
		String[] studentNos  = (String[]) paramters.get("studentNo");
		if(studentNos==null ||studentNos[0]==null){
			message="学号不能为空";
		}else{
			
			try {
				scholars=scholarShipSerivce.searchOneStudent(studentNos[0]);
			} catch (Exception e) {
				 e.printStackTrace();
				 message=e.getMessage();
			}
		}
		
		return SUCCESS;
	}
	
	
	 

	public List<ScholarShip> getScholars() {
		return scholars;
	}




	public String getMessage() {
		return message;
	}




	public ScholarShip getScholar() {
		return scholar;
	}




	@Resource(name="scholarShip")
	public void setScholarShipSerivce(ScholarShipService scholarShipSerivce) {
		this.scholarShipSerivce = scholarShipSerivce;
	}

	private ScholarShip  scholar;
	private ScholarShipService  scholarShipSerivce;
	private List<ScholarShip> scholars;
	private String message;
	
	private Map<String,Object> paramters = ActionContext.getContext().getParameters();
	
}
