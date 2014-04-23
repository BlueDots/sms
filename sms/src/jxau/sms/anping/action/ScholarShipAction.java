package jxau.sms.anping.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.anping.po.ScholarShip;
import jxau.sms.anping.service.ScholarShipService;
import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.qing.po.Teacher;
import jxau.sms.util.service.impl.CollegeMajorClassInterface;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScholarShipAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 显示所有的班级奖学金信息 通过教师的角色来获取信息:像班主任只能显示本班的学生信息 　　　　　　　　　　　　像校级工作人员需要显示所有的最前的数据
	 * 像院级工作人员也是显示本院的数据 anping TODO 下午6:58:09
	 * 
	 * @return
	 */
	public String showSchloarShipForTeacher() {
		String result = SUCCESS;
		String[] deparments = (String[]) parameters.get("department");
		String[] major = (String[]) parameters.get("major");
		String[] className = (String[]) parameters.get("className");
		String[] student = (String[]) parameters.get("student");
		String[] terms = (String[]) parameters.get("term");
		String[] currentPages  = (String[])parameters.get("currentPage");
		int currentPage;
		Map<String, Object> params = new HashMap<String, Object>(6);

		if (deparments != null && deparments[0] != null) {
			params.put("college", deparments[0]);
		}

		if (major != null && major[0] != null) {
			params.put("major", major[0]);
		}

		if (className != null && className[0] != null) {
			params.put("className", className[0]);
		}

		if (student != null && student[0] != null) {
			try {
				Integer.parseInt(student[0]);
				params.put("studentNo", student[0]);
			} catch (NumberFormatException e) {
				params.put("studentName", student[0]);
			}
		}

		if (terms != null && terms[0] != null) {
			params.put("term", terms[0]);
		}
		if(currentPages==null||currentPages[0]==null){
			currentPage=1;
		}else{
			currentPage = Integer.parseInt(currentPages[0]);
		}

		PageVo pageVo = new PageVo();
		pageVo.setCurrentPage(currentPage);
		pageVo.setCount(6);
		List<ScholarShip> scholars=null;
		try {
			 scholars= scholarShipService.Search(params, pageVo, 0);
		} catch (Exception e) {
			 request.put("error",e.getMessage() );
		}
		request.put("scholars", scholars);
		request.put("pageVo",pageVo );
		request.put("params", params);
		return result;
	}

	@Resource(name = "scholarShip")
	public void setScholarShipService(ScholarShipService scholarShipService) {
		this.scholarShipService = scholarShipService;
	}

	@Resource(name = "collegeMajorClassServiceImpl")
	public void setClassMajor(CollegeMajorClassInterface classMajor) {
		this.classMajor = classMajor;
	}

	private Map<String, Object> request = (Map<String, Object>) ActionContext
			.getContext().get("request");
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	private ScholarShipService scholarShipService;
	private CollegeMajorClassInterface classMajor;
	private Map<String, Object> parameters = ActionContext.getContext()
			.getParameters();

}
