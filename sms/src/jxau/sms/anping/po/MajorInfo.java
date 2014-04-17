package jxau.sms.anping.po;
/**
 * 专业实体表
 * @author anping
 * 2014-4-12
 * TODO  
 */
public class MajorInfo {

	private String majorNo;// 专业编号
	private String major;// 专业姓名
	private String majorShort;// 专业的简称
	private DepInfo depInfo;// 部门
	private String majorInfo;// 专业信息
	private int num;// 专业人数
	private int majorState;// 专业信息

	public String toString() {
		return "majorNo:"+majorNo+",major:"+major+",majorState:"+majorState
				+"\ndepInfo:"+depInfo;
	}
	
	public String getMajorNo() {
		return majorNo;
	}

	public void setMajorNo(String majorNo) {
		this.majorNo = majorNo;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajorShort() {
		return majorShort;
	}

	public void setMajorShort(String majorShort) {
		this.majorShort = majorShort;
	}

	public DepInfo getDepInfo() {
		return depInfo;
	}

	public void setDepInfo(DepInfo depInfo) {
		this.depInfo = depInfo;
	}

	public String getMajorInfo() {
		return majorInfo;
	}

	public void setMajorInfo(String majorInfo) {
		this.majorInfo = majorInfo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getMajorState() {
		return majorState;
	}

	public void setMajorState(int majorState) {
		this.majorState = majorState;
	}

}
