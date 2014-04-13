package jxau.sms.lyx.po;

import java.util.Date;

/**
 * 
 * @author lyx
 * 2014-4-12
 * TODO
 */
public class RoleInfo {

		private int roleNo;								//角色编号
		private String roleName;					//角色名称
		private Date createTime;					//创建时间
		private String roleDescription;		//	角色描述
		
		public int getRoleNo() {
			return roleNo;
		}
		public void setRoleNo(int roleNo) {
			this.roleNo = roleNo;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public String getRoleDescription() {
			return roleDescription;
		}
		public void setRoleDescription(String roleDescription) {
			this.roleDescription = roleDescription;
		}

}
