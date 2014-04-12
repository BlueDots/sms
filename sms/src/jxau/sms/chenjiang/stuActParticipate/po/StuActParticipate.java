package jxau.sms.chenjiang.stuActParticipate.po;

import java.util.Date;

import jxau.sms.chenjiang.activityManage.po.ActInfo;
import jxau.sms.chenjiang.stuBasicInfo.po.StuBasicInfo;


public class StuActParticipate {
	private String activityRating;//获奖等级
	private ActInfo actInfo;//活动编号
	private Date awardTime;//获奖时间
	private String exameState;//审核状态
	private int id;//id
	private String remarks;//备注
	private int sessionYear;//届数
	private int stuActState;//状态
	private StuBasicInfo stuBasicInfo;//学号
	private String studentPost;//学生干部职位
	private Date workingTime;//学生干部任职时间
	
	public String toString() {
		return "id:"+id+",activityRating"+activityRating+"\nactInfo:"+actInfo+"\nawardTime:"+awardTime
				+",exameState:"+exameState+",remarks"+remarks+",sessionYear:"+sessionYear+",stuActState:"+stuActState
				+"\nstuBasicInfo:"+stuBasicInfo+"\nstudentPost"+studentPost+",workingTime"+workingTime;
	}
	
	public String getActivityRating() {
		return activityRating;
	}
	public ActInfo getActInfo() {
		return actInfo;
	}
	public Date getAwardTime() {
		return awardTime;
	}
	public String getExameState() {
		return exameState;
	}
	public int getId() {
		return id;
	}
	public String getRemarks() {
		return remarks;
	}
	public int getSessionYear() {
		return sessionYear;
	}
	public int getStuActState() {
		return stuActState;
	}
	public StuBasicInfo getStuBasicInfo() {
		return stuBasicInfo;
	}
	public String getStudentPost() {
		return studentPost;
	}
	public Date getWorkingTime() {
		return workingTime;
	}
	public void setActivityRating(String activityRating) {
		this.activityRating = activityRating;
	}
	public void setActInfo(ActInfo actInfo) {
		this.actInfo = actInfo;
	}
	public void setAwardTime(Date awardTime) {
		this.awardTime = awardTime;
	}
	public void setExameState(String exameState) {
		this.exameState = exameState;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setSessionYear(int sessionYear) {
		this.sessionYear = sessionYear;
	}
	public void setStuActState(int stuActState) {
		this.stuActState = stuActState;
	}
	public void setStuBasicInfo(StuBasicInfo stuBasicInfo) {
		this.stuBasicInfo = stuBasicInfo;
	}
	public void setStudentPost(String studentPost) {
		this.studentPost = studentPost;
	}
	public void setWorkingTime(Date workingTime) {
		this.workingTime = workingTime;
	}
}
