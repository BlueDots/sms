package jxau.sms.chenjiang.stuActParticipate.vo;

import java.util.Date;




public class StuActParticipateVO {
	private String activityLevel;
	private String activityName;
	private String activityRating;
	private String activityType;
	private Date awardTime;
	private String className;
	private String college;
	private String exameState;
	private int id;
	private String major;
	private String remarks;
	private int sessionYear;
	private int sex;
	private int stuActState;//学生参与活动状态
	private String studentName;
	private String studentNo;
	private String studentPost;
	private int stuState;//学生状态
	private Date workingTime;
	public String getActivityLevel() {
		return activityLevel;
	}

	public String getActivityName() {
		return activityName;
	}
	
	public String getActivityRating() {
		return activityRating;
	}

	public String getActivityType() {
		return activityType;
	}





	public Date getAwardTime() {
		return awardTime;
	}
	public String getClassName() {
		return className;
	}
	

	public String getCollege() {
		return college;
	}

	public String getExameState() {
		return exameState;
	}

	public int getId() {
		return id;
	}

	public String getMajor() {
		return major;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getSessionYear() {
		return sessionYear;
	}

	public int getSex() {
		return sex;
	}

	public int getStuActState() {
		return stuActState;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public String getStudentPost() {
		return studentPost;
	}

	public int getStuState() {
		return stuState;
	}

	public Date getWorkingTime() {
		return workingTime;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public void setActivityRating(String activityRating) {
		this.activityRating = activityRating;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}


	public void setAwardTime(Date awardTime) {
		this.awardTime = awardTime;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void setExameState(String exameState) {
		this.exameState = exameState;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setSessionYear(int sessionYear) {
		this.sessionYear = sessionYear;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public void setStuActState(int stuActState) {
		this.stuActState = stuActState;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public void setStudentPost(String studentPost) {
		this.studentPost = studentPost;
	}
	public void setStuState(int stuState) {
		this.stuState = stuState;
	}
	public void setWorkingTime(Date workingTime) {
		this.workingTime = workingTime;
	}
	
	public String toString() {
		return "id:"+id+",studentNo:"+studentNo+",studentName:"+studentName+
				",major:"+major+",sex:"+sex+",college:"+college+",className:"+className+",activityName:"+activityName+
				",sessionYear:"+sessionYear+",awardTime:"+awardTime+",activityType:"+activityType+
				",activityLevel:"+activityLevel+",activityRating:"+activityRating+",studentPost:"+studentPost+
				",workingTime:"+workingTime+
				",exameState:"+exameState+",remarks:"+remarks+",stuState:"+stuState+
				",stuActState:"+stuActState;
	}
	
	
}
