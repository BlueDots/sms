/**
* @package_name   com.sms.abstraction.search
* @file_name SmipleSearchVo.java
* @author Administrator
* @date 2014-4-5
*/

package jxau.sms.commom.vo;

import java.util.HashMap;

/** 
 * @ClassName: SmipleSearchVo
 * @Description: TODO
 */
/**
 * @author Administrator
 *
 */
public class SimpleSearchVo {

	private String className;
	private String major;
	private String college;
	private HashMap<String,Object> conditions;
	private int rankType;	//标识排序的类型:1表示升序；0表示降序，默认为1；
	
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public HashMap<String, Object> getConditions() {
		return conditions;
	}
	public void setConditions(HashMap<String, Object> conditions) {
		this.conditions = conditions;
	}
	public int getRankType() {
		return rankType;
	}
	public void setRankType(int rankType) {
		this.rankType = rankType;
	} 
	
}
