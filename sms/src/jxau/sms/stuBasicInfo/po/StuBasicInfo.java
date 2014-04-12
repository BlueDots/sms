package jxau.sms.stuBasicInfo.po;

import java.sql.Date;

/**
 * 
 * @author 江 学生基本信息
 */
public class StuBasicInfo {
	private String address;// 家庭地址
	private String bankCard;// 银行卡号
	private Date birthday;// 出生日期
	private String className;// 班级
	private String college;// 学院
	private String eduBackground;// 学历
	private String email;// 个人邮箱
	private int emailOnly;// 邮箱绑定
	private String englishlevel;// 英语等级
	private String exameState;
	private String family;// 家庭联系人
	private String fphone;// 家庭联系电话
	private String hometown;// 籍贯
	private String idCard;// 身份证号码
	private String major;// 专业方向
	private String nation;// 民族
	private String photo;// 照片
	private String political;// 政治面貌
	private String remarks;// 备注
	private int sex;// 性别
	private String studentName;// 学生姓名
	private String studentNo;// 学号
	private int stuState;
	private String telephone;// 手机号
	public String getAddress() {
		return address;
	}
	public String getBankCard() {
		return bankCard;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public String getClassName() {
		return className;
	}
	public String getCollege() {
		return college;
	}

	public String getEduBackground() {
		return eduBackground;
	}
	
	public String getEmail() {
		return email;
	}



	public int getEmailOnly() {
		return emailOnly;
	}

	public String getEnglishlevel() {
		return englishlevel;
	}

	public String getExameState() {
		return exameState;
	}

	public String getFamily() {
		return family;
	}

	public String getFphone() {
		return fphone;
	}

	public String getHometown() {
		return hometown;
	}

	public String getIdCard() {
		return idCard;
	}

	public String getMajor() {
		return major;
	}



	public String getNation() {
		return nation;
	}

	public String getPhoto() {
		return photo;
	}

	public String getPolitical() {
		return political;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getSex() {
		return sex;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public int getStuState() {
		return stuState;
	}

	public String getTelephone() {
		return telephone;
	}



	public void setAddress(String address) {
		this.address = address;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setClassName(String className) {
		this.className = className;
	}


	public void setCollege(String college) {
		this.college = college;
	}

	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmailOnly(int emailOnly) {
		this.emailOnly = emailOnly;
	}
	public void setEnglishlevel(String englishlevel) {
		this.englishlevel = englishlevel;
	}
	public void setExameState(String exameState) {
		this.exameState = exameState;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public void setStuState(int stuState) {
		this.stuState = stuState;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String toString() {
		return "studentNo:"+studentNo
				+",className:"+className+",college:"+college
				+",major:"+major+",studentName:"+studentName
				+",remarks:"+remarks+",sex:"+sex+",exameState:"+exameState
				+"stuState:"+stuState;
	}


}
