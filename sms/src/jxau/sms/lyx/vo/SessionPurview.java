package jxau.sms.lyx.vo;

import java.util.List;

import jxau.sms.lyx.po.PurviewInfo;

/**
 * 
 * @author lyx
 * 2014-4-21
 * TODO:
 * 	登陆后session中保存的对象，一般用于权限验证
 */
public class SessionPurview {

	private String roleName;    			//登陆者角色名称
	private int roleNo;						//登陆者角色编号
	private List<PurviewInfo> purviewInfo;  //登陆者全部权限信息
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(int roleNo) {
		this.roleNo = roleNo;
	}
	public List<PurviewInfo> getPurviewInfo() {
		return purviewInfo;
	}
	public void setPurviewInfo(List<PurviewInfo> purviewInfo) {
		this.purviewInfo = purviewInfo;
	}
	
}
