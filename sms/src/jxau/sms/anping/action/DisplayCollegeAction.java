package jxau.sms.anping.action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
import jxau.sms.anping.po.DepInfo;
=======
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxau.sms.anping.po.DepInfo;
import jxau.sms.lyx.po.RoleInfo;
>>>>>>> d08e56d422cf81608214957a84ec753a0f002fdb

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

<<<<<<< HEAD
=======
@Controller("displayCollegeAction")
@Scope("prototype")
>>>>>>> d08e56d422cf81608214957a84ec753a0f002fdb
public class DisplayCollegeAction extends ActionSupport{

	/**
	 * 需要从session中拿出数据，显示的是它最大的角色，并拿出相应的数据
	 * 如最大的角色是班主任，则显示的应该是所教院，所交方向，所交班
	 * 如果最大的角色是院级工作人员是拿出所在院，所在方向，所在班
	 * 如果是校级，则全部显示
	 * anping
	 * TODO
	 * 上午9:34:35
	 * @return
	 */
	public String showCollege(){
<<<<<<< HEAD
=======
		
		@SuppressWarnings("unchecked")
		List<RoleInfo> roles = (List<RoleInfo>) session.get("roles");
		
		
		
>>>>>>> d08e56d422cf81608214957a84ec753a0f002fdb
		for(int i =0 ;i<10;i++){
			DepInfo  depInfo  = new DepInfo();
			depInfo.setDepNum(1);
			depInfo.setDepartInfo("aaa");
			depInfo.setDepartNo("1");
			depInfo.setDepartment("aaaa");
			depInfos.add(depInfo);
		}
		return SUCCESS;
	}
	
	
	
	public List<DepInfo> getDepInfos() {
		return depInfos;
	}
	private List<DepInfo>  depInfos=new LinkedList<DepInfo>() ;
	private Map<String,Object> session  = ActionContext.getContext().getSession();
	private Map<String,Object> params = ActionContext.getContext().getParameters();
	private static final long serialVersionUID = 1L;
	
}
