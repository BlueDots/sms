package jxau.sms.anping.po;

import java.util.Date;

public class ClassInfo {
	private String classNo;// 班级编号
	private String className;// 班级名称
	private String classShort;// 班级的简称
	private MajorInfo majorInfo;// 专业
	private int num;// 班级人数
	private int girlNum;// 女生人数
	private Date schoolDate;// 入学时间
	private int study;// 学年制
	private int state;// 班级状态

	public String toString() {
		return "classNo:"+classNo+",className:"+className+",classShort:"+classShort
				+"\nmajorInfo:"+majorInfo;
	}
	
	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassShort() {
		return classShort;
	}

	public void setClassShort(String classShort) {
		this.classShort = classShort;
	}

	public MajorInfo getMajorInfo() {
		return majorInfo;
	}

	public void setMajorInfo(MajorInfo majorInfo) {
		this.majorInfo = majorInfo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getGirlNum() {
		return girlNum;
	}

	public void setGirlNum(int girlNum) {
		this.girlNum = girlNum;
	}

	public Date getSchoolDate() {
		return schoolDate;
	}

	public void setSchoolDate(Date schoolDate) {
		this.schoolDate = schoolDate;
	}

	public int getStudy() {
		return study;
	}

	public void setStudy(int study) {
		this.study = study;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
