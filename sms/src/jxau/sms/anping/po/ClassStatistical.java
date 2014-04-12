package jxau.sms.anping.po;

/**
 * 班级奖学金统计表实体表
 * 
 * @author anping 2014-4-12 TODO
 */
public class ClassStatistical {
	private String trem;//学期
	private ClassInfo classInfo;//班级
	private double oneLevel;//一等奖学金所占比例
	private double twoLevel;//二等奖学金所占比例
	private double threeLevel;//三等奖学金所占比例

	public String getTrem() {
		return trem;
	}

	public void setTrem(String trem) {
		this.trem = trem;
	}

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public double getOneLevel() {
		return oneLevel;
	}

	public void setOneLevel(double oneLevel) {
		this.oneLevel = oneLevel;
	}

	public double getTwoLevel() {
		return twoLevel;
	}

	public void setTwoLevel(double twoLevel) {
		this.twoLevel = twoLevel;
	}

	public double getThreeLevel() {
		return threeLevel;
	}

	public void setThreeLevel(double threeLevel) {
		this.threeLevel = threeLevel;
	}

}
