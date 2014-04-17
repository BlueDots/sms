package jxau.sms.lyx.role.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxau.sms.commom.vo.PageVo;
import jxau.sms.lyx.exception.NotFoundDataException;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.role.service.impl.RoleServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller  
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<PageVo>{

	private static final long serialVersionUID = 1L;

	private PageVo pageVo = new PageVo();
	
	private RoleServiceImpl roleServiceImpl;
	
	@Resource(name="RoleServiceImpl")
	public void setRoleServiceImpl(RoleServiceImpl roleServiceImpl) {
		this.roleServiceImpl = roleServiceImpl;
	}

	private List<RoleInfo> roleInfoList = new ArrayList<RoleInfo>();
		
	public List<RoleInfo> getRoleInfoList() {
		return roleInfoList;
	}

	public void setRoleInfoList(List<RoleInfo> roleInfoList) {
		this.roleInfoList = roleInfoList;
	}

	public String searchRole() throws Exception{
		
		String searchRole = ServletActionContext.getRequest().getParameter("searchRole");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleName", searchRole);
		List<RoleInfo> roleInfos = new ArrayList<RoleInfo>();
		try{
			roleInfos = roleServiceImpl.searchListByAccurate(map,0);
		}catch(NotFoundDataException e){
			System.out.println("没事");
		}finally{		
			this.setRoleInfoList(roleInfos);
		}
		return SUCCESS;
	}
	
	
	public String roleExecute() throws Exception{
		
		String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		pageVo.setSize(4);
		if(currentPage!=null){
			pageVo.setCurrentPage(Integer.parseInt(currentPage));
		}		
		List<RoleInfo> roleInfos = roleServiceImpl.searchByAccurate(null, pageVo, 0);	
		this.setRoleInfoList(roleInfos);
		return SUCCESS;
	}

	@Override
	public PageVo getModel() {
		// TODO Auto-generated method stub
		return pageVo;
	}
	
}
