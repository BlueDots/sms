package jxau.sms.anping.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.service.ScholarShipService;
import jxau.sms.chenjiang.po.StuBasicInfo;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
 
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScholarShipOpreation extends ActionSupport implements ModelDriven<ScholarShip>{
	

	public String updateStudentScholarShip(){
		List<ScholarShip> sss  = new ArrayList<ScholarShip>(1);
		StuBasicInfo  student  = new StuBasicInfo();
		student.setStudentNo(scholarShip.getClassGrantState());
		scholarShip.setStudent(student);
 
		sss.add(scholarShip);
		TecBasicInfo teacher = (TecBasicInfo)session.get("teacher");
		 List<RoleInfo> roleInfos= (List<RoleInfo>) session.get("roles");
		scholarShipService.updateSchloarShip(sss, teacher, roleInfos);
		
		String result  = SUCCESS;
		String error = null;
		PageVo  pagevo  = new PageVo();
		pagevo.setCurrentPage(1);
		pagevo.setSize(6);
		 List<ScholarShip> scholarShipsForadd=null;
		try {
			scholarShipsForadd=scholarShipService.searchOneClassByOneStudent(student.getStudentNo(), pagevo,scholarShip.getTerm());
		} catch (Exception e) {
			 e.printStackTrace();
			 error=e.getMessage();
			 result="error";
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("className",scholarShipsForadd.get(0).getStudent().getClassName() );
		params.put("term",scholarShip.getTerm());
		request.put("scholars", scholarShipsForadd);
		request.put("pagevo", pagevo);
		request.put("params", params);
		return SUCCESS;
	}
	@Resource(name = "scholarShip")
	public void setScholarShipService(ScholarShipService scholarShipService) {
		this.scholarShipService = scholarShipService;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScholarShip  scholarShip  =new ScholarShip();
	@Override
	public ScholarShip getModel() {
	 
		return scholarShip;
	}
	private Map<String, Object> parameters = ActionContext.getContext()
			.getParameters();
	private Map<String, Object> request = (Map<String, Object>) ActionContext
			.getContext().get("request");
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
	private ScholarShipService scholarShipService;
}
