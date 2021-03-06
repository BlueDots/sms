package jxau.sms.lyx.purview.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import jxau.sms.lyx.po.PurviewInfo;
import jxau.sms.lyx.po.TecBasicInfo;
import jxau.sms.lyx.purview.service.impl.PurviewListPackage;
import jxau.sms.lyx.purview.service.impl.SystemPurviewServiceImpl;
import jxau.sms.lyx.purview.service.impl.UserPurviewManagerServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller  
@Scope("prototype")
public class SystemPurviewAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private UserPurviewManagerServiceImpl upms;
	private SystemPurviewServiceImpl spsi;

	@Resource(name="SystemPurviewServiceImpl")
	public void setSpsi(SystemPurviewServiceImpl spsi) {
		this.spsi = spsi;
	}
	
	@Resource(name="UserPurviewManagerServiceImpl")
	public void setUpms(UserPurviewManagerServiceImpl upms) {
		this.upms = upms;
	}

	private List<PurviewInfo> purviewList = new ArrayList<PurviewInfo>();
	private List<PurviewInfo> checkList = new ArrayList<PurviewInfo>();
	String teacherNo = ServletActionContext.getRequest().getParameter("teacherNo");
	String roleNo = ServletActionContext.getRequest().getParameter("roleNo");
	String param = ServletActionContext.getRequest().getParameter("array");
	
	public List<PurviewInfo> getPurviewList() {
		return purviewList;
	}
	public void setPurviewList(List<PurviewInfo> purviewList) {
		this.purviewList = purviewList;
	}
	public List<PurviewInfo> getCheckList() {
		return checkList;
	}
	public void setCheckList(List<PurviewInfo> checkList) {
		this.checkList = checkList;
	}
	
	/**
	 * 
	 * lyx
	 * TODO:
	 * 		根据角色编号或用户编号查询权限
	 * 下午7:13:38
	 * @return
	 * @throws Exception
	 */
	public String showPurviewByCondition() throws Exception{
		
		Map<String,Object> map = new HashMap<String,Object>();
				
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String tecRoleNo = String.valueOf(request.getAttribute("tecRoleNo"));
		
		if(roleNo==null && tecRoleNo==null){

			map.put("teacherNo", teacherNo);
		}else if (roleNo==null && teacherNo==null){

			map.put("roleNo", tecRoleNo);
		}else {

			map.put("roleNo", roleNo);
		}
		
		List<PurviewInfo> purviewLists = spsi.searchListByAccurate(null, 0);
		this.setPurviewList(purviewLists);
		
		List<PurviewInfo> checkLists = upms.searchListByAccurate(map, 0);
		this.setCheckList(checkLists);
		
		return SUCCESS;
	}

}
