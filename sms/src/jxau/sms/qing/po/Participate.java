package jxau.sms.qing.po;

public class Participate {
	private String studnetNo;
	private String studentPost;    //学生干部职务
	private String workingTime;    //干部任职时间
	private String activityName;  //活动项目名称
	private String activityRating;   //获奖等级
	public String getStudnetNo() {
		return studnetNo;
	}
	public void setStudnetNo(String studnetNo) {
		this.studnetNo = studnetNo;
	}
	public String getStudentPost() {
		return studentPost;
	}
	public void setStudentPost(String studentPost) {
		this.studentPost = studentPost;
	}
	public String getWorkingTime() {
		return workingTime;
	}
	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityRating() {
		return activityRating;
	}
	public void setActivityRating(String activityRating) {
		this.activityRating = activityRating;
	}

}
