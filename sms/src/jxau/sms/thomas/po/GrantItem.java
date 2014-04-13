/**
* @package_name   com.stuManSys.grantInfo.po
* @file_name GrantInfo.java
* @author Administrator
* @date 2014-3-2
*/

package jxau.sms.thomas.po;

import java.util.Date;


/** 
 * @ClassName: GrantInfo
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class GrantItem {

	private int grantNo;
	private String activityName;
	private Date createTime;
	private String grantProperty;
	private int grantMoney;
	private String remarks;
	private int grantState;
	
	public int getGrantNo() {
		return grantNo;
	}
	public void setGrantNo(int grantNo) {
		this.grantNo = grantNo;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getGrantProperty() {
		return grantProperty;
	}
	public void setGrantProperty(String grantProperty) {
		this.grantProperty = grantProperty;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getGrantState() {
		return grantState;
	}
	public void setGrantState(int grantState) {
		this.grantState = grantState;
	}
	public int getGrantMoney() {
		return grantMoney;
	}
	public void setGrantMoney(int grantMoney) {
		this.grantMoney = grantMoney;
	}
}
