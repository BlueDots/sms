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
import jxau.sms.lyx.po.PurviewInfo;
import jxau.sms.lyx.po.RoleInfo;
import jxau.sms.lyx.purview.service.impl.SystemPurviewServiceImpl;
import jxau.sms.lyx.role.service.impl.RoleServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller  
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<PageVo>{

	private static final long serialVersionUID = 1L;

	private PageVo pageVo = new PageVo();
	
	private RoleServiceImpl roleServiceImpl;
	private SystemPurviewServiceImpl systemPurviewServiceImpl;
	private List<PurviewInfo> purviewList = new ArrayList<PurviewInfo>();
	
	@Resource(name="SystemPurviewServiceImpl")
	public void setSystemPurviewServiceImpl(
			SystemPurviewServiceImpl systemPurviewServiceImpl) {
		this.systemPurviewServiceImpl = systemPurviewServiceImpl;
	}

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

	public List<PurviewInfo> getPurviewList() {
		return purviewList;
	}

	public void setPurviewList(List<PurviewInfo> purviewList) {
		this.purviewList = purviewList;
	}

	/**
	 * 
	 * lyx
	 * TODO:根据角色名称查询
	 * 下午7:12:00
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 
	 * lyx
	 * TODO:角色列表显示
	 * 下午7:12:33
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 
	 * lyx
	 * TODO:权限树状显示
	 * 下午7:12:46
	 * @return
	 * @throws Exception
	 */
	public String PurviewDisplay() throws Exception{
		
		List<PurviewInfo> purviewList = systemPurviewServiceImpl.searchListByAccurate(null, 0);
		this.setPurviewList(purviewList);
		return SUCCESS;
	}
	
	/**
	 * 
	 * lyx
	 * TODO: 保存角色信息与初始化权限
	 * 下午7:17:35
	 * @return
	 * @throws Exception
	 */
	public String addRole() throws Exception{
		
		String param = ServletActionContext.getRequest().getParameter("array");
		String roleName = ServletActionContext.getRequest().getParameter("roleName");
		String roleDescription = ServletActionContext.getRequest().getParameter("roleDescription");	
		roleServiceImpl.insertRoleInfoPurview(roleName,roleDescription,param);
		return SUCCESS;
	}
	

	@Override
	public PageVo getModel() {
		// TODO Auto-generated method stub
		return pageVo;
	}
	
}
