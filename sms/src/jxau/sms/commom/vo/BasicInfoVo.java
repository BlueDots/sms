/**
* @package_name   com.sms.common.vo
* @file_name BasicInfoVo.java
* @author Administrator
* @date 2014-4-9
*/

package jxau.sms.commom.vo;

/** 
 * @ClassName: BasicInfoVo
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class BasicInfoVo {

	private String studentNo;
	private String studentName;
	private int sex;
	private String college;
	private String major;
	private String className;
	
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
