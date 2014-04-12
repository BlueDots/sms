package jxau.sms.anping.po;

import jxau.sms.chenjiang.stuBasicInfo.po.StuBasicInfo;
/**
 * 班级奖学金实体表
 * @author anping
 * 2014-4-12
 * TODO
 */
public class ScholarShip {
	private StuBasicInfo student;// 学号
	private String term;// 学期
	private float referencePpoint;// 基准分
	private float rewardPoint;// 奖励分
	private float penaltyPoint;// 惩罚分
	private float moralEducation;// 德育素质测评总分
	private int moralRank;// 德育素质测评总分排名
	private float coursePoint;// 学业课程分
	private float scienceTechPoint;// 科技活动与创新分
	private float skillPoint;// 职业技能分
	private float intellectualEducation;// 智育素质测评
	private int intellectualRank;// 智育素质测评班级排名
	private float physicalPoint;// 体育课程（活动）分
	private float physicalHealthPoint;// 体质健康测评分
	private float sportsCompetitionPoint;// 体育竞赛分
	private float physicaEducation;// 体育素质测评总分
	private int physicaRank;// 体育素质测评班级排名
	private float managementArtPoint;// 管理艺术分
	private float cultureArtPoint;// 文化艺术分
	private float mediaArtPoint;// 媒体艺术分
	private float practiceServicePoint;// 实践服务分
	private float aestheticEducation;// 美育素质测评总分
	private int aestheticRank;// 美育素质测评班级排名
	private float score;// 总分
	private int scoreRank;// 总分排名
	private String grade;// 奖学金等级
	private String exameState;// 审核状态

	public StuBasicInfo getStudent() {
		return student;
	}

	public void setStudent(StuBasicInfo student) {
		this.student = student;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public float getReferencePpoint() {
		return referencePpoint;
	}

	public void setReferencePpoint(float referencePpoint) {
		this.referencePpoint = referencePpoint;
	}

	public float getRewardPoint() {
		return rewardPoint;
	}

	public void setRewardPoint(float rewardPoint) {
		this.rewardPoint = rewardPoint;
	}

	public float getPenaltyPoint() {
		return penaltyPoint;
	}

	public void setPenaltyPoint(float penaltyPoint) {
		this.penaltyPoint = penaltyPoint;
	}

	public float getMoralEducation() {
		return moralEducation;
	}

	public void setMoralEducation(float moralEducation) {
		this.moralEducation = moralEducation;
	}

	public int getMoralRank() {
		return moralRank;
	}

	public void setMoralRank(int moralRank) {
		this.moralRank = moralRank;
	}

	public float getCoursePoint() {
		return coursePoint;
	}

	public void setCoursePoint(float coursePoint) {
		this.coursePoint = coursePoint;
	}

	public float getScienceTechPoint() {
		return scienceTechPoint;
	}

	public void setScienceTechPoint(float scienceTechPoint) {
		this.scienceTechPoint = scienceTechPoint;
	}

	public float getSkillPoint() {
		return skillPoint;
	}

	public void setSkillPoint(float skillPoint) {
		this.skillPoint = skillPoint;
	}

	public float getIntellectualEducation() {
		return intellectualEducation;
	}

	public void setIntellectualEducation(float intellectualEducation) {
		this.intellectualEducation = intellectualEducation;
	}

	public int getIntellectualRank() {
		return intellectualRank;
	}

	public void setIntellectualRank(int intellectualRank) {
		this.intellectualRank = intellectualRank;
	}

	public float getPhysicalPoint() {
		return physicalPoint;
	}

	public void setPhysicalPoint(float physicalPoint) {
		this.physicalPoint = physicalPoint;
	}

	public float getPhysicalHealthPoint() {
		return physicalHealthPoint;
	}

	public void setPhysicalHealthPoint(float physicalHealthPoint) {
		this.physicalHealthPoint = physicalHealthPoint;
	}

	public float getSportsCompetitionPoint() {
		return sportsCompetitionPoint;
	}

	public void setSportsCompetitionPoint(float sportsCompetitionPoint) {
		this.sportsCompetitionPoint = sportsCompetitionPoint;
	}

	public float getPhysicaEducation() {
		return physicaEducation;
	}

	public void setPhysicaEducation(float physicaEducation) {
		this.physicaEducation = physicaEducation;
	}

	public int getPhysicaRank() {
		return physicaRank;
	}

	public void setPhysicaRank(int physicaRank) {
		this.physicaRank = physicaRank;
	}

	public float getManagementArtPoint() {
		return managementArtPoint;
	}

	public void setManagementArtPoint(float managementArtPoint) {
		this.managementArtPoint = managementArtPoint;
	}

	public float getCultureArtPoint() {
		return cultureArtPoint;
	}

	public void setCultureArtPoint(float cultureArtPoint) {
		this.cultureArtPoint = cultureArtPoint;
	}

	public float getMediaArtPoint() {
		return mediaArtPoint;
	}

	public void setMediaArtPoint(float mediaArtPoint) {
		this.mediaArtPoint = mediaArtPoint;
	}

	public float getPracticeServicePoint() {
		return practiceServicePoint;
	}

	public void setPracticeServicePoint(float practiceServicePoint) {
		this.practiceServicePoint = practiceServicePoint;
	}

	public float getAestheticEducation() {
		return aestheticEducation;
	}

	public void setAestheticEducation(float aestheticEducation) {
		this.aestheticEducation = aestheticEducation;
	}

	public int getAestheticRank() {
		return aestheticRank;
	}

	public void setAestheticRank(int aestheticRank) {
		this.aestheticRank = aestheticRank;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getScoreRank() {
		return scoreRank;
	}

	public void setScoreRank(int scoreRank) {
		this.scoreRank = scoreRank;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getExameState() {
		return exameState;
	}

	public void setExameState(String exameState) {
		this.exameState = exameState;
	}

}
