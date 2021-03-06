package jxau.sms.thomas.vo;

import jxau.sms.commom.vo.BasicInfoVo;

public class StuGrantVo {

	private BasicInfoVo basicInfoVo;
	private String priorTerm;
	private String nextTerm;
	private String priorGrant;
	private String priPovLevel;
	private String curPovLevel;
	private String activityName;
	private String grantProperty;
	private int grantMoney;
	private String grantTime;
	private int examState;
	
	public String getNextTerm() {
		return nextTerm;
	}
	public void setNextTerm(String nextTerm) {
		this.nextTerm = nextTerm;
	}
	public String getPriorGrant() {
		return priorGrant;
	}
	public void setPriorGrant(String priorGrant) {
		this.priorGrant = priorGrant;
	}
	public String getPriPovLevel() {
		return priPovLevel;
	}
	public void setPriPovLevel(String priPovLevel) {
		this.priPovLevel = priPovLevel;
	}
	public String getCurPovLevel() {
		return curPovLevel;
	}
	public void setCurPovLevel(String curPovLevel) {
		this.curPovLevel = curPovLevel;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getGrantProperty() {
		return grantProperty;
	}
	public void setGrantProperty(String grantProperty) {
		this.grantProperty = grantProperty;
	}
	public int getGrantMoney() {
		return grantMoney;
	}
	public void setGrantMoney(int grantMoney) {
		this.grantMoney = grantMoney;
	}
	public String getGrantTime() {
		return grantTime;
	}
	public void setGrantTime(String grantTime) {
		this.grantTime = grantTime;
	}
	public int getExamState() {
		return examState;
	}
	public void setExamState(int examState) {
		this.examState = examState;
	}
	
}
