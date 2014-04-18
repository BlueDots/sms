package jxau.sms.anping.action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.sms.anping.po.ClassInfo;
import jxau.sms.anping.po.DepInfo;
import jxau.sms.anping.po.MajorInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxau.sms.anping.po.DepInfo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.util.service.impl.CollegeMajorClassInterface;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("displayCollegeAction")
@Scope("prototype")
public class DisplayCollegeAction extends ActionSupport {

	/**
	 * 需要从session中拿出数据，显示的是它最大的角色，并拿出相应的数据 如最大的角色是班主任，则显示的应该是所教院，所交方向，所交班
	 * 如果最大的角色是院级工作人员是拿出所在院，所在方向，所在班 如果是校级，则全部显示 anping TODO 上午9:34:35
	 * 
	 * @return
	 */
	public String showCollege() {

		TecBasicInfo teacher = (TecBasicInfo) session.get("teacher");
		@SuppressWarnings("unchecked")
		List<RoleInfo> roles = (List<RoleInfo>) session.get("roles");
		// 拿到参数为　主要用来判断是拿取学院还是方向还是班级type 的数据
		String[] type = (String[]) params.get("type");
		String[] departNo = (String[]) params.get("departNo");
		String[] majorNo = (String[]) params.get("majorNo");
		if (type != null) {
			switch (type[0]) {
			case "depart": {
				depInfos = collegeService
						.searchCollegeByTeacher(teacher, roles);
			}
				break;
			case "major": {
				if (departNo != null && departNo[0] != null) {
					majors = collegeService.searchMajorByTeacher(teacher,
							roles, departNo[0]);
				}
			}
				break;
			case "class": {
				classInfos = collegeService.searchClassByTeacher(teacher,
						roles, departNo==null?null:departNo[0], majorNo==null?null:majorNo[0]);
				System.out.println(classInfos.size()+"-----------");
			}
				break;
			}
		}
		return SUCCESS;
	}

	@Resource(name = "collegeMajorClassServiceImpl")
	public void setCollegeService(CollegeMajorClassInterface collegeService) {
		this.collegeService = collegeService;
	}

	public List<DepInfo> getDepInfos() {
		return depInfos;
	}

	public List<MajorInfo> getMajors() {
		return majors;
	}

	public List<ClassInfo> getClassInfos() {
		return classInfos;
	}

	private List<DepInfo> depInfos = new LinkedList<DepInfo>();
	private List<MajorInfo> majors = new LinkedList<MajorInfo>();
	private List<ClassInfo> classInfos = new LinkedList<ClassInfo>();
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
	private Map<String, Object> params = ActionContext.getContext()
			.getParameters();
	private static final long serialVersionUID = 1L;
	private CollegeMajorClassInterface collegeService;

}
