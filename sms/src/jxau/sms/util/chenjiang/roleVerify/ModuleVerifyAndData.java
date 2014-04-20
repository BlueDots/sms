package jxau.sms.util.chenjiang.roleVerify;

public class ModuleVerifyAndData {
	public ModuleVerify getModuleVerify() {
		return moduleVerify;
	}
	public String getExameState() {
		return exameState;
	}
	public String getRemark() {
		return remark;
	}
	public Object getId() {
		return id;
	}
	public void setModuleVerify(ModuleVerify moduleVerify) {
		this.moduleVerify = moduleVerify;
	}
	public void setExameState(String exameState) {
		this.exameState = exameState;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setId(Object id) {
		this.id = id;
	}
	private ModuleVerify moduleVerify;
	private String exameState;
	private String remark;
	private Object id;
}
