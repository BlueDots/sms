package jxau.sms.lyx.TeacherInfo.po;

import java.util.Date;

/**
 * 
 * @author lyx
 * @2014-4-12
 *	@TODO:
 *		教师基本信息实体类
 *
 */
public class TecBasicInfo {

	private String teacherNo;  				//教师工号
	private String teacherName;  			//教师姓名 
	private int sex; 									//性别
	private String nation; 						//民族
	private String hometown;					//籍贯
	private String political;                     //政治面貌
	private String tecState;						//在岗状态
	private String teacherTitle;				//教师职称
	private Date titleTime;						//评定职称时间
	private Date worktime;						//入职时间
	private String eduBackground;		//学历
	private String exameState;				//审核状态
	private String remarks;						//备注
	
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getTecState() {
		return tecState;
	}
	public void setTecState(String tecState) {
		this.tecState = tecState;
	}
	public String getTeacherTitle() {
		return teacherTitle;
	}
	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}
	public Date getTitleTime() {
		return titleTime;
	}
	public void setTitleTime(Date titleTime) {
		this.titleTime = titleTime;
	}
	public Date getWorktime() {
		return worktime;
	}
	public void setWorktime(Date worktime) {
		this.worktime = worktime;
	}
	public String getEduBackground() {
		return eduBackground;
	}
	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}
	public String getExameState() {
		return exameState;
	}
	public void setExameState(String exameState) {
		this.exameState = exameState;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
