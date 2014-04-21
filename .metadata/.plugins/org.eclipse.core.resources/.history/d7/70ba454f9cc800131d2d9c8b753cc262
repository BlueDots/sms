package jxau.sms.lyx.allocationRole.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.allocationRole.service.impl.AllocationRoleServiceImpl;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.role.service.impl.RoleServiceImpl;
import jxau.sms.lyx.vo.VTeacherRole;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller  
@Scope("prototype")
public class AllocationRoleAction extends ActionSupport implements ModelDriven<PageVo>{

	private static final long serialVersionUID = 1L;

	private PageVo pageVo = new PageVo();
	private AllocationRoleServiceImpl allocationRoleServiceImpl;
	private List<VTeacherRole> vteacherRoleList = new ArrayList<VTeacherRole>();
	private RoleServiceImpl roleServiceImpl;
	private List<RoleInfo> roleInfoList = new ArrayList<RoleInfo>();
	
	public List<RoleInfo> getRoleInfoList() {
		return roleInfoList;
	}
	public void setRoleInfoList(List<RoleInfo> roleInfoList) {
		this.roleInfoList = roleInfoList;
	}

	@Resource(name="AllocationRoleServiceImpl")
	public void setAllocationRoleServiceImpl(
			AllocationRoleServiceImpl allocationRoleServiceImpl) {
		this.allocationRoleServiceImpl = allocationRoleServiceImpl;
	}

	@Resource(name="RoleServiceImpl")
	public void setRoleServiceImpl(RoleServiceImpl roleServiceImpl) {
		this.roleServiceImpl = roleServiceImpl;
	}


	public List<VTeacherRole> getVteacherRoleList() {
		return vteacherRoleList;
	}
	public void setVteacherRoleList(List<VTeacherRole> vteacherRoleList) {
		this.vteacherRoleList = vteacherRoleList;
	}


	public String tecRoleDisplay() throws Exception{

		String teacherNo = ServletActionContext.getRequest().getParameter("teacherNo");
		String teacherName = ServletActionContext.getRequest().getParameter("teacherName");

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teacherNo", teacherNo);
		map.put("teacherName", teacherName);
		
		pageVo.setSize(4);
		List<VTeacherRole> vTeacherRole = allocationRoleServiceImpl.searchByAccurate(map, pageVo, 0);
		this.setVteacherRoleList(vTeacherRole);
		
		PageVo page = new PageVo();
		List<RoleInfo> roleInfo = roleServiceImpl.searchByAccurate(null,page,0);
		this.setRoleInfoList(roleInfo);

		return SUCCESS;
	}
	
	public String showPurviewByRoleNo() throws Exception{
		
		String roleName = ServletActionContext.getRequest().getParameter("roleName");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleName", roleName);
		List<RoleInfo> roleInfos = new ArrayList<RoleInfo>();
		roleInfos = roleServiceImpl.searchListByAccurate(map,0);
		int roleNo = roleInfos.get(0).getRoleNo();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("tecRoleNo", roleNo);
		
		return SUCCESS;
	}

	@Override
	public PageVo getModel() {
		// TODO Auto-generated method stub
		return pageVo;
	}

	
}
